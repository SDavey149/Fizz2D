package bouncingBallDemo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scottdavey on 11/04/2017.
 */
public class BouncingBallView extends JComponent {
    private int resolutionX, resolutionY;

    public BouncingBallView(BouncingBallWorld world, int resolutionX, int resolutionY) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        enableGraphicsSettings(graphics);
    }

    private void enableGraphicsSettings(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void paintBackground(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, resolutionX, resolutionY);
    }
}
