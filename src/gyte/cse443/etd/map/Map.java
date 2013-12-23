/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.map;

import com.badlogic.gdx.utils.Array;
import java.util.Comparator;
import org.flixel.FlxObject;
import org.flixel.FlxPath;
import org.flixel.FlxPoint;
import org.flixel.FlxTilemap;

/**
 *
 * @author Emre
 */
public class Map extends FlxTilemap {

    private int pathTile = 0, towerTile = 0;
    Array<FlxPoint> pathCoor = null;// Coordinates of tiles of road
    private FlxPath road = null;// Road for monsters to walk

    public Map() {
        super();
    }

    public int getTileX(float xCoor) {
        return (int) xCoor / getTileWidth();
    }

    public int getTileY(float yCoor) {
        return (int) yCoor / getTileHeight();
    }

    public int getPathTile() {
        return pathTile;
    }

    public void setTowerTile(int towerTile) {
        this.towerTile = towerTile;
    }

    public int getTowerTile() {
        return towerTile;
    }

    public void setPathTile(int pathTile) {
        this.pathTile = pathTile;
        // Set path tile, and create sorted path points by width
        setTileProperties(pathTile, FlxObject.NONE);
        pathCoor = this.getTileCoords(pathTile);
        pathCoor.sort(new Comparator<FlxPoint>() {
            public int compare(FlxPoint lhs, FlxPoint rhs) {
                return (int) (lhs.x - rhs.x);
            }
        });
        // Find path
        road = findPath(pathCoor.first(), pathCoor.peek());
        setTileProperties(towerTile, FlxObject.NONE);
    }

    public int getTileWidth() {
        return _tileWidth;
    }

    public int getTileHeight() {
        return _tileHeight;
    }

    public FlxPoint getEntranceTile() {
        return pathCoor.first();
    }

    public FlxPoint getExitTile() {
        return pathCoor.peek();
    }

    public FlxPath getPath() {
        return road;
    }

}
