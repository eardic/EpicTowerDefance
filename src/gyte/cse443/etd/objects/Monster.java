package gyte.cse443.etd.objects;

import android.graphics.Color;
import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Monster extends FlxSprite {

    private MonsterType type;
    private int point=100;

    public Monster(MonsterType type) {
        super(0, 0);
        this.type = type;
        this.health = 100;
        this.immovable = true;
        this.allowCollisions = FlxObject.ANY;
    }
    
    

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }



	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}



	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

}//end Monster
