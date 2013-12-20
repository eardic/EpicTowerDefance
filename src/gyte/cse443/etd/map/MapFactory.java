package gyte.cse443.etd.map;

import org.flixel.FlxSprite;

import gyte.cse443.etd.Factory;

public class MapFactory implements Factory {

    public FlxSprite create(String file) {
        return new FlxSprite().loadGraphic(file);
    }

}
