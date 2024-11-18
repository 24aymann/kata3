package software.ulpgc.kata3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final String title;
    private final Map<String, Integer> values;

    public Barchart(String title) {
        this.title = title;
        this.values = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public void add(String key, Integer value) {
        values.put(key, value);
    }

    public Set<String> categories() {
        return values.keySet();
    }

    public int get(String key) {
        return values.getOrDefault(key, 0);
    }
}
