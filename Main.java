import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

import GUI.*;


public class Main {
    public static void main(String[] args) {
        View myView = new View();
        Model myModel = new Model();
        Database myDB = new Database();
        Controller myCont = new Controller();
        Timer simulateRL = new Timer();
        TimerforDB myTimerTask = new TimerforDB(myModel);

        myModel.addDB(myDB);
        myModel.addCont(myCont);
        myCont.addModel(myModel);
        myCont.addView(myView);
        myView.addCont(myCont);
        // myModel.sensorHasData();

        simulateRL.schedule(myTimerTask,1000,1000);


        

    }
}
