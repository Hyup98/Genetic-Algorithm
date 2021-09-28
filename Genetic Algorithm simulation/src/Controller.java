import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class Controller extends JFrame {
	private static final int mapWidth = 1280;
	private static final int mapHeight = 820;

	public static int Acceleration = 1;
	private boolean stop =false;

	private JFrame controller = new JFrame();
	private JPanel masterpanel = new JPanel();
	private JTabbedPane tab;
	private JPanel panel1;
	private JPanel panel2;
	private JSlider slider1;
	private JSlider slider2;
	private JButton bt1;
	private JButton bt2;
	Controller() {
		controller.setTitle("Controller");
		controller.setSize(384, mapHeight);
		controller.setLocation(mapWidth - 10, 0);
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
		controller.setResizable(false);
		masterpanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));
		tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(370,720));

		CreateMasterPanel();
		CreateAboutPanel();
		CreateControllerPanel();

		masterpanel.add(tab);
		masterpanel.add(bt2);
		masterpanel.add(bt1);

		controller.add(masterpanel);
	}
	void CreateMasterPanel() {
		ImageIcon img1 = new ImageIcon("playbutton_121290.png");
		ImageIcon img2 = new ImageIcon("pause_121328.png");
		ImageIcon displayImage1 = new ImageIcon(img1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		ImageIcon displayImage2 = new ImageIcon(img2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		bt1 = new JButton(displayImage1);
		bt2 = new JButton(displayImage2);
		bt1.addActionListener(new bt1ActionListener());
		bt2.addActionListener(new bt2ActionListener());
		bt1.setBorderPainted(false);
		bt2.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt2.setContentAreaFilled(false);
	}
	void CreateAboutPanel() {
		panel2=new JPanel();

		JTextArea textarea = new JTextArea("text", 19, 14);
		textarea.setPreferredSize(new Dimension(364,690));
		textarea.setFont(new Font(null, Font.BOLD, 20));
		textarea.setEditable(false);

		panel2.add(textarea);
		tab.add("About",panel2);
	}
	void CreateControllerPanel() {
		panel2=new JPanel();
		panel2.setLayout(null);

		JLabel label1=new JLabel("            Acceleration:");
		label1.setFont(new Font(null, Font.HANGING_BASELINE, 13));
		label1.setBounds(10, 50, 150, 100);

		JLabel label2=new JLabel("      Number of preys:");
		label2.setFont(new Font(null, Font.HANGING_BASELINE, 13));
		label2.setBounds(10, 150, 150, 100);

		JLabel label3=new JLabel("Number of predators:");
		label3.setFont(new Font(null, Font.HANGING_BASELINE, 13));
		label3.setBounds(10, 250, 150, 100);

		JLabel label4=new JLabel(" 	         Mutation rate:");
		label4.setFont(new Font(null, Font.HANGING_BASELINE, 13));
		label4.setBounds(10, 350, 150, 100);

		JLabel label5=new JLabel("            Variant rate:");
		label5.setFont(new Font(null, Font.HANGING_BASELINE, 13));
		label5.setBounds(10, 450, 150, 100);

		slider1=new JSlider(JSlider.HORIZONTAL,1,51,1);
		slider1.addChangeListener(new MyChangeListener());
		slider1.setMinorTickSpacing(1);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setBounds(150, 90, 200, 50);

		JTextField textfield1=new JTextField("50");
		textfield1.setHorizontalAlignment(JTextField.CENTER);
		textfield1.setBounds(200, 190, 100, 25);

		JTextField textfield2=new JTextField("4");
		textfield2.setHorizontalAlignment(JTextField.CENTER);
		textfield2.setBounds(200, 290, 100, 25);

		JSlider slider2=new JSlider(JSlider.HORIZONTAL,1,5001,100);
		slider2.setFont(new Font(null, Font.HANGING_BASELINE, 8));
		slider2.setMinorTickSpacing(10);
		slider2.setMajorTickSpacing(500);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setBounds(150, 390, 200, 50);

		JSlider slider3=new JSlider(JSlider.HORIZONTAL,1,11,1);
		slider3.setMinorTickSpacing(1);
		slider3.setMajorTickSpacing(5);
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		slider3.setBounds(150, 490, 200, 50);

		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(textfield1);
		panel2.add(textfield2);
		panel2.add(slider1);
		panel2.add(slider2);
		panel2.add(slider3);

		tab.add("Controller",panel2);
	}
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			if(!stop) Acceleration =slider1.getValue();
		}
	}
	private class bt1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop=false;
			Acceleration = slider1.getValue();
		}
	}

	private class bt2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop=true;
			Acceleration = 0;
		}
	}
}
