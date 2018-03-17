package io.scottd.fizz2ddemos;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.World;
import io.scottd.fizz2d.world.WorldConfiguration;
import io.scottd.fizz2ddemos.bouncingBallDemo.BouncingBallView;

public abstract class AbstractGameDemo {
    public World world;
    public AbstractGameView view;
    protected Vector2 viewScale;

    protected static final int RESOLUTION_X = 800;
    protected static final int RESOLUTION_Y = 600;

    protected AbstractGameDemo() {
        WorldConfiguration config = createWorldConfiguration();
        world = new World(config);
        viewScale = new Vector2(RESOLUTION_X/config.worldSize.x,
                RESOLUTION_Y /config.worldSize.y);
        view = new BouncingBallView(RESOLUTION_X, RESOLUTION_Y,
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