/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.ui;

import android.graphics.Color;
import gyte.cse443.etd.Resources;
import org.flixel.FlxSprite;
import org.flixel.ui.FlxInputText;
import org.flixel.ui.FlxUISkin;

/**
 *
 * @author Emre
 */
public class TextField extends FlxInputText {

    public TextField(float X, float Y, String Label, int Width, int Height) {
        super(X, Y, null, Label, Width, Height);
        label.setColor(Color.WHITE);
        label.setSize(20);
        label.setFont(Resources.robotoFont);
        setEnable(false);
        textfield.setFormat(Resources.robotoFont, 20, Color.WHITE);
        antialiasing = true;        
    }

    public TextField(float X, float Y, int Width, int Height, String label, String text) {
        this(X, Y, label, Width, Height);
        setText(text);
    }

}
