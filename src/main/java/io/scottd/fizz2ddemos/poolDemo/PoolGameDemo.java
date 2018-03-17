package io.scottd.fizz2ddemos.poolDemo;

import io.scottd.fizz2d.world.WorldConfiguration;
import io.scottd.fizz2ddemos.AbstractGameDemo;
import io.scottd.fizz2ddemos.JEasyFrame;

public class PoolGameDemo extends AbstractGameDemo {
    public static void main(String[] args) {
        PoolGameDemo demo = new PoolGameDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Pool Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    @Override
    protected WorldConfiguration createWorldConfiguration() {
        return null;
    }

    @Override
    protected void setupGame() {

    }
}