import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, 125, Color.red, "Saab95", "pics/Saab95.jpg");
        super.setPosition(new Point2D.Double(0,100));
	    turboOn = false;
    }

    public boolean getTurbo(){
        return turboOn;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }


}
