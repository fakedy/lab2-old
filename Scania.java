import java.awt.*;

public class Scania extends Truck{


    protected int platformangle;


    public Scania(){
        super(2, 100, Color.black, "Scania truck", true);
        this.platformangle = 0;
    }

    public void openRamp(){
        if (currentSpeed > 0){
            throw new RuntimeException("truck must be still before raising platform!");
        }
        else {
            rampOpen = true;
            platformangle = Math.min(70, platformangle + 1);
        }
    }

    public void closeRamp(){
        if (platformangle > 0){
            platformangle = Math.max(0, platformangle - 1);
            if (platformangle == 0){
                rampOpen = false;
            }
        }
    }
}
