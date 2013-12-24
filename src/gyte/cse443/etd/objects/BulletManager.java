package gyte.cse443.etd.objects;

import com.badlogic.gdx.utils.Array;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.map.Map;
import java.util.ArrayList;
import java.util.List;

import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxPath;
import org.flixel.FlxPoint;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class BulletManager extends FlxGroup {

    private final List<Tower> purshasedTowers;
    private final List<Monster> walkingMonsters;
    private final Map map;

    public BulletManager(Map map, List<Tower> purshasedTowers, List<Monster> walkingMonsters) {
        this.purshasedTowers = purshasedTowers;
        this.walkingMonsters = walkingMonsters;
        this.map = map;
    }

    @Override
    public void update() {
        super.update();
        checkTowerAttack();
    }

    private void checkTowerAttack() {
        int towSize = purshasedTowers.size();
        for (int i = 0; i < towSize; ++i) {
            Tower t = purshasedTowers.get(i);
            int monSize = walkingMonsters.size();
            for (int j = 0; j < monSize; ++j) {
                Monster m = walkingMonsters.get(j);
                Bullet b = t.attack(m);
                if (b!=null) {
                    add(b);
                }
            }
        }
    }

}// end BulletManager
