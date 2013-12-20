package gyte.cse443.etd.screen;

import java.util.HashMap;
import java.util.Map;
import org.flixel.FlxState;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class ScreenManager {

    private Map<ScreenType, FlxState> screens;
    private FlxState currentScreen;

    public ScreenManager() {
        screens = new HashMap<ScreenType, FlxState>();
        setCurrentScreen(null);
    }

    public void finalize() throws Throwable {
        screens.clear();
        super.finalize();
    }

    public void changeScreen(ScreenType newScr) {
        setCurrentScreen(screens.get(newScr));
    }

    public void draw() {

    }

    public void addScreen(FlxState scr, ScreenType type) {
        screens.put(type, scr);
    }

    public void removeScreen(ScreenType type) {
        screens.remove(type);
    }

    /**
     * @return the currentScreen
     */
    public FlxState getCurrentScreen() {
        return currentScreen;
    }

    /**
     * @param currentScreen the currentScreen to set
     */
    private void setCurrentScreen(FlxState currentScreen) {
        this.currentScreen = currentScreen;
    }

}// end ScreenManager
