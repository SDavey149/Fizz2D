package vector2_tests;

import io.scottd.fizz2d.model.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Vector2AddTests {
    @Test
    public void testAddVector() {
        Vector2 v = new Vector2(1, 1);
        v.add(new Vector2(2, 3));
        Assert.assertTrue(v.x == 3 && v.y == 4);
    }

    @Test
    public void testAddDoubles() {
        Vector2 v = new Vector2(1, 1);
        v.add(2, 3);
        Assert.assertTrue(v.x == 3 && v.y == 4);
    }

    @Test
    public void testAddScaled() {
        Vector2 v = new Vector2(2, 2);
        v.addScaled(new Vector2(1, 1), 3);
        Assert.assertTrue(v.x == 5 && v.y == 5);
    }
}
