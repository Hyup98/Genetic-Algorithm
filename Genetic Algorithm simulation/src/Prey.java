public class Prey {

    private double x;
    private double y;
    private final int mapWidth = 50;
    private final int mapHight = 50;
    private double lastDirection;
    private int count;
    private static final int safeZoneRadius = 100;
    private static final int safeZoneX = 462;
    private static final int safeZoneY = 340;
    private Gene gene;

    public Prey(double x, double y, Gene gene) {
        this.count = 1;
        this.x = x;
        this.y = y;
        this.gene = gene;
        double random = (Math.random() * 359);
        lastDirection = Math.toRadians(random);
    }


    public Prey() {
        this.count = 1;
        this.x = (int) (Math.random() * mapWidth);
        this.y = (int) (Math.random() * mapHight);
        this.gene = new Gene();
        double random = (Math.random() * 359);
        lastDirection = Math.toRadians(random);
    }
    public Prey(double x,double y) {
        this.count = 1;
    	this.x=x;
    	this.y=y;
        this.gene = new Gene();
        double random = (Math.random() * 359);
        lastDirection = Math.toRadians(random);
    }
    public void Move() {
        System.out.print("생존 시작\n");
        double temX;
        double temY;
        double temDic = lastDirection;
        //방향 수정
        if(gene.getActivity() % count == 0) {
            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
        }
        temX = x + gene.getSpeed() * Math.cos(temDic);
        temY = y + gene.getSpeed() * Math.sin(temDic);
        while (true) {
            if(temX > 10 && temX < 1250 && temY > 30 && temY < 790)
            {
                break;
            }
            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
            temX = x + gene.getSpeed() * Math.cos(temDic);
            temY = y + gene.getSpeed() * Math.sin(temDic);
        }
        count++;
        if(count < 0) {
            count = 1;
        }
        x = temX;
        y = temY;
        lastDirection = temDic;
        System.out.print("생존 끝남\n");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Prey reproduceBySelf() {
        return new Prey(x,y,gene.Genetic());
    }

    public double getRadius() {
    	return gene.getRadius();
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
}
