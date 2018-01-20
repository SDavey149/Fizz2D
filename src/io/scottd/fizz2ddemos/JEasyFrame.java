package io.scottd.fizz2ddemos;

import javax.swing.*;
import java.awt.*;

public class JEasyFrame extends JFrame {
    public Component comp;

    public final static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public final static GraphicsDevice device = env.getScreenDevices()[0];
    public static final Rectangle SCREEN = device.getDefaultConfiguration().getBounds();

    public JEasyFrame(JComponent comp, String title) {
        super(title);
        this.comp = comp;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(comp);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}