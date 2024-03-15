package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public final class Storage {
    private static Storage instance;
    private final Map<String, Integer> storage;

    private Storage() {
        storage = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}

