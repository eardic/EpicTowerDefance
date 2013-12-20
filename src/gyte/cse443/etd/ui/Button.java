/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.ui;

import gyte.cse443.etd.Resources;
import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.event.IFlxButton;

/**
 *
 * @author Emre
 */
public class Button extends FlxButton {

    public Button(int x, int y, String img, IFlxButton onClick) {
        super(x, y, null, onClick);
        if (img != null) {
            loadGraphic(img);
            antialiasing = true;
        }
        soundDown = FlxG.loadSound(Resources.buttonClick);
        soundDown.survive = true;
    }
}
