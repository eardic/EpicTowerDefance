/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.objects;

import android.graphics.Color;
import gyte.cse443.etd.Factory;
import org.flixel.FlxObject;

/**
 *
 * @author Emre
 */
public class BulletFactory implements Factory {

    public Bullet create(String type) {
        Bullet b = new Bullet(null, 1, Color.RED);
        b.pathSpeed = 400;
        return b;
    }

}
