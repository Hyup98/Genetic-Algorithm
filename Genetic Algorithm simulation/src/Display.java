
//this
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {

	Image buffImg;
	Graphics buffG;

	Controller controller;
	private int genrationCount;
	private static final int mapWidth = 1280;
	private static final int mapHeight = 820;
	private static final int safeZoneRadius = 100;
	private static final int safeZoneX = mapWidth / 2 - safeZoneRadius / 2;
	private static final int safeZoneY = mapHeight / 2 - safeZoneRadius / 2;
	private int generation = 0;
	private int preySize = 50;
	private int predatorSize = 4;
	private ArrayList<Prey> preys = new ArrayList<>();
	private ArrayList<Predator> predators = new ArrayList<>();

	public void start() {
		Timer timer = new Timer(0, (ae) -> repaint());
		timer.setDelay(5);
		timer.start();
	}

	public static void main(String[] args) {
		new Display().start();
	}

	Display() {	
		this.setTitle("GeneticSimulation");
		this.setSize(mapWidth, mapHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		new Controller();
		arrangement();
	}

	public void arrangement() {
		genrationCount = 1;
		double x, y;
		for (int i = 0; i < predatorSize; i++) {
			x = (Math.random() * (mapWidth - 30)) + 10;
			y = (Math.random() * (mapHeight - 60)) + 30;
			predators.add(new Predator(x, y));
		}
		for (int j = 0; j < preySize; j++) {
			x = (Math.random() * (mapWidth - 30)) + 10;
			y = (Math.random() * (mapHeight - 60)) + 30;
			preys.add(new Prey(x, y));
		}
	}

	@Override
	public void paint(Graphics g) {
		buffImg = createImage(getWidth(), getHeight());
		buffG = buffImg.getGraphics();
		update(g);
	}

	@Override
	public void update(Graphics g) {
		double distance;
		buffG.clearRect(0, 0, mapWidth, mapHeight);
		buffG.setColor(Color.GREEN);
		buffG.fillOval(safeZoneX, safeZoneY, safeZoneRadius, safeZoneRadius);
		
		double x;
		double y;
		for (int i = 0; i < preySize; i++) {
			preys.get(i).Move();
			x = preys.get(i).getX();
			y = preys.get(i).getY();
			buffG.setColor(Color.BLACK);
			buffG.fillOval((int) x, (int) y, (int) preys.get(i).getRadius(), (int) preys.get(i).getRadius());
		}

		for (int i = 0; i < predatorSize; i++) {
			predators.get(i).Move();
			x = predators.get(i).getX();
			y = predators.get(i).getY();

			for (int j = 0; j < preySize; j++) {
				distance = (double) (Math.pow((predators.get(i).getX() - preys.get(j).getX()), 2)
									+ Math.pow((predators.get(i).getY() - preys.get(j).getY()), 2));
				distance = Math.sqrt(distance);

				if (distance <= preys.get(j).getRadius() + predators.get(i).getRadius()) {
					preys.remove(j);
					preySize--;
				}
			}
			buffG.setColor(Color.RED);
			buffG.fillOval((int) x, (int) y, predators.get(i).getRadius(), predators.get(i).getRadius());
		}
		genrationCount++;
		//
		if (genrationCount * controller.Acceleration >= 2000) {

			int temNum = preySize;
			generation++;
			if (preySize < 300) {
				int probability;
				for (int t = 0; t < temNum; t++) {
					probability = (int) (Math.random() * 10 + 1);
					if (probability > 5) {
						if (!preys.get(t).isBreedingComplete()) {
							Prey tem = preys.get(t).reproduceBySelf();
							preys.add(tem);
							preySize++;
							buffG.setColor(Color.BLACK);
							buffG.fillOval((int) tem.getX(), (int) tem.getY(), (int) tem.getRadius(), (int) tem.getRadius());
						}
					}
				}
			}
			genrationCount = 0;
		}

		buffG.setColor(Color.BLACK);
		buffG.setFont(new Font("고딕체", Font.BOLD, 15));
		buffG.drawString("Generation : " + Integer.toString(generation), 20, 50);
		buffG.drawString("남은 개체 수 : " + Integer.toString(preySize), 20,70);
		g.drawImage(buffImg, 0, 0, this);
		super.repaint();
	}
}
