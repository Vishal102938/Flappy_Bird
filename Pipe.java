import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Pipe {
    private int x;        
    private int width, theight,bheight,gap; 
    Image bufferImage;
    private Random r;

    public Pipe(int star) {
        width=Integer.parseInt(ResourceBundleData.getBundleData("PIPE_WIDTH"));
        gap=Integer.parseInt(ResourceBundleData.getBundleData("PIPE_GAP"));
        
        r = new Random();
        // width = 50; 
        // gap=170;
        x = star;
        Prandom();
        ImagePipe();
    }

    public void ImagePipe(){
        try {
            bufferImage=ImageIO.read(new File("pipe.jpg"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void move() {
        x -= 5; 
        if (x < -width) { 
            x = 500; 
            Prandom();
        }
    }

    private void Prandom(){
        theight=r.nextInt(200)+100;
        bheight=650-(theight+gap);
    }
    public void draw(Graphics g){
        if(bufferImage != null){
            g.drawImage(bufferImage, x, 0, width,theight,null);
            g.drawImage(bufferImage, x, theight+gap, width,bheight,null);

        }
    }

    public boolean collision(Bird bird) {

        if (bird.x + bird.width > x && bird.x < x + width) { 
            if (bird.y < theight || bird.y + bird.height > theight + gap) { 
                return true; 
            }
        }
        return false;
    }
    

    // public void draw(Graphics g) {
    //     g.setColor(Color.GREEN); 
        
    //     g.fillRect(x, 0, width, height); 
        
    //     g.fillRect(x, height + 150, width, 600 - (height + 150)); 
    // }
}