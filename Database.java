public class Database {
    private double[] data = new double[5];
    public Database(){       
        generateValues();
    }

    public double[] sendData() {
        return data;
    }

    public void generateValues(){
        for (int i = 0;i< 5;i++){
            this.data[i] = Math.random() * 100;
        }
    }
}