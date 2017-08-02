package utilities;

import org.jogamp.glg2d.GLG2DCanvas;

import java.awt.*;

import javax.swing.*;

public class JEasyFrame extends JFrame {
    public Component comp;

    public final static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public final static GraphicsDevice device = env.getScreenDevices()[0];
    public static final Rectangle SCREEN = device.getDefaultConfiguration().getBounds();
    public static final double SCREEN_RATIO = SCREEN.width/SCREEN.height;

    public JEasyFrame(JComponent comp, String title) {
        super(title);
        this.comp = comp;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GLG2DCanvas canvas = new GLG2DCanvas(comp);
        this.setContentPane(canvas);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}