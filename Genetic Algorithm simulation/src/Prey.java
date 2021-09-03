public class Prey {
    //개체 위치
    private int x;
    private int y;
    private final int mapWidth = 50;
    private final int mapHight = 50;
    private Gene gene;

    //자식 번식시 사용하는 생성자
    public Prey(int x, int y, Gene gene) {
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
        //유전정보에 따라 움직인다.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Prey ReproducebySelf() {
        return new Prey(x,y,gene.Genetic());
    }

    public int getRadius() {
        return gene.getRadius();
    }
}
