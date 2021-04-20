import java.util.concurrent.atomic.AtomicLong;

public class IDManager {

    private static AtomicLong idCounter = new AtomicLong();

    public static long createID()
    {
        return idCounter.getAndIncrement();
    }
}
