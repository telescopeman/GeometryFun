import java.util.List;

public abstract class GeomObject extends UniqueObject {

    private List<Point3D> vertices;

    public abstract void connectVertices();

    public List<Point3D> getVertices()
    {
        return vertices;
    }

    public boolean addPoint(Point3D newVertex)
    {
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
}
