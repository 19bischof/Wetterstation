import java.util.ArrayList;
import java.util.List;

public class Model implements Subject{
    private Database myDB;
    private double[] data;
    List <Controller> myController = new ArrayList<>();

    public void addDB(Database myDB){
        this.myDB = myDB;
    }

    public void addCont(Controller myCont) {
        if (this.myController.size() > 1) {
            this.myController.clear();
        }
        this.myController.add(myCont);
    }

    public void sensorHasData() {
        //this is db implementation specific:
        myDB.generateValues();
        //
        
        alertObserver();
        
    }

    public void alertObserver() {
        for (int i = 0; i < myController.size(); i++) {
            myController.get(i).dataOfSubjectChanged();
        }
    }

    private void getData(){
        data = myDB.sendData();
    }

    public double[] sendDataOnRequest() {
        getData();
        return data;}
    
}
