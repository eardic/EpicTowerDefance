package gyte.cse443.etd.objects;

import org.flixel.FlxObject;
import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Bullet extends FlxSprite {

    private int damage;

    public Bullet(String img, int dmg) {
        super(0, 0, img);
        this.damage = dmg;
    }

}//end Bullet
