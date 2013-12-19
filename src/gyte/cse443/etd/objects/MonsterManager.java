package gyte.cse443.etd.objects;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class MonsterManager {

	private List<Monster> monsters;

	public MonsterManager(){
		monsters = new ArrayList<Monster>();
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param m
	 */
	public void addMonster(Monster m){
		monsters.add(m);
	}

	/**
	 * 
	 * @param m
	 */
	public void removeMonster(Monster m){
		monsters.remove(m);
	}
}//end MonsterManager