package gyte.cse443.etd.objects;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Bullet extends FlxObject {

	private int damage;
	private FlxSprite image;

	public Bullet(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void destroy(){

	}

	public void draw(){

	}

	public void update(){

	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @return the image
	 */
	public FlxSprite getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(FlxSprite image) {
		this.image = image;
	}
}//end Bullet