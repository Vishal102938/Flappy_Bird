import javax.swing.JFrame;

public class AppFrame extends JFrame{
    public AppFrame(){
        setTitle("Flappy_Bird");
        setSize(500,650);
        setLocationRelativeTo(null);
        AppPanel aPanel=new AppPanel();
        add(aPanel);
        setResizable(false);
        setVisible(true);
        // aPanel.startGame();
    }
}
