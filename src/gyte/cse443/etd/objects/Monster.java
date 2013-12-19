package gyte.cse443.etd.objects;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Monster extends FlxObject {

	private FlxSprite image;
	private int type;

	public Monster(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void attack(){

	}

	public void destroy(){

	}

	public void draw(){

	}

	/**
	 * 
	 * @param f0
	 */
	public void hurt(float f0){

	}

	public void update(){

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

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
}//end Monster