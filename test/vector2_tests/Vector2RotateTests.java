package vector2_tests;

import io.scottd.fizz2d.model.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Vector2RotateTests {
    @Test
    public void rotate90Test() {
        Vector2 v = new Vector2(2, 2);
        v.rotate(Math.PI/2);
        double eps = Math.ulp(2.0);
        Assert.assertTrue(v.x > -2-eps && v.x < -2+eps);
        Assert.assertTrue(v.y > 2-eps && v.y < 2+eps);
    }
}
