package bouncingBallDemo;

import bouncingBallDemo.views.Ball;
import fizz2d.world.World;
import utilities.Vector2D;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    private static int resolutionX, resolutionY;
    private static World world;
    private static BouncingBallView view;

    public static void main(String[] args) {

    }

    private BouncingBallsDemo() {
        Vector2D worldSize = new Vector2D(2000,2000);
        world = new World(worldSize);
        Vector2D viewScale = new Vector2D(1600/worldSize.x,
                            900/worldSize.y);
        view = new BouncingBallView(1600, 900,
                viewScale);

    }

    public void gameLoop() {
        long lastFrameTime = System.currentTimeMillis()-30;
        while (true) {
            long currentTime = System.currentTimeMillis();
            double delta = (currentTime - lastFrameTime)/1000.0;
            lastFrameTime = currentTime;

            world.update(delta);
        }
    }

    private void setupGame(Vector2D scale) {
        Ball ball = new Ball(scale.x, scale.y);

    }
}
