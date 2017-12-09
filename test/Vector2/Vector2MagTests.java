package Vector2;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.model.Vector2;

public class Vector2MagTests {
    @Test
    public void TestMagnitudeOfVector2() {
        Vector2 v = new Vector2(3, 4);
        double mag = v.mag();

        Assert.assertTrue(mag == 5);
    }
}
