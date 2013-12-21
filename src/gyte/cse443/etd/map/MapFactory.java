package gyte.cse443.etd.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TmxMapLoader.Parameters;
import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;

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
        String tmx = Resources.mapTmx.replaceAll("#", level);
        String tile = Resources.mapTiles.replaceAll("#", level);
        if ("1".equals(level)) {
            return loadMap(tmx, tile, Resources.map1PathTile);
        }
        if ("2".equals(level)) {
            return loadMap(tmx, tile, Resources.map2PathTile);
        }
        if ("3".equals(level)) {
            return loadMap(tmx, tile, Resources.map3PathTile);
        }
        if ("4".equals(level)) {
            return loadMap(tmx, tile, Resources.map4PathTile);
        }
        if ("5".equals(level)) {
            return loadMap(tmx, tile, Resources.map5PathTile);
        }
        if ("6".equals(level)) {
            return loadMap(tmx, tile, Resources.map6PathTile);
        }
        if ("7".equals(level)) {
            return loadMap(tmx, tile, Resources.map7PathTile);
        }
        return null;
    }

}
