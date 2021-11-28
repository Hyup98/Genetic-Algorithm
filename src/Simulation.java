import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Simulation extends JFrame {
    private final int mapWidth = 1280;
    private final int mapHeight = 820;
    private final int safeZoneRadius = 150;
    private final int safeZoneX = mapWidth / 2 - safeZoneRadius / 2;
    private final int safeZoneY = mapHeight / 2 - safeZoneRadius / 2;
    private final int maxPreySize = 800;
    private final double[] average = new double[4];
    private final ArrayList<Prey> preys;
    private final ArrayList<Predator> predators;
    Image buffImg;
    Graphics2D buffG;
    private int genrationCount;
    private int generation = 0;
    private int preySize = 50;// 50
    private int predatorSize = 4;// 4

    Simulation() {
        preys = new ArrayList<>(maxPreySize);
        predators = new ArrayList<>(predatorSize);
        this.setTitle("GeneticSimulation");
        this.setSize(mapWidth, mapHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        new Controller(this);
        arrangement(preySize, predatorSize);
    }

    public static void main(String[] args) {
        new Simulation().start();
    }

    public void reset(int preySize, int predatorSize) {
        generation = 0;
        genrationCount = 0;
        preys.clear();
        predators.clear();
        this.preySize = preySize;
        this.predatorSize = predatorSize;
        arrangement(this.preySize, this.predatorSize);
    }

    public void start() {
        Timer timer = new Timer(0, (ae) -> repaint());
        timer.setDelay(5);
        timer.start();
    }

    public void arrangement(int preySize, int predatorSize) {
        genrationCount = 1;
        for (int i = 0; i < predatorSize; i++)
            predators.add(new Predator());
        for (int j = 0; j < preySize; j++)
            preys.add(new Prey());
    }

    public int dot(float x1, float y1, float x2, float y2) {
        return (int) ((x1 * x2) + (y1 * y2));
    }

    public boolean isIn(Prey tem, Predator predator) {
        float[] tempX = tem.hitPointX();
        float[] tempY = tem.hitPointY();

        float xAB = tempX[0] - tempX[1];
        float xAM = predator.getX() + 18 - tempX[1];
        float xBC = tempX[3] - tempX[0];
        float xBM = predator.getX() + 18 - tempX[0];

        float yAB = tempY[0] - tempY[1];
        float yAM = predator.getY() + 18 - tempY[1];
        float yBC = tempY[3] - tempY[0];
        float yBM = predator.getY() + 18 - tempY[0];

        float dotABAM = dot(xAB, yAB, xAM, yAM);
        float dotABAB = dot(xAB, yAB, xAB, yAB);
        float dotBCBM = dot(xBC, yBC, xBM, yBM);
        float dotBCBC = dot(xBC, yBC, xBC, yBC);

        return (0 <= dotABAM && dotABAM <= dotABAB && 0 <= dotBCBM && dotBCBM <= dotBCBC);
    }

    @Override
    public void paint(Graphics g) {
        buffImg = createImage(getWidth(), getHeight());
        buffG = (Graphics2D) buffImg.getGraphics();
        update(g);
        Runtime.getRuntime().gc();
    }

    @Override
    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        buffG.clearRect(0, 0, mapWidth, mapHeight);
        buffG.setColor(Color.GREEN);
        buffG.fillOval(safeZoneX, safeZoneY, safeZoneRadius + 30, safeZoneRadius + 30);

        int[] tempX = new int[4];
        int[] tempY = new int[4];

        //int TX[]=new int[4];
        //int TY[]=new int[4];
        buffG.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            average[i] = 0;
        }
        for (int i = 0; i < preys.size(); i++) {
            preys.get(i).Move();
            average[0] += preys.get(i).getWidth();
            average[1] += preys.get(i).getHeight();
            average[2] += preys.get(i).getSpeed();
            average[3] += preys.get(i).SgetActivity();

            float[] tempx = preys.get(i).getX();
            float[] tempy = preys.get(i).getY();

            //float tX[]=preys.get(i).hitPointX();
            //float tY[]=preys.get(i).hitPointY();
            for (int j = 0; j < 4; j++) {
                tempX[j] = (int) tempx[j];
                tempY[j] = (int) tempy[j];

                //TX[j]=(int)tX[j];
                //TY[j]=(int)tY[j];
            }

            buffG.fillPolygon(tempX, tempY, 4);
            //buffG.drawPolygon(TX,TY,4);
        }

        Controller.averPrint(average[0] / preys.size(), average[1] / preys.size(), average[2] / preys.size(), average[3] / preys.size());

        for (int i = 0; i < predators.size(); i++) {
            predators.get(i).Move();
            for (int j = 0; j < preys.size(); j++) {
                if (isIn(preys.get(j), predators.get(i)))
                    preys.remove(j);
            }
            buffG.setColor(Color.RED);
            buffG.fillOval((int) predators.get(i).getX(), (int) predators.get(i).getY(), predators.get(i).getRadius(), predators.get(i).getRadius());
        }
        if (Controller.Acceleration != 0)
            genrationCount++;

        if (genrationCount * Controller.Acceleration >= 2000) {
            int temNum = preys.size();
            generation++;
            if (preys.size() < maxPreySize) {
                int probability;
                for (int t = 0; t < temNum; t++) {
                    probability = (int) (Math.random() * 10 + 1);
                    if (probability > 5) {
                        if (!preys.get(t).isBreedingComplete()) {
                            Prey tem = preys.get(t).reproduceBySelf();
                            preys.add(tem);
                        }
                    }
                }
            }
            genrationCount = 0;
            //Runtime.getRuntime().gc();
        }
        buffG.setColor(Color.BLACK);
        buffG.setFont(new Font("SansSerif", Font.BOLD, 15));
        buffG.drawString("Generation : " + generation, 20, 50);
        buffG.drawString("number of preys : " + preys.size(), 20, 70);
        g2d.drawImage(buffImg, 0, 0, this);
        System.out.println(preys.size());

        super.repaint();
    }
}
