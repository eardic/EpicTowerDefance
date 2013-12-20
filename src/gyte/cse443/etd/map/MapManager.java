package gyte.cse443.etd.map;

import gyte.cse443.etd.Resources;

import java.util.ArrayList;
import java.util.List;

import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class MapManager {

    public static int TILE_SIZE = 32, TILE_X = 20, TILE_Y = 15;
    private int currentMapIndex = 0;
    private List<FlxSprite> maps;

    public MapManager() {
        maps = new ArrayList<FlxSprite>();
        // Load maps
        maps.add(new MapFactory().create(Resources.map1));
    }

    public void addMap(FlxSprite m) {
        maps.add(m);
    }

    public FlxSprite getCurrentMap() {
        return maps.get(currentMapIndex);
    }

    public void removeMap(FlxSprite m) {
        maps.remove(m);
    }

    public void finalize() throws Throwable {
        maps.clear();
    }

}// end MapManager
