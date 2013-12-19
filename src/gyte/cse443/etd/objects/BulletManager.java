package gyte.cse443.etd.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class BulletManager {

	private List<Bullet> bullets;

	public BulletManager() {
		bullets = new ArrayList<Bullet>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param b
	 */
	public void addBullet(Bullet b) {
		bullets.add(b);
	}

	/**
	 * 
	 * @param b
	 */
	public void removeBullet(Bullet b) {
		bullets.remove(b);
	}
}// end BulletManager