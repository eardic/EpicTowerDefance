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
import org.flixel.event.IFlxTimer;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class Tower extends FlxSprite {

	private TowerType type;
	private BulletType bulletType;
	private int cost;// 0-500 between
	private int attackRange;// in pixels
	private int attackSpeed;// in ms
	private BulletFactory bulletFactory;
	private volatile boolean reloaded = true;
	private FlxTimer reloader;

	public Tower(TowerType type, BulletType bType, int attackRange, int attackSpeed, int cost) {
		setAttackRange(attackRange);
		setAttackSpeed(attackSpeed);
		bulletFactory = new BulletFactory();
		reloader = new FlxTimer();
		this.type = type;
		this.bulletType = bType;
		this.cost = cost;
	}

	@Override
	public void destroy() {
		reloader.stop();
		super.destroy(); // To change body of generated methods, choose Tools |
							// Templates.
	}
	
	public Bullet attack(FlxObject obj) {
		if (canAttack(obj)) {
			reloaded = false;
			Bullet b = bulletFactory.create(bulletType.name());
			b.x = this.x + this.width / 2;
			b.y = this.y + 10;
			reloader.start(attackSpeed/1000f, 1, new IFlxTimer() {				
				public void callback(FlxTimer Timer) {
					reloaded = true;
				}
			});			
			b.followPath(new FlxPath(new Array<FlxPoint>(new FlxPoint[]
					{b.getMidpoint(), obj.getMidpoint()})), b.pathSpeed);
            FlxG.play(Resources.fireSound);
			return b;
		}
		return null;
	}

	public boolean canAttack(FlxObject obj) {
		return reloaded && obj.alive && FlxU.getDistance(this.getMidpoint(), obj.getMidpoint()) <= attackRange;
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
	 * @param attackRange
	 *            the attackRange to set
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
	 * @param attackSpeed
	 *            the attackSpeed to set
	 */
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
}// end Tower
