package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.map.MapManager;

import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxState;
import org.flixel.ui.FlxInputText;
import org.flixel.ui.FlxLabel;
import org.flixel.ui.FlxNinePatchButton;
import org.flixel.ui.event.IFlxUIListener;

import android.graphics.Color;

public class GameState extends Screen {

	private FlxNinePatchButton startStopButton, menuButto, speedButton;
	private FlxInputText money, lives, score;
	private MapManager mapMan;

	public GameState() {
		// TODO Auto-generated constructor stub
		mapMan = new MapManager();

		speedButton = new FlxNinePatchButton(100, 15, buttonSkin, "", 0, 0,
				new SpeedEvent());
		speedButton.loadGraphic(Resources.x1Button);

		startStopButton = new FlxNinePatchButton(20, 15, buttonSkin, "", 0, 0,
				new StartPauseEvent());
		startStopButton.loadGraphic(Resources.startButton);

		money = new FlxInputText(200, 30, null, "Resources", 100, 30);
		money.label.setColor(Color.BLACK);
		money.label.setSize(20);
		money.label.setFont(Resources.robotoFont);
		money.textfield.setColor(Color.BLACK);
		money.setEnable(false);
		money.textfield.setFormat(Resources.robotoFont, 20);
		money.setText("0");
		
		lives = new FlxInputText(330, 30, null, "Lives", 100, 30);
		lives.label.setColor(Color.BLACK);
		lives.label.setSize(20);
		lives.label.setFont(Resources.robotoFont);
		lives.textfield.setColor(Color.BLACK);
		lives.setEnable(false);
		lives.textfield.setFormat(Resources.robotoFont, 20);
		lives.setText("5");
		
		score = new FlxInputText(460, 30, null, "Score", 100, 30);
		score.label.setColor(Color.BLACK);
		score.label.setSize(20);
		score.label.setFont(Resources.robotoFont);
		score.textfield.setColor(Color.BLACK);
		score.setEnable(false);
		score.textfield.setFormat(Resources.robotoFont, 20);
		score.setText("0");
		
	}

	@Override
	public void create() {
		add(mapMan.getCurrentMap());
		add(money);
		add(lives);
		add(score);
		add(startStopButton);
		add(speedButton);
	}

	private class StartPauseEvent implements IFlxUIListener {
		private boolean paused = false;

		public void callback() {
			// TODO Auto-generated method stub
			System.err.println("Started/Paused");
			if (!paused) {
				paused = true;
				startStopButton.loadGraphic(Resources.pauseButton);
			} else {
				paused = false;
				startStopButton.loadGraphic(Resources.startButton);
			}
		}

	}

	private class MenuEvent implements IFlxUIListener {

		public void callback() {
			// TODO Auto-generated method stub
			System.err.println("Menu");
		}

	}

	private class SpeedEvent implements IFlxUIListener {
		private boolean slow = true;

		public void callback() {
			// TODO Auto-generated method stub
			System.err.println("Speed");
			if (!slow) {
				speedButton.loadGraphic(Resources.x1Button);
				slow = true;
			} else {
				speedButton.loadGraphic(Resources.x2Button);
				slow = false;
			}
		}

	}

}