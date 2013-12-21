/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.map;

import com.badlogic.gdx.utils.Array;
import java.util.Comparator;
import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxPath;
import org.flixel.FlxPoint;
import org.flixel.FlxTilemap;

/**
 *
 * @author Emre
 */
public class Map extends FlxTilemap {

    private int pathTile = 0;
    private Array<FlxPoint> path = null;

    public Map() {
        super();
    }

    public int getPathTile() {
        return pathTile;
    }

    public void setPathTile(int pathTile) {
        this.pathTile = pathTile;
        // Set path tile, and create sorted path points by width
        setTileProperties(pathTile, FlxObject.NONE);
        path = this.getTileCoords(pathTile);
        path.sort(new Comparator<FlxPoint>() {
            public int compare(FlxPoint lhs, FlxPoint rhs) {
                return (int) (lhs.x - rhs.x);
            }
        });
    }

    public FlxPoint getEntranceTile() {
        return path.first();
    }

    public FlxPoint getExitTile() {
        return path.peek();
    }

    public FlxPath getPath() {
        return findPath(path.first(), path.peek());
    }

}
