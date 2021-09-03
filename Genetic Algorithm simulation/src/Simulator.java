import java.util.ArrayList;

public class Simulator {
    private int generation;
    private int praySize;
    private int predatorSize;
    private int mapwidth;
    private int mapHight;
    private int safeZoneSize;
    private ArrayList<Prey> preys = new ArrayList<>();
    private ArrayList<Predator>predators = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    Simulator( int predatorSize, int praySize, int safeZoneSize)
    {
        //시뮬레이션 크기
        mapwidth = 500;
        mapHight = 200;
        generation = 0;
        this.praySize = praySize;
        this.predatorSize = predatorSize;
        this.safeZoneSize = safeZoneSize;

        //포식자 생성
        for(int i = 0 ; i < predatorSize; i++) {
            predators.add(new Predator());
        }

        //피식자 생성
        for(int j = 0; j < praySize; j++) {
            preys.add(new Prey());
        }

    }

    public void passOneGeneration() {

        for(int i = 0; i < preys.size(); i++) {
            preys.get(i).Move();
        }
        for(int i = 0; i < predators.size(); i++) {
            predators.get(i).Move();
            for(int j = 0; j < preys.size(); j++) {
            }
        }
        //
        for()


    }


}











