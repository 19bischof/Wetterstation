public class View implements Observer{
    private Controller myController;
    private double[] data;
    private double temperature;
    private double humidity;
    private double co2_percent;
    private double air_pressure;
    private double wind_speed;

    public void addCont(Controller myCont){
        this.myController = myCont;
    }

    public void dataOfSubjectChanged() {
       requestData();
    }

    public void requestData() {
        data = myController.sendDataOnRequest();
        manageData();
        print();
    }
    private void manageData(){
        this.temperature = data[0];
        this.air_pressure = data[1];
        this.humidity= data[2];
        this.co2_percent = data[3];
        this.wind_speed = data[4];
        print();
    }

    public void print() {
        System.out.println("-------------------------------------");
        System.out.println("temperature: " + temperature);
        System.out.println("humidity: " + humidity);
        System.out.println("co2_percent: " + co2_percent);
        System.out.println("air_pressure: " + air_pressure);
        System.out.println("wind_speed: " + wind_speed);
    }
}