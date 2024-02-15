import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class workshopTest {

    Volvo240 car1;
    Saab95   car2;

    workshop<Car> shop1;

    workshop<Volvo240> shop2;

    @Before
    public void init(){
        car1 = new Volvo240();
        car2 = new Saab95();
        shop1 = new workshop<>(5, "");
        shop2 = new workshop<>(5, "");
    }

    @Test
    public void addCar() {
        shop1.addCar(car1);
        Assert.assertFalse(shop1.carlist.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void TestOverCap() {
        Saab95 car3 = new Saab95();
        Saab95 car4 = new Saab95();
        Saab95 car5 = new Saab95();
        Saab95 car6 = new Saab95();
        shop1.addCar(car1);
        shop1.addCar(car2);
        shop1.addCar(car3);
        shop1.addCar(car4);
        shop1.addCar(car5);
        shop1.addCar(car6);
    }

    @Test
    public void releaseCar(){
        shop1.addCar(car1);
        shop1.releaseCar();
        Assert.assertTrue(shop1.carlist.isEmpty());
    }

    /*
    @Test
    public void addCar2(){
        shop2.addCar(car2);
    }

     */

}