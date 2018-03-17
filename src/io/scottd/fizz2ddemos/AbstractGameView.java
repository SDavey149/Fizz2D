package io.scottd.fizz2ddemos;

import io.scottd.fizz2d.Vector2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottdavey on 11/04/2017.
 */
public abstract class AbstractGameView extends JComponent {
    private List<IGameComponent> gameComponents;
    protected int resolutionX, resolutionY;
    protected Vector2 scale;


    public AbstractGameView(int resolutionX, int resolutionY, Vector2 scale) {
        this.gameComponents = new ArrayList<>(10);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        this.scale = scale;
    }

    public abstract void setupGameComponents();

    public void registerGameComponent(IGameComponent view) {
        gameComponents.add(view);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        enableGraphicsSettings(g2);
        paintGameComponents(g2);
        Toolkit.getDefaultToolkit().sync();
    }

    private void enableGraphicsSettings(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void paintGameComponents(Graphics2D g) {
        for (IGameComponent objView : gameComponents) {
            objView.draw(g);
        }
    }
}