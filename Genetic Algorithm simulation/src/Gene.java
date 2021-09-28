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
        this.radius = 30;
        this.activity = 800;
    }

    public Gene Genetic(double mutationProbability) {
        double mutation = mutationProbability * 1000;

        double childSpeed = this.speed;
        int childActivity = this.activity;
        double childRadius = this.radius;
        int probability;

        //활동성 유전자 생성
        int tem =  (int)(Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int)(Math.random() * 10 + 1);
            //활동성 감소
            if (probability > 5) {
                childActivity = this.activity + (int)(Math.random() * 2 + 1);
            }
            //활동성 증가
            else {
                childActivity = this.activity - (int)(Math.random() * 2 + 1);
                if(childActivity < 0) {
                    childActivity = 3;
                }
            }
        }

        //속도 유전자 생성
        tem =  (int)(Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int)(Math.random() * 10 + 1);
            //속도 증가
            if (probability > 5) {
                childSpeed = this.speed + (Math.random() * 0.05 + 0.0001);
            }
            //속도 감소
            else {
                childSpeed = this.speed - (Math.random() * 0.05 + 0.0001);
                if(childSpeed < 0) {
                    childSpeed = 0.0001;
                }
            }

        }

        //모양 유전자 생성
        tem =  (int)(Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int)(Math.random() * 10 + 1);
            //모양 증가
            if (probability > 5) {
                childRadius = this.radius + (int)(Math.random() * 3 + 1);

            }
            //모양 감소
            else {
                childRadius = this.radius - (int)(Math.random() * 3 + 1);
                if(childRadius < 0) {
                    childRadius = 1;
                }
            }
        }

        return new Gene(childSpeed, childRadius, childActivity);
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
