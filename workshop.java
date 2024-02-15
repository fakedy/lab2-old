import java.awt.geom.Point2D;
import java.util.ArrayList;
public class workshop <T> implements HasPosition {


    private GraphicsComponent<workshop> graphicsComponent;

    protected ArrayList<T> carlist;
    private final int size;



    protected Point2D.Double position;

    public workshop(int size, String graphics){
        carlist = new ArrayList<>();
        this.size = size;
        this.graphicsComponent = new GraphicsComponent(this, graphics);
    }

    public void addCar(T a){
        if(carlist.size() < size){
            carlist.add(a);
        }
        else throw new RuntimeException("over capacity");
    }
    public T  releaseCar(){
        return carlist.removeLast();
    }

    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

}
