package gyte.cse443.etd.objects;

import com.badlogic.gdx.utils.Array;
import gyte.cse443.etd.Resources;
import java.util.Timer;
import java.util.TimerTask;
import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxPath;
import org.flixel.FlxPoint;
import org.flixel.FlxSprite;
import org.flixel.FlxTimer;
import org.flixel.FlxU;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class Tower extends FlxSprite {

    private int cost;//0-500 between
    private int attackRange;//in pixels
    private int attackSpeed;//in ms
    private BulletFactory bulletFactory;
    private volatile boolean reloaded = true;
    private Timer reloader;

    public Tower(int attackRange, int attackSpeed, int cost) {
        setAttackRange(attackRange);
        setAttackSpeed(attackSpeed);
        bulletFactory = new BulletFactory();
        reloader = new Timer();
    }

    @Override
    public void destroy() {
        reloader.cancel();
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    public Bullet attack(FlxObject obj) {
        if (canAttack(obj) && obj.alive) {
            reloaded = false;
            Bullet b = bulletFactory.create("");
            b.x = x + this.width / 2;
            b.y = y;
            b.allowCollisions = FlxObject.ANY;
            reloader.schedule(new TimerTask() {
                @Override
                public void run() {
                    reloaded = true;
                }
            }, attackSpeed);
            FlxG.play(Resources.fireSound);
            b.followPath(new FlxPath(new Array<FlxPoint>(
                    new FlxPoint[]{b.getMidpoint(), obj.getMidpoint()})), b.pathSpeed);
            return b;
        }
        return null;
    }

    public boolean canAttack(FlxObject obj) {
        return FlxU.getDistance(obj.getMidpoint(), this.getMidpoint())
                <= attackRange && reloaded;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    /**
     * @return the attackRange
     */
    public int getAttackRange() {
        return attackRange;
    }

    /**
     * @param attackRange the attackRange to set
     */
    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    /**
     * @return the attackSpeed
     */
    public int getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * @param attackSpeed the attackSpeed to set
     */
    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}//end Tower
