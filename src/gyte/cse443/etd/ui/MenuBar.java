/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.ui;

import org.flixel.FlxBasic;
import org.flixel.FlxGroup;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;
import org.flixel.ui.FlxUIGroup;

/**
 * Default : Hhorizontal alignment 20 top margin, 20 left margin
 *
 * @author Emre
 */
public class MenuBar extends FlxGroup {

    public static final int ALIGN_HORIZONTAL = 1,
            ALIGN_VERTICAL = 0;

    private int x, y, w, h;
    private int marginTop, marginLeft;
    private String label = "";
    private int align = ALIGN_HORIZONTAL;

    public MenuBar(int x, int y, int w, int h, int marginTop,
            int marginLeft, int align, String label) {
        super();
        this.marginTop = marginTop;
        this.marginLeft = marginLeft;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.label = label;
        this.align = align;
    }

    public MenuBar(int x, int y, int w, int h, int mTop, int mLeft) {
        this(x, y, w, h, mTop, mLeft, ALIGN_HORIZONTAL, null);
    }

    public void addMenuItem(FlxObject obj) {
        if (align == ALIGN_VERTICAL) {
            obj.x += this.x;
            obj.y = this.y + (marginTop * length) + obj.y;
        } else {
            obj.x = this.x + (marginLeft * length) + obj.x;
            obj.y += this.y;
        }
        this.add(obj);
    }

    //SETTER-GETTER
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

    public int getWidth() {
        return w;
    }

    public void setWidth(int width) {
        this.w = width;
    }

    public int getHeight() {
        return h;
    }

    public void setHeight(int height) {
        this.h = height;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

}
