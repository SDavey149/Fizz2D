package vector2_tests;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.Vector2;

public class Vector2EqualsTests {
    @Test
    public void testValidVector2Equals() {
        Vector2 v = new Vector2(2, 3);
        Vector2 v2 = new Vector2(2, 3);
        Assert.assertEquals(v, v2);
    }

    @Test
    public void testVector2NotEqualToNull() {
        Vector2 v = new Vector2(2, 3);
        Assert.assertFalse(v.equals(null));
    }

    @Test
    public void testVector2NotEqualToDifferentType() {
        Vector2 v = new Vector2(1, 1);
        Object randomObject = new Object();
        Integer randomInteger = new Integer(5);

        Assert.assertNotEquals(v, randomObject);
        Assert.assertNotEquals(v, randomInteger);
    }
}
