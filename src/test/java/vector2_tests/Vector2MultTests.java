package vector2_tests;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.Vector2;

public class Vector2MultTests {
    @Test
    public void testMultVector() {
        Vector2 v = new Vector2(2, 5);
        v.mult(3);
        Assert.assertTrue(v.x == 6 && v.y == 15);
    }
}
