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
            //활동성 증가
            if (probability > 5) {
                childActivity = this.activity + 5;
            }
            //활동성 감소
            else {
                childActivity = this.activity - 5;
                if(childActivity < 0) {
                    childActivity = 1;
                }

            }
        }

        //속도 유전자 생성
        tem =  (int)(Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int)(Math.random() * 10 + 1);
            //속도 증가
            if (probability > 5) {
                childSpeed = this.speed + 0.05;
            }
            //속도 감소
            else {
                childSpeed = this.speed - 0.05;
                if(childSpeed < 0) {
                    childSpeed = 0.005;
                }
            }

        }

        //모양 유전자 생성
        tem =  (int)(Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int)(Math.random() * 10 + 1);
            //모양 증가
            if (probability > 5) {
                childRadius = this.radius + 5;

            }
            //모양 감소
            else {
                childRadius = this.radius - 5;
                if(childRadius < 0) {
                    childRadius = 3;
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
