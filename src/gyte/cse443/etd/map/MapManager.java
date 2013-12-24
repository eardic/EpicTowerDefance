package gyte.cse443.etd.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class MapManager {

	private List<Map> maps;

	public MapManager(int mapCount) {
		maps = new ArrayList<Map>();
		// Load maps
		for (int i = 1; i <= mapCount; ++i) {
			maps.add(new MapFactory().create(""+i));
		}
	}

	public Map getMap(int level) {
		return maps.get(level);
	}

}// end MapManager
