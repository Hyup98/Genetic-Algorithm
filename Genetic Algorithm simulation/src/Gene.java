public class Gene {
    private final double speed;
    //媛쒖껜 �겕湲�
    private final int radius;
    private final int activity;

    //Prey媛쒖껜媛� 踰덉떇�떆 �궗�슜
    public Gene(double speed, int radius, int activity) {
        this.speed = speed;
        this.radius = radius;
        this.activity = activity;
    }


    //Prey泥� 媛쒖껜 珥덇린�솕�떆 �궗�슜
    public Gene() {
        this.speed = ((Math.random() * (2 - 0.1)) + 0.1);
        this.radius = 10;
        this.activity = 10;
    }


    public Gene Genetic() {

        return new Gene();
    }

    public int getRadius() {
        return radius;
    }

    public double getSpeed() {
        return speed;
    }
}
