public class Predator {

    private double x;
    private double y;
    private double lastDirection;
    private int count;
    private final int activity = 1000;
    private static final int safeZoneRadius = 100;
    private static final int safeZoneX = 462;
    private static final int safeZoneY = 340;
    private final double speed = 0.8;
    private final int mapWidth = 50;
    private final int mapHight = 50;

    private final int radius = 10;

    public Predator() {
        this.count = 1;
    }

    public Predator(double x,double y) {
        this.count = 1;
        this.x=x;
        this.y=y;
    }

    public void Move() {
        System.out.print("사냥 시작\n");
        double temX;
        double temY;
        double temDic = lastDirection;
        //방향 수정
        if(activity % count == 0) {
            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
        }
        temX = x + speed * Math.cos(temDic);
        temY = y + speed * Math.sin(temDic);
        while (true) {
            System.out.print("사냥 방향 찾기\n");
            double distanceFromSafe = (double) (Math.pow((temX - safeZoneX), 2) + Math.pow((temY - safeZoneY), 2));
            distanceFromSafe = Math.sqrt(distanceFromSafe);
            if(temX > 10 && temX < 1250 && temY > 30 && temY < 790 && distanceFromSafe > safeZoneRadius + radius) {
                break;
            }

            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
            temX = x + speed * Math.cos(temDic);
            temY = y + speed * Math.sin(temDic);
        }
        count++;
        if(count < 0) {
            count = 1;
        }
        x = temX;
        y = temY;
        lastDirection = temDic;
        System.out.print("사냥 끝남\n");
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
