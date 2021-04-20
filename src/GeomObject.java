import java.util.ArrayList;


public abstract class GeomObject extends Point3D  {

    private ArrayList<Point3D> vertices = new ArrayList<Point3D>();

    private boolean frozen = false;

    public abstract void addVertices();

    public void connectVertices()
    {
        for (Point3D vertex : vertices)
        {
            drawFaces(vertex);
        }
    }

    public abstract void drawFaces(Point3D startVertex);


    public ArrayList<Point3D> getVertices()
    {
        return vertices;
    }

    public GeomObject(double x, double y, double z)
    {
        super(x,y,z);

    }

    public void init()
    {
        addVertices();
        frozen = true;
        connectVertices();
    }

    public boolean addVertex(Point3D newVertex) {
        if (frozen)
        {
            throw new IllegalStateException("Cannot add a new vertex to a frozen object!");
        }
        for(Point3D vertex : vertices)
        {
            if (vertex.isEquivalentTo(newVertex))
            {
                return false;
            }
        }
        vertices.add(newVertex);
        return true;
    }


    public boolean addVertex(double x, double y, double z)
    {
        System.out.println("New point at " + x);
        return addVertex(new Point3D(x + this.x,y + this.y,z + this.z));
    }
}
