/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2)
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		*/
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
        double ax = x1 + (x2 - x1) / 3.0;
        double ay = y1 + (y2 - y1) / 3.0;

        double bx = x1 + 2.0 * (x2 - x1) / 3.0;
        double by = y1 + 2.0 * (y2 - y1) / 3.0;

		double cx = ax + 0.5 * (bx - ax) + (Math.sqrt(3) / 2.0) * (by - ay);
		double cy = ay - (Math.sqrt(3) / 2.0) * (bx - ax) + 0.5 * (by - ay);
        curve(n - 1, x1, y1, ax, ay);
        curve(n - 1, ax, ay, cx, cy);
        curve(n - 1, cx, cy, bx, by);
        curve(n - 1, bx, by, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		StdDraw.clear();
		StdDraw.setScale(0.0, 1.1);

		double x1 = 0.2, y1 = 0.2;
		double x2 = 0.8, y2 = 0.2;
		double x3 = 0.5, y3 = 0.2 + Math.sqrt(3) / 2.0 * 0.6;

		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}