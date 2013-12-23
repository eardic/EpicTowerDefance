package gyte.cse443.etd.objects;

import gyte.cse443.etd.Resources;
import gyte.cse443.etd.map.Map;
import gyte.cse443.etd.ui.Button;
import gyte.cse443.etd.ui.ListBox;
import java.util.ArrayList;
import java.util.List;
import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.event.IFlxButton;

/**
 * @author Emre
 * @version 1.0
 * @created 03-Dec-2013 12:43:11
 */
public class TowerManager extends FlxGroup {

    private final List<Tower> purchasedTowers;
    private final int level;
    private ListBox towerBox;
    private final TowerFactory towerFactory;
    private final Map map;

    public TowerManager(Map map, int level) {
        this.towerFactory = new TowerFactory();
        this.purchasedTowers = new ArrayList<Tower>();
        this.level = level;
        this.towerBox = null;//Closed
        this.map = map;
    }

    public List<Tower> getPurchasedTowers() {
        return purchasedTowers;
    }

    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
        if (FlxG.mouse.justPressed()) {
            openTowerBox(FlxG.mouse.screenX, FlxG.mouse.screenY);
        }
    }

    public int getTotalCost() {
        int cost = 0;
        for (Tower t : purchasedTowers) {
            cost += t.getCost();
        }
        return cost;
    }

    private boolean isValidTile(int x, int y) {
        int tileX = map.getTileX(x);
        int tileY = map.getTileY(y);
        int tile = map.getTile(tileX, tileY);
        return tile == map.getTowerTile();
    }

    private void openTowerBox(int x, int y) {

        if (isOutOfBox(x, y)) {// If user press out of list
            if (towerBox != null) {// If list is open
                closeTowerBox();// Close list
            }//Else open new list 
            else if (isValidTile(x, y) && y > 64) {// 64 is indicator height            
                towerBox = new ListBox(x, y);
                towerBox.add(new Button(TowerType.BLOOD_MAGIC.name(), new SelectedItem(x, y, TowerType.BLOOD_MAGIC)));
                towerBox.add(new Button(TowerType.WATER_MAGIC.name(), new SelectedItem(x, y, TowerType.WATER_MAGIC)));
                towerBox.add(new Button(TowerType.CANNON_TOWER.name(), new SelectedItem(x, y, TowerType.CANNON_TOWER)));
                towerBox.add(new Button(TowerType.CRYSTAL_TOWER.name(), new SelectedItem(x, y, TowerType.CRYSTAL_TOWER)));
                towerBox.add(new Button(TowerType.GHOST_TOWER.name(), new SelectedItem(x, y, TowerType.GHOST_TOWER)));
                towerBox.add(new Button(TowerType.RIFLE_TOWER.name(), new SelectedItem(x, y, TowerType.RIFLE_TOWER)));
                towerBox.add(new Button(TowerType.CHINESE_TOWER.name(), new SelectedItem(x, y, TowerType.CHINESE_TOWER)));
                FlxG.play(Resources.showSound);
                add(towerBox);
            }
        }
    }

    private boolean isOutOfBox(int x, int y) {
        return towerBox == null || x < towerBox.getX() || y < towerBox.getY()
                || x > towerBox.getX() + towerBox.getWidth()
                || y > towerBox.getY() + towerBox.getHeight();
    }

    private void closeTowerBox() {
        if (towerBox != null) {// If open
            towerBox.kill();// Delete buttons of box
            towerBox.destroy();
            remove(towerBox);// Close tower list
            towerBox = null;
        }
    }

    private void putTowerToPressedTile(TowerType type, int x, int y) {
        // Create tower
        Tower t = towerFactory.create(type.name());

        // Finds tile index by x,y, and put ground of tower to pressed area
        int tileX = map.getTileX(x),
                tileY = map.getTileY(y) - (int) (t.height / map.getTileHeight()) + 1;
        // Set position
        t.x = tileX * map.getTileWidth();
        t.y = tileY * map.getTileHeight();

        purchasedTowers.add(t); // add to tower list
        add(t); // show tower on map
        FlxG.play(Resources.towerSound);
    }

    private class SelectedItem implements IFlxButton {

        private TowerType type;
        private int x, y;

        public SelectedItem(int x, int y, TowerType type) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public void callback() {
            putTowerToPressedTile(type, x, y);
            closeTowerBox(); // Close tower box
        }
    }

}//end TowerManager
