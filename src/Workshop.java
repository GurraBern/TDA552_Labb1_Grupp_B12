import java.awt.*;

public class Workshop<T extends Car> extends Storage<T> {

    public Workshop(int storageLimit, Point position) {
        super(storageLimit, position);
    }
}
