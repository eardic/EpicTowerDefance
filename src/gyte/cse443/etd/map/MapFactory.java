package gyte.cse443.etd.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TmxMapLoader.Parameters;
import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;
import org.flixel.FlxObject;

public class MapFactory implements Factory {

    private Map loadMap(String tmx, String tiles, int pathTile) {
        TmxMapLoader loader = new TmxMapLoader();
        Parameters p = new Parameters();
        p.yUp = false;
        TiledMap map = loader.load(tmx, p);
        Map tileMap = (Map) new Map().loadMap(Map.tiledmapToCSV(map, "map"),
                tiles, 32, 32, Map.OFF, 1, 1, 0);
        tileMap.setPathTile(pathTile);//Initialize path in map
        return tileMap;
    }

    public Map create(String level) {
        if ("2".equals(level)) {
            return loadMap(Resources.map2, Resources.map2Tiles, Resources.map2PathTile);
        }
        return null;
    }

}
