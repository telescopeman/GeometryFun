import java.util.List;

/**
 * An object that can be connected to something.
 */
public abstract class Connectable extends UniqueObject {
    private List<LinkConnection> connections;

    protected List<LinkConnection> getConnections()
    {
        return connections;
    }

    /**
     *
     * @param object The object to connect to.
     * @return If anything actually happened as a result of the method.
     */
    public boolean connectTo(Connectable object)
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
