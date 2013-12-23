/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.ui;

import android.graphics.Color;
import static gyte.cse443.etd.ui.MenuBar.ALIGN_VERTICAL;
import org.flixel.FlxBasic;
import org.flixel.FlxGroup;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;
import org.flixel.ui.FlxUIGroup;

/**
 * Vertical list box
 *
 * @author Emre
 */
public class ListBox extends FlxGroup {

    private int x, y, bgColor;
    private int marginSides;
    private FlxSprite box;

    public ListBox(int x, int y) {
        this(x, y, 5, Color.BLACK);
    }

    public ListBox(int x, int y, int marginSides, int bgColor) {
        super();
        this.x = x;
        this.y = y;
        this.bgColor = bgColor;
        this.marginSides = marginSides;
        this.box = new FlxSprite(x, y);
        box.height = marginSides;
        super.add(box);
    }

    public float getWidth() {
        return box.width;
    }
    
    public float getHeight(){
        return box.height;
    }

    @Override
    public FlxBasic add(FlxBasic Object) {
        FlxObject b = (FlxObject) Object;
        b.x = this.x + marginSides;
        b.y = this.y + (marginSides * (length)) + (b.height * (length - 1));

        box.width = b.width + marginSides * 2;
        box.height += b.height + marginSides;
        box.makeGraphic((int) box.width, (int) box.height, bgColor);
        return super.add(Object);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMarginSides() {
        return marginSides;
    }

    public void setMarginSides(int marginSides) {
        this.marginSides = marginSides;
    }

}
