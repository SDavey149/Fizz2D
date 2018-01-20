package vector2_tests;

import io.scottd.fizz2d.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Vector2ScalarProductTest {
    @Test
    public void testScalarProduct() {
        Vector2 v = new Vector2(1, 1);
        double scalar = v.scalarProduct(new Vector2(1, 1));
        double scalar2 = v.scalarProduct(new Vector2(3, 5));
        Assert.assertTrue(scalar == 2);
        Assert.assertTrue(scalar2 == 8);
    }
}
