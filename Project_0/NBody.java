public class NBody {
	public static double readRadius (String fileName) {
		In in = new In(fileName);
		int n = in.readInt();
		double r = in.readDouble();
		return r;
	}

	public static Body[] readBodies (String fileName) {
		In in = new In(fileName);
		int n = in.readInt();
		Body[] bodies = new Body[n];
		double r = in.readDouble();
		for (int i = 0; i < n; i++) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String img = "./images/" + in.readString();
			bodies[i] = new Body(xPos, yPos, xVel, yVel, mass, img);
		}
		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		String picture = "./images/starfield.jpg";
		
		for (double t = 0; t <= T; t += dt) {
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			for (int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.clear();
			StdDraw.picture(0, 0, picture, 2 * radius, 2 * radius);
			for (Body d : bodies) {
				d.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}
}