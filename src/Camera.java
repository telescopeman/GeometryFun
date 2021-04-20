import java.awt.*;

public class Camera extends PhysicsObject {


    public Camera(double x, double y, double z, double pitch, double yaw, double roll) {
        super(x, y, z, pitch, yaw, roll);
    }

    public void render(Graphics g, GeomObject visual)
    {
        g.setColor(Color.white);
        ((Graphics2D) g).setStroke(new BasicStroke(50));
        for (LinkConnection line : visual.getConnections())
        {
            System.out.println("ff");
            g.drawLine((int)line.point1.x,(int)line.point1.y,
                    (int)line.point2.x,(int)line.point2.y);
        }
    }
}
