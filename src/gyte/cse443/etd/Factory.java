package gyte.cse443.etd;

import org.flixel.FlxObject;

public interface Factory {
	public FlxObject create(String type);
}
