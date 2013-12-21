package gyte.cse443.etd.objects;

import org.flixel.FlxObject;
import org.flixel.FlxSprite;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class Tower extends FlxObject {

    private int cost;
    private int attackRange;
    private int attackSpeed;
    private FlxSprite image;

    public Tower(FlxSprite img, int attackRange, int attackSpeed, int cost) {
        setAttackRange(attackRange);
        setAttackSpeed(attackSpeed);
        setImage(img);
    }

    public void attack() {

    }

    public void checkRange() {

    }

    /**
     * @return the attackRange
     */
    public int getAttackRange() {
        return attackRange;
    }

    /**
     * @param attackRange the attackRange to set
     */
    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    /**
     * @return the attackSpeed
     */
    public int getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * @param attackSpeed the attackSpeed to set
     */
    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    /**
     * @return the image
     */
    public FlxSprite getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(FlxSprite image) {
        this.image = image;
    }
}//end Tower
