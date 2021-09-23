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
        int tem =  (int)(Math.random() * 100);
        if(tem == 1 || tem == 2 || tem == 3)
        {
            int flag = (int)(Math.random() * 100);
            if(flag % 2 == 0)
            {
                double temSpeed = this.speed + 0.1;
                double temRadius = this.radius + 5;
                int temActivity = this.activity + 1;
                return new Gene(temSpeed, temRadius,temActivity);
            }
            double temSpeed = this.speed - 0.1;
            double temRadius = this.radius - 5;
            int temActivity = this.activity - 1;
            if(temRadius < 0.1) {
                temRadius = 0.1;
            }
            if (temSpeed < 0.05) {
                temSpeed = 0.05;
            }
            if (temActivity < 1) {
                temActivity = 1;
            }

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
