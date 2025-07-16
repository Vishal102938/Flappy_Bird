import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bird {
    BufferedImage bufferImage;
    int x, y;  
    int width, height; 
    int velocity;      

    public Bird() {
        height=Integer.parseInt(ResourceBundleData.getBundleData("BIRD_HEIGHT"));
        width=Integer.parseInt(ResourceBundleData.getBundleData("BIRD_WIDTH"));
        x=Integer.parseInt(ResourceBundleData.getBundleData("X_POS"));
        y=Integer.parseInt(ResourceBundleData.getBundleData("Y_POS"));
        velocity=Integer.parseInt(ResourceBundleData.getBundleData("BIRD_SPEED"));
        // x = 50;       
        // y = 250;      
        // width = 50;   
        // height = 50;  
        // velocity = 0; 
        birdImg();
    }

    public void fly() {
        velocity = -10; 
    }

    public void move() {
        velocity += 1; 
        y += velocity;
            if (y > 650-height) { 
            y = 650-height;
        }
    }

    void birdImg(){
        try {
            bufferImage=ImageIO.read(AppPanel.class.getResource("bird.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }    
    public void draw(Graphics g) {
        g.drawImage(bufferImage, x, y,width,height, null);
    }
}