/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.objects;

import android.graphics.Color;
import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;

import org.flixel.FlxObject;

/**
 * 
 * @author Emre
 */
public class BulletFactory implements Factory {

	public Bullet create(String type) {
		if ("red".equalsIgnoreCase(type)) {
			Bullet b = new Bullet(10);
			b.pathSpeed = 200;
			b.loadGraphic(Resources.bulletImg.replace("#", "red"), true, true,
					10, 10);
			b.addAnimation("shot", new int[] { 0, 1, 2, 3 }, 15, true);
			b.play("shot");
			return b;
		} else if ("blue".equalsIgnoreCase(type)) {
			Bullet b = new Bullet(15);
			b.pathSpeed = 300;
			b.loadGraphic(Resources.bulletImg.replace("#", "blue"), true, true,
					10, 10);
			b.addAnimation("shot", new int[] { 0, 1, 2, 3 }, 15, true);
			b.play("shot");
			return b;
		} else if ("green".equalsIgnoreCase(type)) {
			Bullet b = new Bullet(20);
			b.pathSpeed = 400;
			b.loadGraphic(Resources.bulletImg.replace("#", "green"), true,
					true, 10, 10);
			b.addAnimation("shot", new int[] { 0, 1, 2, 3 }, 15, true);
			b.play("shot");
			return b;
		}
		return null;
	}

}
