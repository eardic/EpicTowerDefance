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

    public Monster create(String type) {
        if (MonsterType.KNIGHT.name().equalsIgnoreCase(type)) {
            return new Monster(MonsterType.KNIGHT, Resources.knight);
        }
        return null;
    }

}
