package gyte.cse443.etd.objects;

import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:10
 */
public class Bullet extends FlxSprite {

    private int damage;

    public Bullet(String img, int dmg, int color) {
        super(0, 0, img);
        this.damage = dmg;
        makeGraphic(5, 5, color);
        this.immovable = true;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Bullet X:" + x + ",Y:" + y + ",Dmg:" + damage;
    }

}//end Bullet
