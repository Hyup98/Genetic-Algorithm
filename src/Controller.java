import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class Controller extends JFrame {
	ImageIcon ClickedStart	 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/StartClick.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  ClickedPause 	 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/PauseClick.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  ClickedRestart = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/RestartClick.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  NormalStart 	 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Start.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  NormalPause 	 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Pause.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  NormalRestart  = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Restart.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)),
			  Chromosome 	 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Chromosome.png")).getImage().getScaledInstance(500,700,Image.SCALE_SMOOTH)),
			  Explain 		 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Image/Explain.png")).getImage().getScaledInstance(360, 450, Image.SCALE_SMOOTH));
	Font normalFont=new Font(null, Font.BOLD, 14);
	Font averFont=new Font(null, Font.BOLD, 16);
	private Simulation simulation;
	private final int mapWidth = 1280;
	private final int mapHeight = 820;

	public static int Acceleration = 1;
	public static double mutationRate = 50;

	private boolean stop = false;

	private JFrame controller = new JFrame();
	private JPanel masterpanel = new JPanel();
	private JTabbedPane tab;
	private JSlider slider1, slider2;
	private JTextField textfield1, textfield2;
	private JButton bt1, bt2, bt3;
	private JLabel label5, label6;
	private static JLabel geneLabel1, geneLabel2, geneLabel3;

	Controller(Simulation simulation) {
		this.simulation = simulation;
		controller.setTitle("Controller");
		controller.setSize(384, mapHeight);
		controller.setLocation(mapWidth - 10, 0);
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
		controller.setResizable(false);

		masterpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(370, 720));

		CreateMasterPanel();
		CreateAboutPanel();
		CreateControllerPanel();
		CreateGeneticPanel();

		masterpanel.add(tab);
		masterpanel.add(bt3);
		masterpanel.add(bt2);
		masterpanel.add(bt1);
		controller.add(masterpanel);
	}

	void CreateMasterPanel() {
		bt1 = new JButton(NormalStart);
		bt2 = new JButton(NormalPause);
		bt3 = new JButton(NormalRestart);
		bt1.setPressedIcon(ClickedStart);
		bt2.setPressedIcon(ClickedPause);
		bt3.setPressedIcon(ClickedRestart);
		bt1.addActionListener(new bt1ActionListener());
		bt2.addActionListener(new bt2ActionListener());
		bt3.addActionListener(new bt3ActionListener());
		bt1.setBorderPainted(false);
		bt2.setBorderPainted(false);
		bt3.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt2.setContentAreaFilled(false);
		bt3.setContentAreaFilled(false);
	}

	void CreateAboutPanel() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setOpaque(true);
		panel1.setBackground(Color.WHITE);
		

		tab.add("  About  ", panel1);
	}

	void CreateControllerPanel() {
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel label1 = new JLabel("Acceleration:");
		label1.setHorizontalAlignment(JLabel.RIGHT);
		label1.setFont(normalFont);
		label1.setBounds(0, 50, 130, 100);

		JLabel label2 = new JLabel("Num of preys:");
		label2.setHorizontalAlignment(JLabel.RIGHT);
		label2.setFont(normalFont);
		label2.setBounds(0, 150, 130, 100);

		JLabel label3 = new JLabel("Num of predators:");
		label3.setHorizontalAlignment(JLabel.RIGHT);
		label3.setFont(normalFont);
		label3.setBounds(0, 250, 130, 100);

		JLabel label4 = new JLabel("Mutation rate:");
		label4.setHorizontalAlignment(JLabel.RIGHT);
		label4.setFont(normalFont);
		label4.setBounds(0, 350, 130, 100);

		slider1 = new JSlider(JSlider.HORIZONTAL, 1, 50, 1);
		slider1.addChangeListener(new Slider1ChangeListener());
		slider1.setBounds(150, 75, 200, 50);
		label5 = new JLabel("X1");
		label5.setBounds(230, 90, 50, 50);

		textfield1 = new JTextField("50");
		textfield1.setHorizontalAlignment(JTextField.CENTER);
		textfield1.setBounds(170, 190, 150, 20);

		textfield2 = new JTextField("4");
		textfield2.setHorizontalAlignment(JTextField.CENTER);
		textfield2.setBounds(170, 290, 150, 20);

		label6 = new JLabel("50%");
		label6.setBounds(230, 390, 100, 50);
		slider2 = new JSlider(JSlider.HORIZONTAL, 1, 50000, 50000);
		slider2.addChangeListener(new Slider2ChangeListener());
		slider2.setBounds(150, 375, 200, 50);

		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(textfield1);
		panel2.add(textfield2);
		panel2.add(slider1);
		panel2.add(slider2);

		tab.add("  Controller  ", panel2);
	}

	void CreateGeneticPanel() {
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		
		JLabel imageLabel=new JLabel("");
		imageLabel.setIcon(Chromosome);
		imageLabel.setLocation(30,0);
		imageLabel.setSize(500, 700);
		panel3.add(imageLabel);
		
		geneLabel1 = new JLabel("");
		geneLabel1.setLocation(10, 130);
		geneLabel1.setSize(200, 50);
		geneLabel1.setFont(averFont);
		geneLabel2 = new JLabel("");
		geneLabel2.setLocation(10, 330);
		geneLabel2.setSize(200, 50);
		geneLabel2.setFont(averFont);
		geneLabel3 = new JLabel("");
		geneLabel3.setLocation(10, 530);
		geneLabel3.setSize(200, 50);
		geneLabel3.setFont(averFont);
		panel3.add(geneLabel1);
		panel3.add(geneLabel2);
		panel3.add(geneLabel3);
		
		tab.add("  Gene  ", panel3);
	}

	static public void averPrint(double widthAver, double heightAver,double speedAver) {
		geneLabel1.setText("AverageWidth : "	+String.format("%.5f",widthAver)+" ㅡ");
		geneLabel2.setText("AverageHeight : "	+String.format("%.5f",heightAver)+" ㅡ");
		geneLabel3.setText("AverageSpeed : "	+String.format("%.5f",speedAver)+" ㅡ");
	}

	private class Slider1ChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			label5.setText("X" + slider1.getValue());
			if (!stop)
				Acceleration = slider1.getValue();
		}
	}

	private class Slider2ChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			label6.setText(Double.toString(((double) slider2.getValue()) / 1000) + "%");
			mutationRate = ((double) slider2.getValue()) / 1000;
		}
	}

	private class bt1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop = false;
			Acceleration = slider1.getValue();
		}
	}

	private class bt2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop = true;
			Acceleration = 0;
		}
	}

	private class bt3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int text1, text2;
			text1 = Integer.parseInt(textfield1.getText());
			text2 = Integer.parseInt(textfield2.getText());
			simulation.reset(text1, text2);
		}
	}
}
