public class Box extends GeomObject{

    private double width, height, depth;

    public Box(double x, double y, double z,double width, double height, double depth)
    {
        super(x,y,z);
        this.width = width;
        this.height = height;
        this.depth = depth;
        init();
    }

    @Override
    public void addVertices() {
        addVertex(width/2,height/2,depth/2);
        addVertex(-width/2,height/2,depth/2);
        addVertex(-width/2,-height/2,depth/2);
        addVertex(-width/2,-height/2,-depth/2);
        addVertex(-width/2,height/2,-depth/2);
        addVertex(width/2,-height/2,depth/2);
        addVertex(width/2,-height/2,-depth/2);
        addVertex(width/2,height/2,-depth/2);
    }

    @Override
    public void drawFaces(Point3D startVertex)
    {
        makeSide(startVertex,PLANE.XY);
        makeSide(startVertex,PLANE.XZ);
        makeSide(startVertex,PLANE.YZ);
    }

    private void makeSide(Point3D startVertex, PLANE plane)
    {
        for (Point3D vertex : getVertices())
        {
            if (vertex.equals(startVertex))
            {
                continue;
            }

            boolean eligible = false;
            switch(plane)
            {
                case XY -> eligible = (vertex.x == startVertex.x && vertex.y == startVertex.y);
                case XZ -> eligible = (vertex.x == startVertex.x && vertex.z == startVertex.z);
                case YZ -> eligible = (vertex.z == startVertex.z && vertex.y == startVertex.y);
            }
            if (eligible)
            {
                startVertex.connectTo(vertex);
            }
        }
        //throw new IllegalStateException("This should not happen.");
    }


}
