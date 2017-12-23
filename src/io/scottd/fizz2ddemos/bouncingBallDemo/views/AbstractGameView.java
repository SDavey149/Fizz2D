package io.scottd.fizz2ddemos.bouncingBallDemo.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottdavey on 11/04/2017.
 */
public abstract class AbstractGameView extends JComponent {
    private List<IGameComponent> gameComponents;

    public AbstractGameView() {
        this.gameComponents = new ArrayList<>(10);
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
