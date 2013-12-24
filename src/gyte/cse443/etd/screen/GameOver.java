package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.ui.Button;

import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxSprite;
import org.flixel.FlxText;
import org.flixel.event.IFlxButton;

import android.graphics.Color;

public class GameOver extends FlxGroup {
	private FlxButton nextLevel, restart, menu;
	private GameState state;
	
	public GameOver(GameState state, boolean win) {
		this.state = state;
		
		nextLevel = new Button(FlxG.width / 2 - 158, 110,
				Resources.nextLevel ,316, 91, new NextLevel());
		restart = new Button(FlxG.width / 2 - 158, 200, Resources.restartGame,316, 91,
				new Restart());
		menu = new Button(FlxG.width / 2 - 158, 290, Resources.mainMenu, 316, 91,
				new Menu());
		
		FlxText gameOverText = new FlxText(FlxG.width/2-100, win?40:100, 0, win ? "You Win!" : "You Lost!");
		gameOverText.setFormat(Resources.vinerHandFont, 40);
		
		add(new FlxSprite(0,0).makeGraphic(FlxG.width,FlxG.height, Color.argb(200,0,0,0)));
		
		if(win){
			add(nextLevel);
		}
		
		add(gameOverText);
		add(restart);
		add(menu);
	}

	// LISTENER CLASSES FOR BUTTONS
	private class NextLevel implements IFlxButton {

		public void callback() {
			if(state.getLevel() < 10){
				FlxG.switchState(new GameState(state.getLevel()+1));
			}else{
				FlxG.switchState(new CreditsState());
			}
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
