package Vector2;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.model.Vector2;

import java.math.BigDecimal;

public class Vector2EqualsTests {
    @Test
    public void TestValidVector2Equals() {
        Vector2 v = new Vector2(2, 3);
        Vector2 v2 = new Vector2(2, 3);
        Assert.assertEquals(v, v2);
    }

    @Test
    public void TestVector2NotEqualToNull() {
        Vector2 v = new Vector2(2, 3);
        Assert.assertFalse(v.equals(null));
    }

    @Test
    public void TestVector2NotEqualToDifferentType() {
        Vector2 v = new Vector2(1, 1);
        Object randomObject = new Object();
        Integer randomInteger = new Integer(5);

        Assert.assertNotEquals(v, randomObject);
        Assert.assertNotEquals(v, randomInteger);
    }
}
