
public class Point3D extends Connectable {
    public double x, y, z;

    public Point3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D()
    {
        x = 0;
        y = 0;
        z = 0;
    }

    public boolean isEquivalentTo(Point3D o)
    {
        return (o.x == x && o.y == y && o.z == z);
    }
}
