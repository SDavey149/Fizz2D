package vector2_tests;

import io.scottd.fizz2d.model.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Vector2DistanceTests {
    @Test
    public void TestDistance() {
        Vector2 a = new Vector2(2, 3);
        Vector2 b = new Vector2(5, 7);
        double eps = Math.ulp(5.0);
        double ba = b.distance(a);
        double ab = a.distance(b);
        Assert.assertTrue(ba > 5-eps && ba < 5+eps);
        Assert.assertTrue(ab > 5-eps && ab < 5+eps);
    }
}
