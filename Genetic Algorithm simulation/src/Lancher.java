import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Lancher extends JFrame {
	ImageIcon SimulationImage[] = {new ImageIcon(new ImageIcon("Sample.png").getImage().getScaledInstance(380, 425, Image.SCALE_SMOOTH)),
			new ImageIcon(new ImageIcon("pause_121328.png").getImage().getScaledInstance(380, 425, Image.SCALE_SMOOTH))};
	String ItemName[] = { " Genetic Algorithm Program" };
	String ItemText[]= {"asdf\nasdfasdfasdf"};
	final int imageCoordinate[] = {280, 30, 380, 425};
	int selectedIndex=-1;
	JLabel img;
	JList list1;
	JTextArea area1;
	public static void main(String[] args) {
		new Lancher();
	}
	Lancher() {
		setTitle("Lancher");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		Container c = getContentPane();
		c.setLayout(null);

		list1 = new JList(ItemName);
		list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list1.setFont(new Font("고딕체", Font.HANGING_BASELINE, 15));
		list1.setFixedCellHeight(50);
		list1.setFixedCellWidth(50);
		JScrollPane list1_scroll = new JScrollPane(list1);
		c.add(list1_scroll);
		list1.addListSelectionListener(new SelectionListener());
		list1_scroll.setBounds(25, 30, 250, 425);

		img=new JLabel();
		c.add(img);
		img.setIcon(SimulationImage[0]);
		img.setBounds(imageCoordinate[0], imageCoordinate[1], imageCoordinate[2], imageCoordinate[3]);

		/*
		area1 = new JTextArea(" ", 30, 30);
		area1.setFont(new Font("고딕체", Font.BOLD, 20));
		JScrollPane area1_scroll = new JScrollPane(area1);
		c.add(area1_scroll);
		area1_scroll.setBounds(280, 30, 380, 425);
		*/
		JButton bt1 = new JButton("Select");
		bt1.setFont(new Font("고딕체", Font.BOLD, 15));
		c.add(bt1);
		bt1.addActionListener(new bt1ActionListener());
		bt1.setBounds(225, 475, 90, 40);

		JButton bt2=new JButton("Quit");
		bt2.setFont(new Font("고딕체", Font.BOLD, 15));
		c.add(bt2);
		bt2.addActionListener(new bt2ActionListener());
		bt2.setBounds(350, 475, 90, 40);
	}

	private class SelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			selectedIndex = list1.getSelectedIndex();
			img.setIcon(SimulationImage[selectedIndex+1]); //test
			//area1.setText(ItemText[selectedIndex]);
		}
	}
	private class bt1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (selectedIndex) {
				case 0:
					new Simulation();
					dispose();
					break;
				default :
					JOptionPane.showMessageDialog(null, "Select program");
					break;
			}
		}
	}
	private class bt2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
