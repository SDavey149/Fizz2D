package vector2_tests;

import org.junit.Assert;
import org.junit.Test;
import io.scottd.fizz2d.Vector2;

public class Vector2AngleTests {
    @Test
    public void testAngleOfVectorToAxis() {
        Vector2 v = new Vector2(1, 1);
        double angle = v.angle();

        Assert.assertTrue(angle == 45 * Math.PI / 180);
    }

    @Test
    public void testAngleIs0Between2Vectors() {
        Vector2 v = new Vector2(1, 1);
        Vector2 v2 = new Vector2(3, 3);
        Assert.assertTrue(v.angle() == v2.angle());
        Assert.assertTrue(v.angle(v2) == 0);
    }

    @Test
    public void testOppositeVectorAngle() {
        Vector2 v = new Vector2(1, 1);
        Vector2 v2 = new Vector2(-1, -1);
        Assert.assertTrue(v.angle(v2) == Math.PI);
    }
}
