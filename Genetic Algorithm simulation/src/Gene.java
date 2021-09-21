public class Gene {
    private final double speed;

    private final double radius;
    private final int activity;


    public Gene(double speed, double radius) {
        this.speed = speed;
        this.radius = radius;
        this.activity = 10;
    }



    public Gene() {
        this.speed = ((Math.random() * (2 - 0.05)) + 0.05);
        this.radius = 10;
        this.activity = 10;
    }


    public Gene Genetic() {
        int tem =  (int)(Math.random() * 10000);
        if(tem != 1)
        {
            int flag = (int)(Math.random() * 100);
            if(flag % 2 == 0)
            {
                double temSpeed = Math.max(0.05, this.speed + 0.1);
                double temRadius = Math.max(0.05, this.radius + 5);
                return new Gene(temSpeed, temRadius);
            }
            double temSpeed = Math.max(0.05, this.speed - 0.1);
            double temRadius = Math.max(0.05, this.radius + 2);
            return new Gene(temSpeed, temRadius);

        }
        return new Gene(speed, this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public double getSpeed() {
        return speed;
    }
}
