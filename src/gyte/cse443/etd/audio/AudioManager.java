package gyte.cse443.etd.audio;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class AudioManager {

	private Map<Integer, Audio> audios;

	public AudioManager() {
		audios = new HashMap<Integer, Audio>();
	}

	public void finalize() throws Throwable {

	}

	public void loadAudios() {

	}

	/**
	 * 
	 * @param id
	 */
	public void pause(int id) {
		audios.get(id).pause();
	}
	
	public void pauseAll()
	{
		for (Integer i : audios.keySet()) {
			pause(i);
		}
	}
	
	public void resumeAll()
	{
		for (Integer i : audios.keySet()) {
			resume(i);
		}
	}
	
	public void stopAll()
	{
		for (Integer i : audios.keySet()) {
			stop(i);
		}
	}
	
	public void playAll()
	{
		for (Integer i : audios.keySet()) {
			play(i);
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void play(int id) {
		audios.get(id).play();
	}

	/**
	 * 
	 * @param id
	 */
	public void resume(int id) {
		audios.get(id).resume();
	}

	public void setVolume(AudioType type, int vol) {
		Set<Integer> keys = audios.keySet();
		for (Integer i : keys) {
			Audio a = audios.get(i);
			if (a.getType() == type) {
				a.setVolume(vol);
			}
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void stop(int id) {
		audios.get(id).stop();
	}
}// end AudioManager