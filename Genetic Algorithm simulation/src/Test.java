import java.awt.*;
import java.lang.Thread;
import java.util.ArrayList;
public class Test {
    private int generation = 0;
    private int preySize = 30;
    private int predatorSize = 4;
    private int callMoveCount;
    private int genrationCount;
    private static final int mapWidth = 1024;
    private static final int mapHeight = 760;
    private static final int safeZoneRadius = 100;
    private static final int safeZoneX = 462;
    private static final int safeZoneY = 340;
    private ArrayList<Prey> preys = new ArrayList<>();
    //Prey[] preys;
    private ArrayList<Predator> predators = new ArrayList<>();
    //Predator[] predators;

    public Test() {
        genrationCount = 1;
        /*
        predators = new Predator[predatorSize];
        double x, y;
        for (int i = 0 ; i < predatorSize; i++) {
            predators[i] = new Predator();
            x = (Math.random() * (mapWidth - 30)) + 10;
            y = (Math.random() * (mapHeight - 60)) + 30;
            predators[i].setX(x);
            predators[i].setY(y);
        }
        preys = new Prey[500];

        for (int j = 0 ; j < preySize; j++) {
            preys[j] = new Prey();
            x = (Math.random() * (mapWidth - 30)) + 10;
            y = (Math.random() * (mapHeight - 60)) + 30;
            preys[j].setX(x);
            preys[j].setY(y);
        }
         */
        double x, y;
        for (int i = 0 ; i < predatorSize; i++) {
            x = (Math.random() * (mapWidth - 30)) + 10;
            y = (Math.random() * (mapHeight - 60)) + 30;
            predators.add(new Predator(x,y));
        }


        for (int j = 0 ; j < preySize; j++) {
            //x = (Math.random() * (mapWidth - 30)) + 10;
            //y = (Math.random() * (mapHeight - 60)) + 30;
            x = 200;
            y = 100;
            preys.add(new Prey(x,y));
        }
    }

    public void Run() {
        while (true) {
            System.out.print("진입\n");
            double distance;
            double distanceFromSafe;
            double x;
            double y;

            //먹이 1move 호출 + 그리기
            for(int i = 0 ; i < preySize; i++)
            {
                System.out.print(preySize - i + " \n");
                preys.get(i).Move();
                x = preys.get(i).getX();
                y = preys.get(i).getY();
            }
            System.out.print("진입_1\n");
            //포식자 1move 호출 + 피식자 번식 후 그리기
            for (int i = 0; i < predatorSize; i++) {
                predators.get(i).Move();
                x = predators.get(i).getX();
                y = predators.get(i).getY();

                for (int j = 0; j < preySize; j++) {
                    distance = (double) (Math.pow((predators.get(i).getX() - preys.get(j).getX()),2)
                            + Math.pow((predators.get(i).getY() - preys.get(j).getY()),2));
                    distance = Math.sqrt(distance);

                    if (distance <= preys.get(j).getRadius() + predators.get(i).getRadius()) {
                        //System.out.println("(i : "+ i +", j : "+ j +")");
                        preys.remove(j);
                        preySize--;
                    }
                }
            }

            genrationCount++;
            System.out.print(genrationCount +"세대 지남\n");

            if(genrationCount % 5000 == 0) {
                int temNum = preySize;
                int count = temNum;
                System.out.print("<번식 시작>\n");
                for (int t = 0; t < temNum ; t++) {
                    Prey tem = preys.get(t).reproduceBySelf();
                    preys.add(tem);
                    System.out.print(count+"\n");
                    preySize++;
                    count--;
                }
                if(genrationCount == 5000) {
                    genrationCount = 0;
                }
                System.out.print("프로그램 탈출\n");
            }


        }
    }
    public static void main(String[] args) {
        Test tem = new Test();
        tem.Run();

    }
}
