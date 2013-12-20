package gyte.cse443.etd.objects;

import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Monster extends FlxSprite {

    private MonsterType type;

    public Monster(MonsterType type, String image) {
        super(0, 0, image);
        this.type = type;
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

}//end Monster
