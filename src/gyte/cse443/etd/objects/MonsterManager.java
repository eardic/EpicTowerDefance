package gyte.cse443.etd.objects;

import gyte.cse443.etd.map.Map;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import org.flixel.FlxGroup;

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
    private int currentSpeed = 100;
    private boolean scheduled = false;
    private int breakout = 0;
    private final int level; // Current level
    private final Timer spawner; // Monster spawner for specific periods
    private Map map;

    public MonsterManager(Map map, int level) {
        this.level = level;
        this.map = map;
        createMonstersByLevel();//Initialize monster group
        waitingGroup = monsterGroup.pop();// Initialize waiting group
        walkingMonsters = new Stack<Monster>();// Empty walking monster
        spawner = new Timer("Monster Spawner");// Initialize monster spawner
    }

    public Stack<Monster> getWalkingMonsters() {
        return walkingMonsters;
    }

    private void createMonstersByLevel() {
        monsterGroup = new Stack<Stack<Monster>>();
        switch (level) {
            case 10:
            case 9:
            case 8:
            case 7:
                createGroup(GROUP_SIZE, MonsterType.ALIEN);
            case 6:
                createGroup(GROUP_SIZE, MonsterType.DRAGON);
            case 5:
                createGroup(GROUP_SIZE, MonsterType.GOLEM);
            case 4:
                createGroup(GROUP_SIZE, MonsterType.WOLF);
            case 3:
                createGroup(GROUP_SIZE, MonsterType.LIZARD);
            case 2:
                createGroup(GROUP_SIZE, MonsterType.TROLL);
            case 1:
                createGroup(GROUP_SIZE, MonsterType.TREX);
        }
    }

    private void createGroup(int size, MonsterType type) {
        MonsterFactory factory = new MonsterFactory();
        Stack<Monster> monsters = new Stack<Monster>();
        for (int i = 0; i < size; ++i) {
            Monster m = factory.create(type.name());
            m.x = map.getPath().head().x - m.x - m.width / 2;
            m.y = map.getPath().head().y - m.y - m.height / 2;
            monsters.push(m);
        }
        monsterGroup.push(monsters);
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	spawner.cancel();
    	super.destroy();
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
                            m.followPath(map.getPath(), currentSpeed);
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
            Monster m = walkingMonsters.peek();
            if (m.pathSpeed <= 0) {
                walkingMonsters.pop();
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
        checkSpeed();
    }

    public void setSpeed(int s) {
        currentSpeed = s;
    }

    private void checkSpeed() {
        int size = walkingMonsters.size();
        for (int i = 0; i < size; ++i) {
            if (walkingMonsters.get(i).pathSpeed > 0) {// If not completed the path
                walkingMonsters.get(i).pathSpeed = currentSpeed;
            }
        }
    }

    public int getBreakout() {
        return breakout;
    }

}//end MonsterManager
