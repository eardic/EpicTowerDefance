package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.ui.Button;

import org.flixel.FlxG;
import org.flixel.FlxSound;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.FlxText;
import org.flixel.event.IFlxButton;
import org.flixel.system.FlxSplashScreen;

import android.graphics.Color;

public class CreditsState extends FlxState {

	@Override
	public void create() {
		
		FlxText touch = new FlxText(FlxG.width / 2 - 150, FlxG.height - 100, 0, "Touch for Main Menu");
        touch.setFormat(Resources.vinerHandFont, 30, Color.WHITE);
        touch.antialiasing = true;
	        
	    add(new FlxSprite(0,0).loadGraphic(Resources.credits));
		add(touch);
	}
	
	@Override
    public void update() {
        super.update();
        if (FlxG.mouse.justReleased()) {
            FlxSound s = FlxG.play(Resources.buttonClick);
            s.survive = true;
            FlxG.switchState(new StartMenuState());
        }
    }
	
}
