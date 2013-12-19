package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;

import org.flixel.FlxG;
import org.flixel.FlxState;
import org.flixel.ui.FlxUISkin;
import org.flixel.ui.FlxUISkin.NinePatch;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public abstract class Screen extends FlxState {

	protected final FlxUISkin buttonSkin = new FlxUISkin(),
			textBoxSkin = new FlxUISkin();

	public Screen() {
		buttonSkin.setFormat(Resources.robotoFont, 20, 0x111111);	
		textBoxSkin.setFormat(Resources.robotoFont, 20, 0x111111);
		

	}

}// end Screen