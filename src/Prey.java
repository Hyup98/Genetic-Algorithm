public class Prey {

	private Gene gene;
	private final int mapWidth = 1280;
	private final int mapHeight = 820;
	private final int preadtorRadius = 18;
	private float x[] = new float[4];
	private float y[] = new float[4];
	private double lastDirection;
	private int countDescendent;

	public Prey(float x[], float y[], Gene gene) {
		int check = 0;
		boolean flag = false;
		float temX[] = new float[4];
		float temY[] = new float[4];
		double random = (Math.random() * 359);
		double Direction = Math.toRadians(random);
		double temDirection = Math.toRadians(90 + random);

		for (int i = 0; i < 4; i++) {
			if ((int) x[i] > 10 && (int) y[i] > 35 && (int) x[i] < mapWidth - 10 && (int) y[i] < mapHeight - 20) {
				check = i;
			}
		}
		while (!flag) {
			temX[0] = (float) x[check];
			temY[0] = (float) y[check];

			flag = setting(temX,temY,Direction,temDirection,gene);
		}
		for (int i = 0; i < 4; i++) {
			this.x[i] = temX[i];
			this.y[i] = temY[i];
		}
		this.gene = gene;
	}

	public Prey() {
		gene = new Gene();
		
		boolean flag = false;
		float temX[] = new float[4];
		float temY[] = new float[4];
		double random = (Math.random() * 359);
		double Direction = Math.toRadians(random);
		double temDirection = Math.toRadians(90 + random);
		while (!flag) {
			temX[0] = (float) (Math.random() * mapWidth - 70 + 60);
			temY[0] = (float) (Math.random() * mapHeight - 80 + 90);

			flag = setting(temX,temY,Direction,temDirection,gene);
		}
		for (int i = 0; i < 4; i++) {
			this.x[i] = temX[i];
			this.y[i] = temY[i];
		}
	}
	public void Move() {
		int check = 0;
		boolean flag = true;
		float temX[] = new float[4];
		float temY[] = new float[4];
		double temDic = lastDirection;
		double temDegree = Math.toDegrees(temDic);
		double temSupDic = Math.toRadians(temDegree + 90);
		boolean safeCheck = false;

		for (int i = 0; i < 4; i++) {
			temX[i] = this.x[i] + (float) gene.getSpeed() * (float) Math.cos(temDic) * Controller.Acceleration;
			temY[i] = this.y[i] + (float) gene.getSpeed() * (float) Math.sin(temDic) * Controller.Acceleration;
		}
		for (int i = 0; i < 4; i++) {
			if ((int) temX[i] > 10 && (int) temY[i] > 35 && (int) temX[i] < mapWidth - 10
					&& (int) temY[i] < mapHeight - 20) {
				safeCheck = true;
			}
		}
		if (!safeCheck) {
			for (int i = 0; i < 4; i++) {
				temX[i] = this.x[i];
				temY[i] = this.y[i];
			}
			double random = (Math.random() * 359);
			temDic = Math.toRadians(random);
			temSupDic = Math.toRadians(random + 90);
		}
		while (true) {
			flag = true;
			for (int i = 0; i < 4; i++) {
				if ((int) temX[i] > 10 && (int) temY[i] > 35 && (int) temX[i] < mapWidth - 10
						&& (int) temY[i] < mapHeight - 20) {
					check = i;
				}
				if ((int) temX[i] < 10 || (int) temY[i] < 35 || (int) temX[i] > mapWidth - 10
						|| (int) temY[i] > mapHeight - 20) {
					flag = false;
				}
			}

			if (flag == true) {
				break;
			}

			double random = (Math.random() * 359);
			temDic = Math.toRadians(random);
			temSupDic = Math.toRadians(random + 90);

			temX[0] = temX[check];
			temY[0] = temY[check];

			setting(temX,temY,temDic,temSupDic,this.gene);
		}

		for (int i = 0; i < 4; i++) {
			x[i] = temX[i];
			y[i] = temY[i];
		}
		lastDirection = temDic;
	}
	public boolean setting(float X[],float Y[],double Direction,double temDirection,Gene gene) {
		boolean flag=false;
		X[1] = X[0] + (float) gene.getWidth() * (float) Math.cos(Direction);
		Y[1] = Y[0] + (float) gene.getWidth() * (float) Math.sin(Direction);

		X[2] = (X[0] + (float) gene.getHeight() * (float) Math.cos(temDirection)) + (float) gene.getWidth() * (float) Math.cos(Direction);
		Y[2] = (Y[0] + (float) gene.getHeight() * (float) Math.sin(temDirection)) + (float) gene.getWidth() * (float) Math.sin(Direction);

		X[3] = X[0] + (float) gene.getHeight() * (float) Math.cos(temDirection);
		Y[3] = Y[0] + (float) gene.getHeight() * (float) Math.sin(temDirection);
			 
		for (int i = 0; i < 4; i++) {
			if ((int) X[i] > 10 && (int) Y[i] > 35 && (int) X[i] < mapWidth - 10 && (int) Y[i] < mapHeight - 20) {
				lastDirection = Direction;
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	public float[] hitPointX() {
		float[] answer = new float[4];
		double Direction = (lastDirection);
		double temDirection = Math.toRadians(90 + Math.toDegrees(Direction));
		answer[0] = (float) ((x[0] - 1.41 * preadtorRadius * (float) Math.cos(temDirection))
								   - 1.41 * preadtorRadius * (float) Math.cos(Direction));
		answer[1] = (float) ((x[1] - 1.41 * preadtorRadius * (float) Math.cos(temDirection))
								   + 1.41 * preadtorRadius * (float) Math.cos(Direction));
		answer[2] = (float) ((x[2] + 1.41 * preadtorRadius * (float) Math.cos(temDirection))
								   + 1.41 * preadtorRadius * (float) Math.cos(Direction));
		answer[3] = (float) ((x[3] + 1.41 * preadtorRadius * (float) Math.cos(temDirection))
								   - 1.41 * preadtorRadius * (float) Math.cos(Direction));
		return answer;
	}

	public float[] hitPointY() {
		float[] answer = new float[4];
		double Direction = (lastDirection);
		double temDirection = Math.toRadians(90 + Math.toDegrees(Direction));
		answer[0] = (float) ((y[0] - 1.41 * preadtorRadius * (float) Math.sin(temDirection))
							       - 1.41 * preadtorRadius * (float) Math.sin(Direction));
		answer[1] = (float) ((y[1] - 1.41 * preadtorRadius * (float) Math.sin(temDirection))
								   + 1.41 * preadtorRadius * (float) Math.sin(Direction));
		answer[2] = (float) ((y[2] + 1.41 * preadtorRadius * (float) Math.sin(temDirection))
								   + 1.41 * preadtorRadius * (float) Math.sin(Direction));
		answer[3] = (float) ((y[3] + 1.41 * preadtorRadius * (float) Math.sin(temDirection))
								   - 1.41 * preadtorRadius * (float) Math.sin(Direction));
		return answer;
	}

	public float[] getX() {
		return x;
	}

	public float[] getY() {
		return y;
	}

	public double getWidth() {
		return gene.getWidth();
	}

	public double getHeight() {
		return gene.getHeight();
	}

	public double getSpeed() {
		return gene.getSpeed();
	}

	public double getDegree() {
		return lastDirection;
	}

	public Prey reproduceBySelf() {
		countDescendent++;
		return new Prey(x, y, gene.Genetic(Controller.mutationRate));
	}

	public boolean isBreedingComplete() {
		if (countDescendent < 3) {
			return false;
		}
		return true;
	}
}
