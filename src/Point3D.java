import java.util.ArrayList;
import java.util.List;

public class Point3D extends UniqueObject {
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
        if (o == null)
        {
            throw new IllegalArgumentException("Cannot compare to null!");
        }
        return (o.x == x && o.y == y && o.z == z);
    }

    private ArrayList<LinkConnection> connections = new ArrayList<LinkConnection>();

    protected ArrayList<LinkConnection> getConnections()
    {
        return connections;
    }

    /**
     *
     * @param object The object to connect to.
     * @return If anything actually happened as a result of the method.
     */
    public boolean connectTo(Point3D object)
    {
        if (object == this)
        {
            return false;
        }

        LinkConnection newConnection = new LinkConnection(this,object);

        if (connections.contains(newConnection)) {
            return false;
        }
        else if (object.getConnections().contains(newConnection)) {
            connections.add(newConnection);
            return true;
        }
        else {
            connections.add(newConnection);
            object.getConnections().add(newConnection);
            return true;
        }
    }



}
