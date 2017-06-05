package bouncingBallDemo;

import bouncingBallDemo.views.IGameObjectView;
import fizz2d.world.World;
import utilities.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottdavey on 11/04/2017.
 */
public class BouncingBallView extends JComponent {
    private int resolutionX, resolutionY;
    Vector2D scale;
    private List<IGameObjectView> renders;

    public BouncingBallView(int resolutionX, int resolutionY, Vector2D scale) {
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        this.scale = scale;
        this.renders = new ArrayList<IGameObjectView>(50);
    }

    public void AddGameObject(IGameObjectView view) {
        renders.add(view);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //BufferedImage bufferImage = new BufferedImage(resolutionX,resolutionY,BufferedImage.TYPE_INT_RGB);
        //Graphics2D g2 = (Graphics2D)bufferImage.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        enableGraphicsSettings(g2);
        paintBackground(g2);
        paintGameObjects(g2);
        //g.drawImage(bufferImage, 0, 0, null);
    }

    private void enableGraphicsSettings(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void paintBackground(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, resolutionX, resolutionY);
    }

    private void paintGameObjects(Graphics2D g) {
        for (IGameObjectView objView : renders) {
            objView.draw(g);
        }
    }
}
