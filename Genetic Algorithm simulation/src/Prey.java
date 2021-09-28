public class Prey {
	
    private double x;
    private double y;
    private final int mapWidth = 50;
    private final int mapHight = 50;
    private double lastDirection;
    private int count;
    private Controller controller;
    private Gene gene;
    private boolean breedingComplete;
    private int countdescendent;

    public Prey(double x, double y, Gene gene) {
        this.count = 1;
        this.x = x;
        this.y = y;
        this.gene = gene;
        double random = (Math.random() * 359);
        lastDirection = Math.toRadians(random);
        breedingComplete = false;
        countdescendent = 0;
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
        double temX;
        double temY;
        double temDic = lastDirection;
        if( count % gene.getActivity() == 0) {
            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
        }
        temX = x + gene.getSpeed() * Math.cos(temDic) * Controller.Acceleration;
        temY = y + gene.getSpeed() * Math.sin(temDic) * Controller.Acceleration;
        while (true) {
            if(temX > 10 && temX < 1250 && temY > 30 && temY < 790) {
                break;
            }
            double random = (Math.random() * 359);
            temDic = Math.toRadians(random);
            temX = x + gene.getSpeed() * Math.cos(temDic) * Controller.Acceleration;
            temY = y + gene.getSpeed() * Math.sin(temDic) * Controller.Acceleration;
        }
        count++;
        if(count < 0) {
            count = 1;
        }
        x = temX;
        y = temY;
        lastDirection = temDic;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Prey reproduceBySelf() {
        countdescendent++;
        return new Prey(x,y,gene.Genetic(50));
    }

    public boolean isBreedingComplete() {
        if (countdescendent < 3) {
            return false;
        }
        return true;
    }

    public double getRadius() {
        return gene.getRadius();
    }
}
