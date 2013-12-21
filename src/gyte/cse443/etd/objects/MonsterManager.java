package gyte.cse443.etd.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import org.flixel.FlxBasic;
import org.flixel.FlxG;

import org.flixel.FlxGroup;
import org.flixel.FlxObject;
import org.flixel.FlxPath;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class MonsterManager extends FlxGroup {

    public static final int GROUP_SIZE = 10, CALL_PERIOD = 1;

    private Stack<Stack<Monster>> monsterGroup;
    private Stack<Monster> waitingGroup, // Coming monsters for map 
            walkingMonsters;// Walking monsters on map
    private boolean scheduled = false;
    private int breakout = 0;
    private final int level; // Current level
    private final FlxPath path; // The path for monsters to walk
    private final Timer spawner; // Monster spawner for specific periods

    public MonsterManager(FlxPath path, int level) {
        this.level = level;
        this.path = path;
        createMonstersByLevel();//Initialize monster group
        waitingGroup = monsterGroup.pop();// Initialize waiting group
        walkingMonsters = new Stack<Monster>();// Empty walking monster
        spawner = new Timer("Monster Spawner");// Initialize monster spawner
    }

    private void createMonstersByLevel() {
        monsterGroup = new Stack<Stack<Monster>>();
        if (level <= 1) {
            createGroup(GROUP_SIZE, MonsterType.KNIGHT);
        }
        if (level <= 2) {
            createGroup(GROUP_SIZE, MonsterType.KNIGHT);
        }
    }

    private void createGroup(int size, MonsterType type) {
        MonsterFactory factory = new MonsterFactory();
        Stack<Monster> monsters = new Stack<Monster>();
        for (int i = 0; i < size; ++i) {
            Monster m = factory.create(type.name());
            m.x = path.head().x - m.x - m.width / 2;
            m.y = path.head().y - m.y - m.height / 2;
            monsters.push(m);
        }
        monsterGroup.push(monsters);
    }

    /**
     *
     * @param delay in seconds
     */
    public void callMonsters(int delay) {
        if (!scheduled) {
            // Schedule adding monster to game when a period time passes
            spawner.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (active) {// Game is paused?
                        // If not then manage monsters
                        if (!waitingGroup.isEmpty()) {
                            Monster m = waitingGroup.pop();
                            m.followPath(path);                           
                            add(m);
                            walkingMonsters.push(m);
                        } else if (!monsterGroup.isEmpty()) {
                            waitingGroup = monsterGroup.pop();
                        }
                        scheduled = true;
                    }
                }
            }, delay * 1000, CALL_PERIOD * 1000);
        }
    }

    public boolean allDied() {
        return monsterGroup.isEmpty() && walkingMonsters.isEmpty()
                && waitingGroup.isEmpty();
    }

    private void stopSpawnerIfAllDied() {
        if (allDied()) {
            spawner.cancel();
        }
    }

    private void checkBreakout() {
        // If monster completes its path, then it escaped.
        // Pathspeed becomes zero when it completes its path
        if (!walkingMonsters.isEmpty())// Remove escaped monster from walking list
        {
            Monster m = walkingMonsters.pop();
            if (m.pathSpeed <= 0) {
                m.kill();
                remove(m);
                ++breakout;
            }
        }
    }

    @Override
    public void update() {
        super.update();
        stopSpawnerIfAllDied();
        checkBreakout();
    }

    public void setSpeed(int s) {
        for (Monster m : walkingMonsters) {
            m.pathSpeed = s;
        }
    }

    public int getBreakout() {
        return breakout;
    }

}//end MonsterManager
