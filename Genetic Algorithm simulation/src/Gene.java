public class Gene {
    private final int speed;
    //개체 크기
    private final int radius;
    //onewMove가 호출 시 move함수 호출 전 휴식 기간
    private final int activity;
    //이동시 직진하는 빈도 수->n번 직진 후 방향수정
    private final int straightness;
    private final double rateOfMtation = 0.01;

    //Prey개체가 번식시 사용
    public Gene(int speed, int radius, int activity) {
        this.activity = activity;
        this.radius = radius;
        this.speed = speed;
    }


    //Prey첫 개체 초기화시 사용
    public Gene() {
        this.speed = 10;
        this.radius = 10;
        this.activity = 10;
    }

    //자기 유전자를 바탕으로 자식 유전자 생성 ->돌연변이 등등 고려
    public Gene Genetic() {

        return new Gene();
    }

    public int getRadius() {
        return radius;
    }
}
