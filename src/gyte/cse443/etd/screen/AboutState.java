/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.screen;

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
public class AboutState extends FlxState {	
	
	private FlxButton back;	
	
    @Override
    public void create() {
        
    	// geri ok isareti resourceslara eklenecek
    	back = new Button(FlxG.width / 2 - 158, FlxG.height - 100, Resources.back, new ReturnBack());
    
    	FlxText about = new FlxText(FlxG.width / 2 - 100, 50, 0, "CREATED BY : \n Emre ARDIC \n Ramazan CELIK \n Fatma CELIK");
    	about.setFormat(Resources.vinerHandFont, 30);
    	about.antialiasing = true;
    	
    	add(new FlxSprite(0,0).loadGraphic(Resources.menuBg));
        add(back);
        add(about) ;
    	
    }
    
  
    
    // LISTENER CLASSES FOR BUTTONS
    private class ReturnBack implements IFlxButton {

        public void callback() {
        	
        	FlxG.switchState(new StartMenuState());
        }

    }

   
}
