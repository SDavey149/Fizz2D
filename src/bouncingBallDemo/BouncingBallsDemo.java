package bouncingBallDemo;

import bouncingBallDemo.views.AbstractGameView;
import bouncingBallDemo.views.game.Ball;
import fizz2d.world.integrators.ImprovedEulers;
import fizz2d.world.World;
import utilities.JEasyFrame;
import utilities.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    public World world;
    public AbstractGameView view;
    private static final long TIME_BETWEEN_FRAME = 1000/60;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        Vector2 worldSize = new Vector2(80,60);
        world = new World(worldSize);
        Vector2 viewScale = new Vector2(800/worldSize.x,
                            600/worldSize.y);
        view = new BouncingBallView(800, 600,
                viewScale);
        setupGame(viewScale);
    }

    public void gameLoop() {
        //TODO: this needs fixing so it's not on the main thread
        /*while (true) {
            world.update(0.016);
            view.repaint();
            try {
               Thread.sleep(TIME_BETWEEN_FRAME);
            } catch (InterruptedException e) {
                //no operation
            }

        }*/

        Timer t = new Timer(16, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.update(0.016);
                view.repaint();
            }
        });
        t.start();
    }



    private void setupGame(Vector2 scale) {
        Ball ball = new Ball(scale.x, scale.y, Color.CYAN);
        Ball ball2 = new Ball(scale.x, scale.y, Color.RED);
        ball2.setIntegrator(new ImprovedEulers());

        world.addGameObjects(ball.getParticles());
        world.addGameObjects(ball2.getParticles());
        view.registerGameComponent(ball);
        view.registerGameComponent(ball2);
    }
}
