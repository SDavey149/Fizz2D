package bouncingBallDemo;

import bouncingBallDemo.views.AbstractGameView;
import fizz2d.world.World;

/**
 * Created by scottdavey on 03/08/2017.
 */
public class GameLoopRunnable implements Runnable {
    private static double DESIRED_FRAMES_PER_SECOND = 60;
    private static final int DELAY = (int)((1/DESIRED_FRAMES_PER_SECOND)*1000.0);

    private World world;
    private AbstractGameView view;
    private boolean isRunning;
    private long lastTime;

    public GameLoopRunnable(World world, AbstractGameView view) {
        isRunning = true;
        this.world = world;
        this.view = view;
    }
    @Override
    public void run() {
        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            long deltaMilliseconds = (currentTime - lastTime);
            if (lastTime == 0) {
                deltaMilliseconds = DELAY;
            }

            lastTime = currentTime;
            world.update(deltaMilliseconds/1000.0);
            view.repaint();
            try {
                long delay = DELAY;
                long frameDifference = deltaMilliseconds-DELAY;
                if (frameDifference > 0) {
                    delay -= frameDifference;
                }
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}
