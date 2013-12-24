/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.ui.Button;

import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxSprite;
import org.flixel.event.IFlxButton;

import android.graphics.Color;

/**
 * 
 * @author Emre
 */
public class PauseState extends FlxGroup {

	private FlxButton continuee, restart, menu;
	private GameState state;
	
	public PauseState(GameState state) {
		this.state = state;
		state.pauseGame(true);
		
		continuee = new Button(FlxG.width / 2 - 158, 110,
				Resources.continueGame,316, 91, new ContinueGame());
		restart = new Button(FlxG.width / 2 - 158, 200, Resources.restartGame,316, 91,
				new Restart());
		menu = new Button(FlxG.width / 2 - 158, 290, Resources.mainMenu,316, 91,
				new Menu());

		add(new FlxSprite(0,0).makeGraphic(FlxG.width,FlxG.height, Color.argb(200,0,0,0)));
		add(continuee);
		add(restart);
		add(menu);
	}

	// LISTENER CLASSES FOR BUTTONS
	private class ContinueGame implements IFlxButton {

		public void callback() {
			state.pauseGame(false);
			kill();			
			destroy();			
		}

	}

	private class Restart implements IFlxButton {

		public void callback() {
			FlxG.switchState(new GameState(state.getLevel()));
		}

	}

	private class Menu implements IFlxButton {

		public void callback() {
			FlxG.switchState(new StartMenuState());
		}

	}

}
