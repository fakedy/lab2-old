import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Deque;
import java.util.ArrayDeque;

public class transport extends Truck{

    Deque<Car> carStack;

    public transport(){
        super(2, 90, Color.green, "car transporter", true);
        carStack = new ArrayDeque<>();
        rampOpen = false;
    }

    public void openRamp(){
        if (currentSpeed > 0){
            throw new RuntimeException("transporter must be still before lowering ramp");
        }
        else this.rampOpen = true;
    }

    public void closeRamp(){
        this.rampOpen = false;
    }

    public void loadCar(Car a){
        if (rampOpen && a.position.distance(this.position) <= 5){
            carStack.push(a);
            a.position = this.position;
        }
    }

    public Car unloadCar(){
        if (!rampOpen || carStack.isEmpty()){
            throw new RuntimeException("transport is either empty or ramp is closed!!!");
        }
        Car car = carStack.pop();
        car.position = new Point2D.Double(this.position.x, this.position.y);
        return car;
    }

    @Override
    public void move() {
        if (direction == 1){
            this.position.y += currentSpeed;
        }
        if (direction == 3){
            this.position.y -= currentSpeed;
        }
        if (direction == 2){
            this.position.x += currentSpeed;
        }
        if (direction == 4){
            this.position.x -= currentSpeed;
        }


    }


}
