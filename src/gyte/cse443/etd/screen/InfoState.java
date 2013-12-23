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
import org.flixel.FlxState;
import org.flixel.FlxText;
import org.flixel.event.IFlxButton;

/**
 *
 * @author Emre
 */
public class InfoState extends FlxState {
	
	private FlxButton back;
	
	private FlxState oldState ;
	
	public InfoState(FlxState oldState){
		
		this.oldState = oldState ;
	}
	
    @Override
    public void create() {
        
    	// geri ok isareti resourceslara eklenecek
    	back = new Button(FlxG.width / 2 - 158, 110, Resources.back, new ReturnBack());
    
    	FlxText info = new FlxText(FlxG.width / 2 - 100, 50, 0, "Watch out to monsters ! \n Just touch screen. \nBe speed !");
    	info.antialiasing = true;
    	
        add(back);
        add(info) ;
    	
    }
    
    // LISTENER CLASSES FOR BUTTONS
    private class ReturnBack implements IFlxButton {

        public void callback() {
        	
        	FlxG.switchState(oldState);
        }

    }

}
