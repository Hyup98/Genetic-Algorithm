public class Prey {

    private double x;
    private double y;
    private final int mapWidth = 50;
    private final int mapHight = 50;
    private double lastDirection;
    private boolean count;
    private static final int safeZoneRadius = 100;
    private static final int safeZoneX = 462;
    private static final int safeZoneY = 340;
    private Gene gene;

    public Prey(double x, double y, Gene gene) {
        this.count = true;
        this.x = x;
        this.y = y;
        this.gene = gene;
    }


    public Prey() {
        this.count = true;
        this.x = (int) (Math.random() * mapWidth);
        this.y = (int) (Math.random() * mapHight);
        this.gene = new Gene();
    }
    public Prey(double x,double y) {
        this.count = true;
    	this.x=x;
    	this.y=y;
        this.gene = new Gene();
    }
    public void Move() {
        if(count == true) {
            while(true) {
                double random = (Math.random() * 359);
                random = Math.toRadians(random);
                lastDirection = random;
                x += gene.getSpeed() * Math.cos(random);
                y += gene.getSpeed() * Math.sin(random);

                //맵을 벗어나지 않는 경우
                if(x > 25 && x < 1000 && y > 0 && y < 735) {
                    break;
                }

            }
            count = false;
        }
        else
        {
            x += gene.getSpeed() * Math.cos(lastDirection);
            y += gene.getSpeed() * Math.sin(lastDirection);
            double distanceFromSafe = (double) (Math.pow((x - safeZoneX), 2)
                    + Math.pow((y - safeZoneY), 2));
            distanceFromSafe = Math.sqrt(distanceFromSafe);

            if(x < 25 || x > 1000 || y < 5 || y > 735)
            {
                while(true) {
                    double random = (Math.random() * 359);
                    random = Math.toRadians(random);
                    lastDirection = random;
                    x += gene.getSpeed() * Math.cos(random);
                    y += gene.getSpeed() * Math.sin(random);

                    break;
                }
                count = false;
            }
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Prey ReproducebySelf() {
        return new Prey(x,y,gene.Genetic());
    }

    public int getRadius() {
        //return gene.getRadius();
    	return 10;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
}
