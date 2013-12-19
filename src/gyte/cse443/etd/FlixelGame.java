package gyte.cse443.etd;

import gyte.cse443.etd.screen.GameState;

import org.flixel.FlxCamera;
import org.flixel.FlxG;
import org.flixel.FlxGame;
import org.flixel.FlxGesture;
import org.flixel.event.IFlxGesture;
import org.flixel.plugin.GestureManager.GestureData;

public class FlixelGame extends FlxGame {

	public static final int SCREEN_WIDTH = 480, SCREEN_HEIGHT = 640;

	public FlixelGame() {
		super(SCREEN_HEIGHT, SCREEN_WIDTH, GameState.class);		
	}

}
