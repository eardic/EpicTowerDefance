/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyte.cse443.etd.objects;

import gyte.cse443.etd.Factory;
import gyte.cse443.etd.Resources;

/**
 *
 * @author Emre
 */
public class TowerFactory implements Factory {

    public Tower create(String type) {
        if (TowerType.CRYSTAL_TOWER.name().equals(type)) {
            Tower t = new Tower(TowerType.CRYSTAL_TOWER,BulletType.RED,90, 200, 700);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "3"),false,false,32,64);
            return t;
        }
        if (TowerType.BLOOD_MAGIC.name().equals(type)) {
            Tower t = new Tower(TowerType.BLOOD_MAGIC,BulletType.RED,80, 350, 600);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "5"),false,false,32,64);
            return t;
        }
        if (TowerType.CHINESE_TOWER.name().equals(type)) {
            Tower t = new Tower(TowerType.CHINESE_TOWER,BulletType.GREEN,70, 400, 200);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "7"),false,false,32,64);
            return t;
        }
        if (TowerType.CANNON_TOWER.name().equals(type)) {
            Tower t = new Tower(TowerType.CANNON_TOWER,BulletType.RED,60, 400, 300);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "11"),false,false,32,64);
            return t;
        }
        if (TowerType.RIFLE_TOWER.name().equals(type)) {
            Tower t = new Tower(TowerType.RIFLE_TOWER,BulletType.BLUE,50, 300, 200);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "12"),false,false,32,64);
            return t;
        }
        if (TowerType.GHOST_TOWER.name().equals(type)) {
            Tower t = new Tower(TowerType.GHOST_TOWER,BulletType.GREEN,50, 300, 100);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "10"),false,false,32,64);
            return t;
        }
        if (TowerType.WATER_MAGIC.name().equals(type)) {
            Tower t = new Tower(TowerType.WATER_MAGIC,BulletType.BLUE,50, 300, 400);
            t.loadGraphic(Resources.towerImg.replaceAll("#", "6"),false,false,32,64);
            return t;
        }
        
        return null;
    }

}
