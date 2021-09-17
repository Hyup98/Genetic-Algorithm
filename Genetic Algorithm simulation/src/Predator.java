public class Predator {
    //개체 위치
    private double x;
    private double y;
    //시뮬레이션 맵 크기
    private final int mapWidth = 50;
    private final int mapHight = 50;
    //개체 크기
    private final int radius = 2;

    public Predator() {
        this.x = (double) (Math.random() * mapWidth);
        this.y = (double) (Math.random() * mapHight);
    }

    public void Move() {
        double random = (Math.random() * 359);
        random = Math.toRadians(random);
        x = x + 10 * Math.cos(random);
        y = y + 10 * Math.sin(random);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public int getRadius() {
        return radius;
    }
}
