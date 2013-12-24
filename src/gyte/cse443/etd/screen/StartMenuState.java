/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.screen;

import android.graphics.Color;
import gyte.cse443.etd.Resources;
import gyte.cse443.etd.ui.Button;
import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.FlxText;
import org.flixel.event.IFlxButton;

/**
 *
 * @author Emre
 */
public class StartMenuState extends FlxState {

    private FlxButton startGame, options, about, exit;

    @Override
    public void create() {
        FlxText name = new FlxText(FlxG.width / 2 - 285, 50, 0, "EPIC TOWER DEFENCE");
        name.setFormat(Resources.vinerHandFont, 50, Color.WHITE);
        name.antialiasing = true;

        startGame = new Button(FlxG.width / 2 - 158, 110, Resources.startGame, 316, 91, new StartGame());
        options = new Button(FlxG.width / 2 - 158, 200, Resources.options, 316, 91, new Options());
        about = new Button(FlxG.width / 2 - 158, 290, Resources.about, 316, 91, new About());
        exit = new Button(FlxG.width / 2 - 158, 380, Resources.exitGame, 316, 91, new Exit());

        add(new FlxSprite(0, 0, Resources.menuBg));
        add(name);
        add(startGame);
        add(options);
        add(about);
        add(exit);
    }

    // LISTENER CLASSES FOR BUTTONS
    private class StartGame implements IFlxButton {

        public void callback() {
            FlxG.switchState(new MapSettingsState());
        }

    }

    private class Options implements IFlxButton {

        public void callback() {        	
        	FlxG.switchState(new GameSettingsState());
        }

    }

    private class About implements IFlxButton {
    	
        public void callback() {        	
        	FlxG.switchState(new AboutState());
        }

    }

    private class Exit implements IFlxButton {

        public void callback() {        	
        	System.exit(1);  
        }
    }

}
