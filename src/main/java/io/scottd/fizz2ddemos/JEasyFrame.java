package io.scottd.fizz2ddemos;

import javax.swing.*;
import java.awt.*;

public class JEasyFrame extends JFrame {
    private static final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static final GraphicsDevice device = env.getScreenDevices()[0];
    public static final Rectangle SCREEN = device.getDefaultConfiguration().getBounds();

    public JEasyFrame(JComponent comp, String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(comp);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}