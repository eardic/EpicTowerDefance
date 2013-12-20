package gyte.cse443.etd;

import gyte.cse443.etd.screen.GameState;
import gyte.cse443.etd.screen.WelcomeState;
import org.flixel.FlxGame;

public class FlixelGame extends FlxGame {

    public static final int SCREEN_WIDTH = 480, SCREEN_HEIGHT = 640;

    public FlixelGame() {
        super(SCREEN_HEIGHT, SCREEN_WIDTH, WelcomeState.class, 1, 50, 50);
    }

}
