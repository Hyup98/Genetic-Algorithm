import java.util.ArrayList;

public class Simulator {
    private int generation;
    private int praySize;
    private int predatorSize;
    private int mapwidth;
    private int mapHight;
    private int safeZoneRadius;
    private int safeZoneX;
    private int safeZoneY;
    private int callMoveCount;
    private ArrayList<Prey> preys = new ArrayList<>();
    private ArrayList<Predator>predators = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    Simulator( int predatorSize, int praySize, int safeZoneRadius, int safeZoneX, int safeZoneY)
    {
        //시뮬레이션 크기
        mapwidth = 500;
        mapHight = 200;
        generation = 0;
        this.praySize = praySize;
        this.predatorSize = predatorSize;
        this.safeZoneY = safeZoneY;
        this.safeZoneX = safeZoneX;
        this.safeZoneRadius = safeZoneRadius;

        //포식자 생성
        for(int i = 0 ; i < predatorSize; i++) {
            predators.add(new Predator());
        }

        //피식자 생성
        for(int j = 0; j < praySize; j++) {
            preys.add(new Prey());
        }

    }

    //1세대 지남 -> 10Move함수
    //해야할 것
    //1) move함수에서 개체의 움직임을 잘 정의해야됨 -> 속도 활동성을 어떻게 표현할지
    public void oneMove() {
        double distance;
        double distanceFromSafe;

        for(int i = 0; i < preys.size(); i++) {
            preys.get(i).Move();
        }

        for(int i = 0; i < predators.size(); i++) {
            predators.get(i).Move();
            //지금은 각 개체의 중심거리를 가지고 먹었는지 안 먹었는지를 판단한다
            //먹는 알고리즘 구현
            for(int j = 0; j < preys.size(); j++) {
                distance = (double) (predators.get(i).getX() - preys.get(j).getX()) * (predators.get(i).getX() - preys.get(j).getX())
                        + (predators.get(i).getY() - preys.get(j).getY()) * (predators.get(i).getY() - preys.get(j).getY());
                distance = Math.sqrt(distance);
                distanceFromSafe = (double)(safeZoneX - preys.get(j).getX()) * (safeZoneX - preys.get(j).getX())
                        +(safeZoneY - preys.get(j).getY()) * (safeZoneY - preys.get(j).getY());
                distanceFromSafe = Math.sqrt(distanceFromSafe);

                //안전구역 안에 개체가 존재하는 경우
                if((safeZoneRadius - preys.get(j).getRadius()) <= distanceFromSafe) {
                    continue;
                }

                if(distance <= predators.get(i).getRadius() + preys.get(j).getRadius()) {
                    preys.remove(j);
                }
            }
        }
        callMoveCount++;
        if(callMoveCount == 10) {
            generation++;
            callMoveCount = 0;
        }
    }


}











