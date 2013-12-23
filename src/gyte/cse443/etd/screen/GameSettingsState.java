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
import org.flixel.ui.FlxNinePatchButton;
import org.flixel.ui.FlxUIComponent;
import org.flixel.ui.event.IFlxUIListener;

/**
 * 
 * @author Emre
 */

// haci bu class senin baslangic menundeki class,ndaki options icin olcak ve ses
// ve muzik siddeti ayarlicak
public class GameSettingsState extends FlxState {

	private FlxUIComponent onOff;
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

		FlxText soundText = new FlxText(FlxG.width / 2 - 100,
				FlxG.height / 2 - 20, 0, "Sound");
		soundText.setFormat(Resources.vinerHandFont, 30);
		soundText.antialiasing = true;

		onOff = new FlxNinePatchButton(FlxG.width / 2 + 60,
				FlxG.height / 2 - 20, null, "ON",0,0, new IFlxUIListener() {
					public void callback() {
						// TODO Auto-generated method stub
						onOff();
					}
				});
		onOff.label.setFormat(Resources.vinerHandFont, 30);

		add(soundText);
		add(onOff);

	}

	private void onOff() {
		if (FlxG.getVolume() <= 0f) {
			FlxG.setVolume(1f);
			onOff.label.setText("ON");
		} else {
			FlxG.setVolume(0f);
			onOff.label.setText("OFF");
		}
	}

}
