package bouncingBallDemo;

import bouncingBallDemo.views.Ball;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import fizz2d.model.integrators.ImprovedEulers;
import fizz2d.world.World;
import utilities.JEasyFrame;
import utilities.Vector2D;

import java.awt.*;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    public World world;
    public BouncingBallView view;
    private static final long TIME_BETWEEN_FRAME = 1000/60;

    public static void main(String[] args) {
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        Vector2D worldSize = new Vector2D(80,60);
        world = new World(worldSize);
        Vector2D viewScale = new Vector2D(800/worldSize.x,
                            600/worldSize.y);
        view = new BouncingBallView(800, 600,
                viewScale);
        setupGame(viewScale);
    }

    public void gameLoop() {
        while (true) {
            world.update(0.016);
            view.repaint();
            try {
               Thread.sleep(TIME_BETWEEN_FRAME);
            } catch (InterruptedException e) {
                //no operation
            }

        }
    }

    private void setupGame(Vector2D scale) {
        Ball ball = new Ball(scale.x, scale.y, Color.CYAN);
        Ball ball2 = new Ball(scale.x, scale.y, Color.RED);
        ball2.setIntegrator(new ImprovedEulers());

        world.addGameObject(ball.getParticle());
        world.addGameObject(ball2.getParticle());
        view.AddGameObject(ball);
        view.AddGameObject(ball2);
    }
}
