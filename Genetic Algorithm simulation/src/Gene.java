public class Gene {
    private final double speed;

    private final double radius;
    private final int activity;


    public Gene(double speed, double radius, int activity) {
        this.speed = speed;
        this.radius = radius;
        this.activity = activity;
    }



    public Gene() {
        this.speed = ((Math.random() * (2 - 0.05)) + 0.05);
        this.radius = 15;
        this.activity = 100;
    }


    public Gene Genetic() {
        int tem =  (int)(Math.random() * 10000);
        if(tem == 1)
        {
            int flag = (int)(Math.random() * 100);
            if(flag % 2 == 0)
            {
                double temSpeed = Math.max(0.05, this.speed + 0.1);
                double temRadius = Math.max(0.05, this.radius + 5);
                int temActivity = Math.min(1,this.activity + 1);
                return new Gene(temSpeed, temRadius,temActivity);
            }
            double temSpeed = Math.max(0.05, this.speed - 0.1);
            double temRadius = Math.max(0.05, this.radius - 5);
            int temActivity = Math.min(1,this.activity - 1);
            return new Gene(temSpeed, temRadius, temActivity);

        }
        return new Gene(this.speed, this.radius, this.activity);
    }

    public double getRadius() {
        return radius;
    }

    public double getSpeed() {
        return speed;
    }

    public int getActivity() {
        return activity;
    }
}
