import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel implements ActionListener {
    int x=0;
    int y=0;
    int w;
    int h;
    Timer timer; 
    BufferedImage bufferImage;
    Bird bird;   
    private final ArrayList<Pipe> pipes;   
    public AppPanel() {
        h=Integer.parseInt(ResourceBundleData.getBundleData("BG_HEIGHT"));
        w=Integer.parseInt(ResourceBundleData.getBundleData("BG_WIDTH"));
        bird = new Bird();
        pipes = new ArrayList<>();
        for(int i=0;i<2;i++){
            pipes.add(new Pipe(400+i*300));
        }

        timer = new Timer(30, this);
        printBackgrond();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bird.fly(); 
                }
            }
        });
        timer.start();
    }

    // public void startGame() {
    //     timer.start();
    // }
    
    
    void printBackgrond(){
        try {
            bufferImage=ImageIO.read(AppPanel.class.getResource("bg.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        // g.drawImage(bufferImage,x,y, 500, 750, null);
        g.drawImage(bufferImage,x,y, w,h , null);
       
        bird.draw(g); 
        for(Pipe pipe: pipes){
            pipe.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.move(); 
        for(Pipe pipe : pipes){
            pipe.move(); 

            if (pipe.collision(bird)) 
            { 
                timer.stop(); 
                return;
            }
        }
        repaint();   
    }
}