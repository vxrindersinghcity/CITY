package Entity.PLAYER;

import Entity.Attack.WindAttack;
import city.cs.engine.*;
import game.levels.GameLevel;
import org.jbox2d.common.Vec2;

public class Player extends Walker {
    private static final Shape playerShape = new BoxShape(1, 1.6f);
    private static final BodyImage idleImage = new BodyImage("data/JunglePack/Character/idle.gif", 4f);
    private GameLevel gameLevel;
    private int creditCount = 0;
    private int health;


    public Player(GameLevel level, Vec2 position) {
        super(level);
        this.gameLevel = level;
        health = 100;
        addImage(idleImage);
        SolidFixture fixture = new SolidFixture(this, playerShape);
        setPosition(position);
    }

    public void addCredits() {
        creditCount++;
    }

    public int getCreditCount() {
        return creditCount;
    }



    public void spawnWindAttack(boolean facingRight) {
        Vec2 attackPosition = getPosition().add(new Vec2(facingRight ? 1 : -1, 0));
            new WindAttack(gameLevel, attackPosition, facingRight);
    }

    public void decreaseHealth(String name) {
        switch (name){
            case "Opossum":
                health -= 10;
                if (health <= 0) {
                    gameLevel.stop();
                    gameLevel.getGame().showGameOverMenu();
                }

                break;
            case "Wolf":
                health -= 20;
                if (health <= 0) {
                    gameLevel.stop();
                    gameLevel.getGame().showGameOverMenu();
                }
            case "Eagle":
                health -= 30;

                    break;
            default:
                health -= 0;
                break;
        }
    }

    public int getHealth() {
        return health;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void healUP() {
        if (health <= 90) {
            health += 10;
        }else{
            health = 100;
        }
    }

    public void resetCredits() {
        creditCount = 0;
    }
}
