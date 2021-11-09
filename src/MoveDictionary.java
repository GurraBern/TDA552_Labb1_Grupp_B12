import java.util.Hashtable;

public class MoveDictionary {
    public static void main(String[] args)
    {
        Hashtable<String, Integer> moveDictionary = new Hashtable<>();
        moveDictionary.put("w", 1);
        moveDictionary.put("s", -1);
        moveDictionary.put("d", 1);
        moveDictionary.put("a", -1);

        moveDictionary.get("w");
        moveDictionary.get("s");
        moveDictionary.get("d");
        moveDictionary.get("a");
    }
}
