public class Body {
	/** Instance variables */
	public static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** Constructor */
	public Body(double xP, double yP, double xV, 
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;	
	}

	public double calcDistance(Body d) {
		double distance = Math.sqrt((xxPos - d.xxPos) * (xxPos - d.xxPos) + (yyPos - d.yyPos) * (yyPos - d.yyPos));
		return distance;
	}

	public double calcForceExertedBy(Body d) {
		double distance = calcDistance(d);
		double force = (G * mass * d.mass) / (distance * distance);
		return force;
	}

	public double calcForceExertedByX(Body d) {
		double force = calcForceExertedBy(d);
		double distance = calcDistance(d);
		double forceByX = (force * (d.xxPos - xxPos)) / distance;
		return forceByX;
	}

	public double calcForceExertedByY(Body d) {
		double force = calcForceExertedBy(d);
		double distance = calcDistance(d);
		double forceByY = (force * (d.yyPos - yyPos)) / distance;
		return forceByY;
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double netForceByX = 0;
		for (Body d : allBodys) {
			if (this.equals(d)) {
				continue;
			}
			else {
				netForceByX += calcForceExertedByX(d);
			}
		}
		return netForceByX;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double netForceByY = 0;
		for (Body d : allBodys) {
			if (this.equals(d)) {
				continue;
			}
			else {
				netForceByY += calcForceExertedByY(d);
			}
		}
		return netForceByY;
	}

	public void update (double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel = xxVel + dt * aX;
		yyVel = yyVel + dt * aY;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}
}