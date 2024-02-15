import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class Main {


    public static void main(String[] args) {

        Application app = new Application();

    }

    public static class Application{

        // member fields:

        // The delay (ms) corresponds to 20 updates a sec (hz)
        static final int delay = 50;
        // The timer is started with a listener (see below) that executes the statements
        // each step between delays.

        // The frame that represents this instance View of the MVC pattern
        private CarView frame;

        private Timer timer = new Timer(delay, new TimerListener());
        // A list of cars, modify if needed

        public static int WINDOW_WIDTH;
        public static int WINDOW_HEIGHT;


        private CarController cc;
        public Application(){
            cc = new CarController();

            cc.cars.add(new Volvo240());
            cc.cars.add(new Saab95());

            // Start a new view and send a reference of self
            frame = new CarView("CarSim 1.0", cc);
            WINDOW_HEIGHT = frame.getHeight() - 240;
            WINDOW_WIDTH = frame.getWidth();
            timer.start();
        }

        // Application update function
        private class TimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.drawPanel.cars = cc.cars;
                cc.moveCars();

                // repaint() // calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }
}
