import java.util.Iterator;
import java.util.LinkedList;
import java.awt.Graphics;

/**
 * Handles objects.
 *
 * @author RealTutsGML, Caleb Copeland
 * @version 4/14/21
 * @since 4/8/21
 */
public class Handler
{
    public static LinkedList<GeomObject> object = new LinkedList<>();

    private static final LinkedList<GeomObject> deletionQueue = new LinkedList<>();

    private static final LinkedList<GeomObject> additionQueue = new LinkedList<>();

    private static int lastX = 0,lastY = 0;

    public static final Camera camera = new Camera(50,50,-60,0,0,0);

    public static void tick()
    {
        for (Iterator<GeomObject> iterator = deletionQueue.iterator(); iterator.hasNext();) {
            GeomObject obj = iterator.next();
            if (obj instanceof GeomObject) {
                removeObject(obj);
            }
            iterator.remove();
        }
        //deletionQueue.clear();

        for (Iterator<GeomObject> iterator2 = additionQueue.iterator(); iterator2.hasNext();) {
            GeomObject obj = iterator2.next();
            if (obj instanceof GeomObject) {
                addObject(obj);
            }
            iterator2.remove();
        }
        //additionQueue.clear();

        for (Iterator<GeomObject> iterator2 = object.iterator(); iterator2.hasNext();) {
            GeomObject obj = iterator2.next();
            //obj.tick();
        }
    }

    public static void render(Graphics g)
    {
        for (Iterator<GeomObject> iterator2 = object.iterator(); iterator2.hasNext();) {
            GeomObject tempObject = iterator2.next();

            camera.render(g,  tempObject);


        }
    }

    public static void addObject(GeomObject obj) {
        //System.out.println("Adding new " + obj.getID());

        object.add(obj);

    }

    public static void addObjects(GeomObject[] objects)
    {
        for (GeomObject obj : objects)
        {
            addObject(obj);
        }
    }

    public static void removeObject(GeomObject obj) { object.remove(obj); }


    public static void queueForDeletion(GeomObject obj)
    {
        deletionQueue.add(obj);
    }

    public static void queueForAddition(GeomObject obj)
    {
        additionQueue.add(obj);
    }
}
