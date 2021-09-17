public class Prey {
    //개체 위치
    private double x;
    private double y;
    private final int mapWidth = 50;
    private final int mapHight = 50;
    private Gene gene;

    //자식 번식시 사용하는 생성자
    public Prey(double x, double y, Gene gene) {
        this.x = x;
        this.y = y;
        this.gene = gene;
    }

    //첫 Prey생성시 사용
    public Prey() {
        this.x = (int) (Math.random() * mapWidth);
        this.y = (int) (Math.random() * mapHight);
        this.gene = new Gene();
    }

    public void Move() {
        //물체가 바라보는 방향
        double random = (Math.random() * 359);
        random = Math.toRadians(random);
        x = x + gene.getSpeed() * Math.cos(random);
        y = y + gene.getSpeed() * Math.sin(random);


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
        return gene.getRadius();
    }
}
