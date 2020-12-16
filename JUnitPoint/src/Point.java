public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isAtOrigin() {
        return x == 0 && y == 0;
    }

    public double distance(Point other) {
        if (other == null)
            throw new IllegalArgumentException();

        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public boolean isInQuadrant(int quadrant) {

        switch (quadrant) {

            case 1:
                return x > 0 && y > 0;

            case 2:
                return x < 0 && y > 0;

            case 3:
                return x < 0 && y < 0;

            case 4:
                return x > 0 && y < 0;

            default:
                throw new IllegalArgumentException("Unknown quadrant: " + quadrant);

        }

    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
