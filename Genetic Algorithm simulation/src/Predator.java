public class Predator {

    private double x;
    private double y;
    private double lastDirection;
    private boolean count;
    private static final int safeZoneRadius = 100;
    private static final int safeZoneX = 462;
    private static final int safeZoneY = 340;

    private final int mapWidth = 50;
    private final int mapHight = 50;

    private final int radius = 10;

    public Predator() {
        this.count = true;
        this.x = (double) (Math.random() * mapWidth);
        this.y = (double) (Math.random() * mapHight);
    }
    public Predator(double x,double y) {
        this.count = true;
        this.x=x;
        this.y=y;
    }
    public void Move() {
        if(count == true) {
            while(true) {
                double random = (Math.random() * 359);
                random = Math.toRadians(random);
                lastDirection = random;
                x += 0.3 * Math.cos(random);
                y += 0.3 * Math.sin(random);
                //媛쒖껜媛� 留듭쓣 踰쀬뼱�궃 寃쎌슦x
                if(x > 25 && x < 1000 && y > 0 && y < 735)
                {
                    //媛쒖껜媛� �븞�쟾吏����뿉 �엳�뒗 寃쎌슦x
                    double distanceFromSafe = (double) (Math.pow((x - safeZoneX), 2)
                            + Math.pow((y - safeZoneY), 2));
                    distanceFromSafe = Math.sqrt(distanceFromSafe);
                    if (distanceFromSafe > safeZoneRadius - radius) {
                        break;
                    }
                }

            }
            count = false;

        }
        else
        {
            x += 0.3 * Math.cos(lastDirection);
            y += 0.3 * Math.sin(lastDirection);
            double distanceFromSafe = (double) (Math.pow((x - safeZoneX), 2)
                    + Math.pow((y - safeZoneY), 2));
            distanceFromSafe = Math.sqrt(distanceFromSafe);

            if(x < 25 || x > 1000 || y < 5 || y > 735 || distanceFromSafe < safeZoneRadius - radius)
            {
                while(true) {
                    double random = (Math.random() * 359);
                    random = Math.toRadians(random);
                    lastDirection = random;
                    x += 0.3 * Math.cos(random);
                    y += 0.3 * Math.sin(random);
                    distanceFromSafe = (double) (Math.pow((x - safeZoneX), 2)
                            + Math.pow((y - safeZoneY), 2));
                    distanceFromSafe = Math.sqrt(distanceFromSafe);
                    if(x > 25 && x < 1000 && y > 0 && y < 735 && distanceFromSafe > safeZoneRadius - radius)
                    {
                        break;
                    }
                }
                count = false;
            }
        }
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
