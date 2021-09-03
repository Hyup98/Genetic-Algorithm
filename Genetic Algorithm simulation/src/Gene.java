public class Gene {
    private final int speed;
    //개체 크기
    private final int hight;
    private final int width;
    private final int activity;

    //Prey개체가 번식시 사용
    public Gene(int speed, int hight, int width, int activity) {
        this.activity = activity;
        this.width = width;
        this.hight = hight;
        this.speed = speed;
    }


    //Prey첫 개체 초기화시 사용
    public Gene() {
        this.speed = 10;
        this.hight = 10;
        this.width = 10;
        this.activity = 10;
    }

    //자기 유전자를 바탕으로 자식 유전자 생성 ->돌연변이 등등 고려
    public Gene Genetic() {

        return new Gene();
    }

}
