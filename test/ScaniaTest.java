import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ScaniaTest {

    Scania car;

    @Before
    public void init(){
        car = new Scania();
    }

    @Test
    //höj rampen med 100 grader (bör inte överstiga 70)
    public void raisePlatformTest() {
        for (int i = 0; i < 100; i++) {
            car.openRamp();
        }
        Assert.assertFalse(car.platformangle > 70);
    }

    @Test
    public void lowerPlatform() {
        car.openRamp();
        car.closeRamp();
        car.closeRamp();
        Assert.assertFalse(car.platformangle < 0);
    }

    //testa gas med platform nere/öppen
    @Test (expected = RuntimeException.class)
    public void gas() {
        car.openRamp();
        car.gas(1);
    }
}