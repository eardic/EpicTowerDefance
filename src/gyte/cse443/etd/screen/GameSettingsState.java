/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.screen;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.ui.Button;

import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.FlxText;
import org.flixel.event.IFlxButton;
import org.flixel.ui.FlxNinePatchButton;
import org.flixel.ui.FlxSwitch;
import org.flixel.ui.FlxUIComponent;
import org.flixel.ui.FlxUISkin;
import org.flixel.ui.event.IFlxUIListener;

/**
 *
 * @author Emre
 */
// haci bu class senin baslangic menundeki class,ndaki options icin olcak ve ses
// ve muzik siddeti ayarlicak
public class GameSettingsState extends FlxState {

	private FlxSwitch _switch;
    private Button back;

    @Override
    public void create() {

        add(new FlxSprite(0, 0).loadGraphic(Resources.menuBg));
        add(new Button(FlxG.width / 2 - 158, FlxG.height - 100, Resources.back,
                new IFlxButton() {
                    public void callback() {
                        // TODO Auto-generated method stub
                        FlxG.switchState(new StartMenuState());
                    }
                }));  
        
        _switch = new FlxSwitch(FlxG.width/2, FlxG.height/2, "ON", null, "Sound");
        _switch.label.setFormat(Resources.vinerHandFont, 30);
        _switch.label.offset.y += 10;
        _switch.setActive(FlxG.mute);     
        _switch.onDown = new IFlxUIListener()
        {
               public void callback() {
            	// TODO Auto-generated method stub
            	if(_switch.getActivated()){
            		 FlxG.mute = true;
            	}else{
            		FlxG.mute = false;
            	}
            }
        };        
        
        add(_switch);

    }

}
