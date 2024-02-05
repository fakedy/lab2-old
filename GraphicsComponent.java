import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GraphicsComponent {


    Car owner;

    BufferedImage graphics;

    Point position = new Point(0,0);

    GraphicsComponent(Car owner, String graphics){
        this.owner = owner;
        this.graphics = bufferImage(graphics);
    }


    BufferedImage bufferImage(String path){
        BufferedImage image = null;

        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return image;
    }


    void draw(Graphics g){
        g.drawImage(graphics, (int)owner.getPosition().x, (int)owner.getPosition().y, null); // see javadoc for more info on the parameters

    }

    void setPosition(Point position){
        this.position = position;
    }



}
