package gyte.cse443.etd.audio;

import org.flixel.FlxSound;

public class Audio extends FlxSound {
	private AudioType type;

	/**
	 * @return the type
	 */
	public AudioType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AudioType type) {
		this.type = type;
	}
}
