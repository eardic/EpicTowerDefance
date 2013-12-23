package gyte.cse443.etd.screen;

import android.graphics.Color;
import gyte.cse443.etd.Resources;
import gyte.cse443.etd.map.Map;
import gyte.cse443.etd.map.MapFactory;
import gyte.cse443.etd.objects.Bullet;
import gyte.cse443.etd.objects.BulletManager;
import gyte.cse443.etd.objects.MonsterManager;
import gyte.cse443.etd.objects.TowerManager;
import gyte.cse443.etd.ui.Button;
import gyte.cse443.etd.ui.TextField;
import org.flixel.FlxButton;
import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.event.IFlxButton;
import org.flixel.event.IFlxCollision;
import org.flixel.ui.FlxInputText;

public class GameState extends FlxState {

    // Indicators
    private FlxButton startStopButton, menuButton, speedButton;
    private FlxInputText money, lives, score;

    private boolean paused = true;

    // Map,level, monster & tower manager
    private Map map;
    private Integer level;
    private MonsterManager monsterMan;
    private TowerManager towerMan;
    private BulletManager bulletMan;

    public GameState(int level) {
        this.level = level;

        map = new MapFactory().create("" + level);
        monsterMan = new MonsterManager(map, level);
        towerMan = new TowerManager(map, level);
        bulletMan = new BulletManager(map, towerMan.getPurchasedTowers(),
                monsterMan.getWalkingMonsters());

        startStopButton = new Button(20, 7, Resources.startButton, 50, 50, new StartPauseEvent());
        speedButton = new Button(100, 7, Resources.x1Button, 50, 50, new SpeedEvent());
        money = new TextField(180, 26, 100, 30, "Resources", "500");
        lives = new TextField(310, 26, 100, 30, "Lives", "5");
        score = new TextField(440, 26, 100, 30, "Score", "0");
        menuButton = new Button(570, 7, Resources.menuButton, 50, 50, new MenuEvent());
    }

    public GameState() {
        this(5);
    }

    @Override
    public void create() {
        add(map);
        add(new FlxSprite().makeGraphic(FlxG.width, 64, Color.argb(255, 0, 0, 0)));
        add(startStopButton);
        add(speedButton);
        add(money);
        add(lives);
        add(score);
        add(menuButton);
        add(monsterMan);
        add(towerMan);
        add(bulletMan);
    }

    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
        FlxG.overlap(monsterMan, bulletMan, new IFlxCollision() {
            public void callback(FlxObject monster, FlxObject bullet) {
                Bullet b = ((Bullet) bullet);
                monster.hurt(b.getDamage());
                b.kill();
            }
        });
    }

    private class StartPauseEvent implements IFlxButton {

        public void callback() {
            // TODO Auto-generated method stub
            System.out.println("Started/Paused");
            if (paused) {// Paused and pressed play button
                monsterMan.callMonsters(1);
                startStopButton.loadGraphic(Resources.pauseButton, false, false, 50, 50);
                pauseGame(false);
            } else {// Not paused and pressed pause button
                pauseGame(true);
                startStopButton.loadGraphic(Resources.startButton, false, false, 50, 50);
            }
        }

    }

    private void pauseGame(boolean pause) {
        monsterMan.active = !pause;
        towerMan.active = !pause;
        bulletMan.active = !pause;
        this.paused = pause;
    }

    private class MenuEvent implements IFlxButton {

        public void callback() {
            // TODO Auto-generated method stub
            System.out.println("Menu");
        }

    }

    private class SpeedEvent implements IFlxButton {

        private boolean slow = true;

        public void callback() {

            System.out.println("Speed");
            if (slow) {// current is slow, want faster
                speedButton.loadGraphic(Resources.x2Button, false, false, 50, 50);
                slow = !slow;
                monsterMan.setSpeed(200);
            } else {
                speedButton.loadGraphic(Resources.x1Button, false, false, 50, 50);
                slow = !slow;
                monsterMan.setSpeed(100);
            }
        }

    }

}
