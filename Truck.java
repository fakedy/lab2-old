import java.awt.*;

abstract class Truck extends Car{

    private final boolean hasRamp;

    protected Boolean rampOpen;

    public Truck(int nrDoor, double enginePower, Color color, String modelName, boolean hasRamp){
        super(nrDoor, enginePower, color, modelName);
        this.hasRamp = hasRamp;
        this.rampOpen = false;
    }

    @Override
    public void gas(double amount){
        if (amount < 0){
            throw new RuntimeException("no negative amounts!!!");
        }
        else if (rampOpen && hasRamp) {
            throw new RuntimeException("no driving when the platform is raised!");
        }
        else {
            incrementSpeed(Math.min(1, amount));
            currentSpeed = Math.min(enginePower, currentSpeed);
        }
    }

}
