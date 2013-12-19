package gyte.cse443.etd.input;
import org.flixel.system.input.Mouse;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class InputManager {

	private Mouse mouse;

	public InputManager(){

	}

	public void finalize() throws Throwable {

	}
	public int getTouchX(){
		return mouse.screenX;
	}

	public int getTouchY(){
		return mouse.screenY;
	}

	public boolean isPressed(){
		return mouse.pressed();
	}
}//end InputManager