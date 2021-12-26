import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class Lancher extends JFrame {
	ImageIcon SimulationImage[] = {new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Sample.png")).getImage().getScaledInstance(380, 425, Image.SCALE_SMOOTH)),
								   new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/LExplain.png")).getImage().getScaledInstance(380, 425, Image.SCALE_SMOOTH))};
	Font normalFont = new Font("SansSerif", Font.BOLD, 15);
	String ItemName[] = { " Genetic Algorithm Program" };
	final int imageCoordinate[] = {280, 30, 380, 425};
	int selectedIndex=-1;
	JLabel imgLabel=new JLabel();
	JList<?> list1;
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
		list1.setFont(normalFont);
		list1.setFixedCellHeight(50);
		list1.setFixedCellWidth(50);
		JScrollPane list1_scroll = new JScrollPane(list1);
		c.add(list1_scroll);
		list1.addListSelectionListener(new SelectionListener());
		list1_scroll.setBounds(25, 30, 250, 425);
		
		c.add(imgLabel);
		imgLabel.setIcon(SimulationImage[0]);
		imgLabel.setBounds(imageCoordinate[0], imageCoordinate[1], imageCoordinate[2], imageCoordinate[3]);
		
		JButton bt1 = new JButton("Select");
		bt1.setFont(normalFont);
		c.add(bt1);
		bt1.addActionListener(new bt1ActionListener());
		bt1.setBounds(225, 475, 90, 40);
		
		JButton bt2=new JButton("Quit");
		bt2.setFont(normalFont);
		c.add(bt2);
		bt2.addActionListener(new bt2ActionListener());
		bt2.setBounds(350, 475, 90, 40);
	}
	
	private class SelectionListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			selectedIndex = list1.getSelectedIndex();
			imgLabel.setIcon(SimulationImage[selectedIndex+1]);
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
