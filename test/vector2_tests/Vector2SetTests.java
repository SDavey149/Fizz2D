package vector2_tests;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.model.Vector2;

public class Vector2SetTests {
    @Test
    public void setDoublesTest() {
        Vector2 v = new Vector2(1, 1);
        v.set(5,10);
        Assert.assertTrue(v.x == 5);
        Assert.assertTrue(v.y == 10);
    }

    @Test
    public void setVectorTest() {
        Vector2 v = new Vector2(1, 1);
        Vector2 newValue = new Vector2(2, 3);

        v.set(newValue);

        Assert.assertTrue(v.x == newValue.x);
        Assert.assertTrue(v.y == newValue.y);
    }

    @Test
    public void setDoubleSingularTest() {
        Vector2 v = new Vector2(1,2);
        v.set(5);
        Assert.assertTrue(v.x == 5);
        Assert.assertTrue(v.y == 5);
    }
}
