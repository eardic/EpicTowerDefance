/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.screen;

import android.graphics.Color;
import gyte.cse443.etd.Resources;
import org.flixel.FlxG;
import org.flixel.FlxSound;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.FlxText;

/**
 *
 * @author Emre
 */
public class WelcomeState extends FlxState {

    @Override
    public void create() {
        FlxText name = new FlxText(FlxG.width / 2 - 285, 50, 0, "EPIC TOWER DEFENCE");
        name.setFormat(Resources.vinerHandFont, 50, Color.WHITE);
        name.antialiasing = true;

        FlxText touch = new FlxText(FlxG.width / 2 - 137, FlxG.height - 100, 0, "Touch to Start");
        touch.setFormat(Resources.vinerHandFont, 40, Color.WHITE);
        touch.antialiasing = true;

        add(new FlxSprite(0, 0, Resources.menuBg));
        add(name);
        add(touch);
    }

    @Override
    public void update() {
        super.update();
        if (FlxG.mouse.justReleased()) {
            FlxSound s = FlxG.play(Resources.buttonClick);
            s.survive = true;
            FlxG.switchState(new StartMenuState());
        }
    }
}
