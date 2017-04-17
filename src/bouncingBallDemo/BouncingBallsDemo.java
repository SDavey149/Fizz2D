package bouncingBallDemo;

import bouncingBallDemo.views.Ball;
import fizz2d.world.World;
import utilities.JEasyFrame;
import utilities.Vector2D;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    public World world;
    public BouncingBallView view;

    public static void main(String[] args) {
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 600);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        Vector2D worldSize = new Vector2D(800,600);
        world = new World(worldSize);
        Vector2D viewScale = new Vector2D(800/worldSize.x,
                            600/worldSize.y);
        view = new BouncingBallView(800, 600,
                viewScale);
        setupGame(viewScale);
    }

    public void gameLoop() {
        long lastFrameTime = System.currentTimeMillis()-30;
        while (true) {
            long currentTime = System.currentTimeMillis();
            double delta = (currentTime - lastFrameTime)/1000.0;
            lastFrameTime = currentTime;

            world.update(delta);
            view.repaint();
        }
    }

    private void setupGame(Vector2D scale) {
        Ball ball = new Ball(scale.x, scale.y);
        world.addGameObject(ball.getParticle());
        view.AddGameObject(ball);
    }
}
