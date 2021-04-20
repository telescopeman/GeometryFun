public class PhysicsObject extends Point3D {

    private double pitch, yaw, roll;

    public PhysicsObject(double x, double y, double z, double pitch, double yaw, double roll)
    {
        super(x,y,z);
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }


}
