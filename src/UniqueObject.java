public abstract class UniqueObject {
    private final long id;

    public UniqueObject()
    {
        id = IDManager.createID();
    }


    public long getID()
    {
        return id;
    }
}
