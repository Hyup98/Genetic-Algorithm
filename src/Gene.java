public class Gene {
    private final double speed;
    private final double width;
    private final double height;
    private final int activity;

    public Gene(double speed, double width, double height, int activity) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.activity = activity;
    }

    public Gene() {
        this.speed = ((Math.random() * (2 - 0.05)) + 0.1);
        this.width = 30;
        this.height = 50;
        this.activity = 5;
    }

    public Gene Genetic(double mutationProbability) {
        double mutation = mutationProbability * 1000;

        double childSpeed = this.speed;
        double childWidth = this.width;
        double childHeight = this.height;
        int childActivity = this.activity;
        int probability;

        int tem = (int) (Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int) (Math.random() * 10 + 1);
            if (probability > 5)
                if (!(childActivity > 900)) {
                    childActivity = this.activity + (int) (Math.random() * 2 + 10);
                } else {
                    childActivity = this.activity - (int) (Math.random() * 2 + 10);
                    if (childActivity < 3)
                        childActivity = 3;
                }
        }

        tem = (int) (Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int) (Math.random() * 10 + 1);
            if (probability > 5)
                childSpeed = this.speed + (Math.random() * 0.05 + 0.0001);
            else {
                childSpeed = this.speed - (Math.random() * 0.05 + 0.0001);
                if (childSpeed < 0)
                    childSpeed = 0.0001;
            }
        }

        tem = (int) (Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int) (Math.random() * 10 + 1);
            if (probability > 5) {
                childWidth = this.width + (int) (Math.random() * 10 + 5);
            } else {
                childWidth = this.width - (int) (Math.random() * 10 + 5);
                if (childWidth <= 3) {
                    childWidth = 3;
                }

            }
        }

        tem = (int) (Math.random() * 100000 + 1);
        if (tem < mutation) {
            probability = (int) (Math.random() * 10 + 1);
            if (probability > 5) {
                childHeight = this.height + (int) (Math.random() * 10 + 5);
            } else {
                childHeight = this.height - (int) (Math.random() * 10 + 5);
                if (childHeight <= 3) {
                    childHeight = 3;
                }
            }
        }
        return new Gene(childSpeed, childWidth, childHeight, childActivity);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

    public int getActivity() {
        return activity;
    }
}
