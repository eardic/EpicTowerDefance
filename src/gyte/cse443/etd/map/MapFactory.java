package gyte.cse443.etd.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TmxMapLoader.Parameters;
import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;

public class MapFactory implements Factory {

    private Map loadMap(String tmx, String tiles, int pathTile, int towerTile) {
        TmxMapLoader loader = new TmxMapLoader();
        Parameters p = new Parameters();
        p.yUp = false;
        TiledMap map = loader.load(tmx, p);
        Map tileMap = (Map) new Map().loadMap(Map.tiledmapToCSV(map, "map"),
                tiles, 32, 32, Map.OFF, 1, 1, 0);// last parameter 0 means all tiles are blocked
        tileMap.setPathTile(pathTile);//Initialize path in map
        tileMap.setTowerTile(towerTile);
        return tileMap;
    }

    public Map create(String level) {
        String tmx = Resources.mapTmx.replaceAll("#", level);
        String tile = Resources.mapTiles.replaceAll("#", level);
        if ("1".equals(level)) {
            return loadMap(tmx, tile, Resources.map1PathTile, Resources.map1TowerTile);
        }
        if ("2".equals(level)) {
            return loadMap(tmx, tile, Resources.map2PathTile, Resources.map2TowerTile);
        }
        if ("3".equals(level)) {
            return loadMap(tmx, tile, Resources.map3PathTile, Resources.map3TowerTile);
        }
        if ("4".equals(level)) {
            return loadMap(tmx, tile, Resources.map4PathTile, Resources.map4TowerTile);
        }
        if ("5".equals(level)) {
            return loadMap(tmx, tile, Resources.map5PathTile, Resources.map5TowerTile);
        }
        if ("6".equals(level)) {
            return loadMap(tmx, tile, Resources.map6PathTile, Resources.map6TowerTile);
        }
        if ("7".equals(level)) {
            return loadMap(tmx, tile, Resources.map7PathTile, Resources.map7TowerTile);
        }
        if ("8".equals(level)) {
            return loadMap(tmx, tile, Resources.map8PathTile, Resources.map8TowerTile);
        }
        if ("9".equals(level)) {
            return loadMap(tmx, tile, Resources.map9PathTile, Resources.map9TowerTile);
        }
        if ("10".equals(level)) {
            return loadMap(tmx, tile, Resources.map10PathTile, Resources.map10TowerTile);
        }
        return null;
    }

}
