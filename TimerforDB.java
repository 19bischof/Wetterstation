import java.util.TimerTask;

public class TimerforDB extends TimerTask {
    Model myModel;

    public TimerforDB(Model myModel) {
        this.myModel = myModel;
    }
    public void run(){
        myModel.sensorHasData();
        
    }
}
