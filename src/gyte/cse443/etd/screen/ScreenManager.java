package gyte.cse443.etd.screen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class ScreenManager {

	private Map<ScreenType, Screen> screens;
	private Screen currentScreen;

	public ScreenManager() {
		screens = new HashMap<ScreenType, Screen>();
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
	
	public void addScreen(Screen scr, ScreenType type)
	{
		screens.put(type, scr);
	}
	
	public void removeScreen(ScreenType type)
	{
		screens.remove(type);
	}

	/**
	 * @return the currentScreen
	 */
	public Screen getCurrentScreen() {
		return currentScreen;
	}

	/**
	 * @param currentScreen
	 *            the currentScreen to set
	 */
	private void setCurrentScreen(Screen currentScreen) {
		this.currentScreen = currentScreen;
	}

}// end ScreenManager