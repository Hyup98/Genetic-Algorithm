
public class Predator {
    //개체 위치
    private int x;
    private int y;
    //시뮬레이션 맵 크기
    private final int mapWidth = 50;
    private final int mapHight = 50;
    //개체 크기
    private final int hight = 2;
    private final int width = 2;

    public Predator() {
        this.x = (int) (Math.random() * mapWidth);
        this.y = (int) (Math.random() * mapHight);
    }

    public void Move() {
        //움직임 알고리즘에 의해 작성
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
