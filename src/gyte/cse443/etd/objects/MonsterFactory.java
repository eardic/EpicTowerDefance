/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.objects;

import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;
import org.flixel.FlxObject;

/**
 * 
 * @author Emre
 */
public class MonsterFactory implements Factory {

	private Monster loadMonster(MonsterType type, int point, int fileNo) {
		Monster m = new Monster(type);
		m.loadGraphic(Resources.monsterImg.replaceAll("#", fileNo + ""), true,
				true, 32, 32);
		m.addAnimation("walk", new int[] { 0, 1, 2 }, 5, true);
		m.play("walk");
		m.setPoint(point);
		return m;
	}

	public Monster create(String type) {
		if (MonsterType.DRAGON.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.DRAGON, 600, 1);
		}
		if (MonsterType.ALIEN.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.ALIEN, 700, 2);
		}
		if (MonsterType.GOLEM.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.GOLEM, 500, 3);
		}
		if (MonsterType.LIZARD.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.LIZARD, 300, 4);
		}
		if (MonsterType.TREX.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.TREX, 100, 5);
		}
		if (MonsterType.TROLL.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.TROLL, 200, 6);
		}
		if (MonsterType.WOLF.name().equalsIgnoreCase(type)) {
			return loadMonster(MonsterType.WOLF, 400, 7);
		}
		return null;
	}

}
