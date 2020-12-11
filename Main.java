import java.security.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        View myView = new View();
        Model myModel = new Model();
        Database myDB = new Database();
        Controller myCont = new Controller();
        myModel.addDB(myDB);
        myModel.addCont(myCont);
        myCont.addModel(myModel);
        myCont.addView(myView);
        myView.addCont(myCont);
        myModel.sensorHasData();
        Timer simulateRL = new Timer();
        TimerforDB myTimerTask = new TimerforDB(myModel);
        simulateRL.schedule(myTimerTask,0,5000);

    }
}
