package gyte.cse443.etd.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class TowerManager {

	private List<Tower> towers;

	public TowerManager(){
		towers = new ArrayList<Tower>();
	} 

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param tower
	 */
	public void addTower(Tower tower){
		towers.add(tower);
	}

	/**
	 * 
	 * @param tower
	 */
	public void removeTower(Tower tower){
		towers.remove(tower);
	}
}//end TowerManager