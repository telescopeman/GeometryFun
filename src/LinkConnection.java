public class LinkConnection implements Comparable<LinkConnection>{

    private Connectable point1, point2;

    public LinkConnection(Connectable point1, Connectable point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }

    public long getFirstID()
    {
        return point1.getID();
    }

    public long getSecondID()
    {
        return point2.getID();
    }

    @Override
    public int compareTo(LinkConnection o) {
        if (getFirstID() == o.getFirstID() || getFirstID() == o.getSecondID())
        {
            if (getSecondID() == o.getFirstID() || getSecondID() == o.getSecondID())
            {
                return 0;
            }
            return 1;
        }
        return -1;
    }
}
