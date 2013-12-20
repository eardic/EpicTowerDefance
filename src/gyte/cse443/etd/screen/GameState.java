package gyte.cse443.etd.screen;

import android.graphics.Color;
import gyte.cse443.etd.Resources;
import gyte.cse443.etd.map.MapManager;
import gyte.cse443.etd.ui.Button;
import gyte.cse443.etd.ui.TextField;
import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.event.IFlxButton;
import org.flixel.ui.FlxInputText;

public class GameState extends FlxState {

    private FlxButton startStopButton, menuButton, speedButton;
    private FlxInputText money, lives, score;
    private MapManager mapMan;

    public GameState(MapManager man) {
    }

    public GameState() {
    }

    @Override
    public void create() {
        mapMan = new MapManager();

        startStopButton = new Button(20, 7, Resources.startButton, new StartPauseEvent());
        speedButton = new Button(100, 7, Resources.x1Button, new SpeedEvent());
        money = new TextField(180, 26, 100, 30, "Resources", "0");
        lives = new TextField(310, 26, 100, 30, "Lives", "5");
        score = new TextField(440, 26, 100, 30, "Score", "0");
        menuButton = new Button(570, 7, Resources.menuButton, new MenuEvent());

        add(mapMan.getCurrentMap());
        add(new FlxSprite().makeGraphic(FlxG.width, 64, Color.argb(255, 0, 0, 0)));
        add(startStopButton);
        add(speedButton);
        add(money);
        add(lives);
        add(score);
        add(menuButton);
    }

    private class StartPauseEvent implements IFlxButton {

        private boolean paused = false;

        public void callback() {
            // TODO Auto-generated method stub
            System.out.println("Started/Paused");
            if (!paused) {
                paused = true;
                startStopButton.loadGraphic(Resources.pauseButton);
            } else {
                paused = false;
                startStopButton.loadGraphic(Resources.startButton);
            }
        }

    }

    private class MenuEvent implements IFlxButton {

        public void callback() {
            // TODO Auto-generated method stub
            System.out.println("Menu");
        }

    }

    private class SpeedEvent implements IFlxButton {

        private boolean slow = true;

        public void callback() {
            // TODO Auto-generated method stub
            System.out.println("Speed");
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
