package vector2_tests;

import io.scottd.fizz2d.model.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Vector2CreationTests {
    @Test
    public void testVector2CreatedFromDoubles() {
        Vector2 v = new Vector2(1,2);
        Assert.assertNotNull(v);
        Assert.assertTrue(v.x == 1);
        Assert.assertTrue(v.y == 2);
    }

    @Test
    public void testVector2CreatedFromExistingVector() {
        Vector2 v = new Vector2(2.3, 3.5);
        Vector2 newVector = new Vector2(v);
        Assert.assertNotNull(newVector);
        Assert.assertTrue(newVector.x == v.x);
        Assert.assertTrue(newVector.y == v.y);
    }
}
