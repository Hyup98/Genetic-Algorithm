public class Gene {
    private final double speed;

    private final int radius;
    private final int activity;


    public Gene(double speed) {
        this.speed = speed;
        this.radius = 10;
        this.activity = 10;
    }



    public Gene() {
        this.speed = ((Math.random() * (2 - 0.05)) + 0.05);
        this.radius = 10;
        this.activity = 10;
    }


    public Gene Genetic() {
        int tem =  (int)(Math.random() * 10000);
        if(tem == 1)
        {
            int flag = (int)(Math.random() * 100);
            if(flag % 2 == 0)
            {
                double temSpeed = Math.max(0.05, this.speed + 0.1);
                return new Gene(temSpeed);
            }
            double temSpeed = Math.max(0.05, this.speed - 0.1);
            return new Gene(temSpeed);

        }
        return new Gene(speed);
    }

    public int getRadius() {
        return radius;
    }

    public double getSpeed() {
        return speed;
    }
}
