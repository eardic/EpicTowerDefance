package gyte.cse443.etd;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class GameSettings {

	private int difficulty;
	private int musicVol;
	private int soundVol;

	public GameSettings(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * @return the musicVol
	 */
	public int getMusicVol() {
		return musicVol;
	}

	/**
	 * @param musicVol the musicVol to set
	 */
	public void setMusicVol(int musicVol) {
		this.musicVol = musicVol;
	}

	/**
	 * @return the soundVol
	 */
	public int getSoundVol() {
		return soundVol;
	}

	/**
	 * @param soundVol the soundVol to set
	 */
	public void setSoundVol(int soundVol) {
		this.soundVol = soundVol;
	}
	
}//end GameSettings