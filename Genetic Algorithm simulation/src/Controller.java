import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Controller extends JFrame{
	private static final int mapWidth = 1280;
	private static final int mapHeight = 820;
	public static int Acceleration = 1;
	private boolean Stop = false;
	JFrame controller = new JFrame();
	JTextField textfield;
	Controller(){
		controller.setTitle("Controller");
		controller.setSize(384, mapHeight);
		controller.setLocation(mapWidth - 10, 0);
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
		controller.setResizable(false);
		
		CreateContents();
	}
	void CreateContents() {
		JTextArea textarea = new JTextArea("text", 19, 14);
		textfield = new JTextField("1");
		ImageIcon img1 = new ImageIcon("playbutton_121290.png");
		ImageIcon img2 = new ImageIcon("pause_121328.png");
		ImageIcon displayImage1 = new ImageIcon(img1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		ImageIcon displayImage2 = new ImageIcon(img2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		JButton bt1 = new JButton(displayImage1);
		bt1.addActionListener(new bt1ActionListener());
		JButton bt2 = new JButton(displayImage2);
		bt2.addActionListener(new bt2ActionListener());

		textarea.setSize(300, 500);
		textfield.setSize(120, 30);
		textarea.setLocation(30, 30);
		textfield.setLocation(50, mapHeight - 100);
		textarea.setFont(new Font(null, Font.BOLD, 20));
		textfield.setFont(new Font(null, Font.BOLD, 20));
		textarea.setEditable(false);

		bt1.setBorderPainted(false);
		bt2.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt2.setContentAreaFilled(false);
		bt1.setSize(30, 30);
		bt2.setSize(30, 30);
		bt1.setLocation(300, mapHeight - 100);
		bt2.setLocation(250, mapHeight - 100);

		Container c = getContentPane();
		c.setLayout(null);
		c.add(bt1);
		c.add(bt2);
		c.add(textarea);
		c.add(textfield);
		controller.add(c);
	}
	private class bt1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Acceleration = Integer.parseInt(textfield.getText());
		}
	}
	private class bt2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(Stop==false) 
				Acceleration = 0;
			else 
				Acceleration =Integer.parseInt(textfield.getText());
			Stop=!Stop;
		}
	}
}
