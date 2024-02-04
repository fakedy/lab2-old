import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Volvo240Test {

    Volvo240 car;

    @Before
    public void init(){
        car = new Volvo240();
    }

    @Test
    public void testSpeedFactor() {
        Assert.assertEquals(1.25, car.speedFactor(), 1e-15);
    }

    @Test
    public void testIncrementSpeed() {
        car.incrementSpeed(1);
        Assert.assertTrue(car.getCurrentSpeed() > 0.1);
    }

    @Test
    public void testDecrementSpeed() {
        car.startEngine();
        car.decrementSpeed(1);
        Assert.assertTrue(car.getCurrentSpeed() < 0.1);
    }
}