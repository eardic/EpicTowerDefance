package gyte.cse443.etd.map;

import org.flixel.FlxSprite;

import gyte.cse443.etd.Factory;

public class MapFactory implements Factory {

	private FlxSprite loadedMap;

	/**
	 * Gets map path
	 * 
	 * @param image
	 */
	public MapFactory(String file) {
		loadedMap = new FlxSprite().loadGraphic(file);
	}	

	public FlxSprite create() {
		return loadedMap;
	}

}
