package GUI;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    public MainFrame(){
        this.setTitle("View");
        int sizex = 940;
        this.setSize(sizex,sizex *9/16);
        this.setLocation((1920 -sizex) /2, (1080 - sizex*9/16) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
