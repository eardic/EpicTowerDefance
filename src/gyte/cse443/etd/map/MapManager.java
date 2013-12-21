package gyte.cse443.etd.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class MapManager {

    private List<Map> maps;

    public MapManager() {
        maps = new ArrayList<Map>();
        // Load maps
        maps.add(new MapFactory().create("2"));
    }

    public Map getMap(int level) {
        return maps.get(level);
    }

}// end MapManager
