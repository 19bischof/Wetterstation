import java.util.ArrayList;
import java.util.List;

public class Controller  implements Observer,Subject {
    private List <View> myObserver = new ArrayList<>();
    private Model myModel;
    private double[] data;
    public void addView(View view){
        myObserver.add(view);
    }
    public void addModel(Model myModel){
        this.myModel = myModel; 
    }


    public void alertObserver() {
        for (View view : myObserver) {
            view.dataOfSubjectChanged();
        }
    }

    public void requestData() {
        data =  myModel.sendDataOnRequest();
    }
    public void dataOfSubjectChanged() {
        alertObserver();
    }

    public double[] sendDataOnRequest() {
        requestData();
        return data;}
}
