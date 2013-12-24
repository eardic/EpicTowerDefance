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

/**
 * 
 * @author Emre
 */
public class MapSettingsState extends FlxState {

	private FlxSprite mapPanel;
	private int currMap=1;
	
	@Override
	public void create() {
		
		mapPanel = new FlxSprite(FlxG.width/2-320/2, FlxG.height/2-240/2);
		mapPanel.loadGraphic(Resources.mapImg.replaceAll("#",""+currMap),false,false,320,240);
		
		Button prev = new Button(50, FlxG.height/2-25, Resources.arrow, 50,50, new IFlxButton() {			
			public void callback() {
				// TODO Auto-generated method stub
				if(currMap>1){
					--currMap;
					mapPanel.loadGraphic(Resources.mapImg.replaceAll("#",""+currMap),false,false,320,240);
				}
			}
		});
		prev.angle = 180;
		
		Button next = new Button(FlxG.width-100, FlxG.height/2-25, Resources.arrow, 50,50, new IFlxButton() {
			public void callback() {
				// TODO Auto-generated method stub
				if(currMap < 10){
					++currMap;
					mapPanel.loadGraphic(Resources.mapImg.replaceAll("#",""+currMap),false,false,320,240);
				}
			}
		});				
		
		Button start = new Button(FlxG.width/2-158, FlxG.height - 100, Resources.startGame, 316,91, new IFlxButton() {
			public void callback() {
				// TODO Auto-generated method stub
				FlxG.switchState(new GameState(currMap));
			}
		});		
		
		FlxText header = new FlxText(10, 10, 0, "Map Select");
		header.setFormat(Resources.vinerHandFont,30);
		
		add(new FlxSprite(0,0).loadGraphic(Resources.menuBg));
		add(header);
		add(start);
		add(prev);
		add(next);
		add(mapPanel);
	}
	
	

}
