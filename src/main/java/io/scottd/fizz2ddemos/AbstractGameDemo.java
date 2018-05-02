package io.scottd.fizz2ddemos;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.World;
import io.scottd.fizz2d.world.WorldConfiguration;
import io.scottd.fizz2ddemos.bouncingBallDemo.BouncingBallView;

public abstract class AbstractGameDemo {
    public World world;
    public AbstractGameView view;
    public Vector2 viewScale;
    public int resolutionX;
    public int resolutionY;

    protected AbstractGameDemo(int resolutionX, int resolutionY) {
        WorldConfiguration config = createWorldConfiguration();
        world = new World(config);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;

        viewScale = new Vector2(resolutionX/config.worldSize.x,
                resolutionY/config.worldSize.y);
        view = new BouncingBallView(resolutionX, resolutionY,
                viewScale);
        setupGame();
    }

    public void gameLoop() {
        Thread gameThread = new Thread(new GameLoopRunnable(world, view));
        gameThread.start();
    }

    protected abstract WorldConfiguration createWorldConfiguration();

    protected abstract void setupGame();

}