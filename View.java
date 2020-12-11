import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import GUI.MainFrame;

public class View implements Observer {
    private Controller myController;
    private double[] data;
    private double temperature;
    private double humidity;
    private double co2_percent;
    private double air_pressure;
    private double wind_speed;
    private JLabel myLabel;
    private MainFrame myFrame;
    private JTable myTable;
    private JScrollPane myPane;

    public View() {
        myFrame = new MainFrame();
        myLabel = new JLabel("output");

    }

    public void addCont(Controller myCont) {
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

    private void manageData() {
        this.temperature = data[0];
        this.air_pressure = data[1];
        this.humidity = data[2];
        this.co2_percent = data[3];
        this.wind_speed = data[4];
        print();
        showTable();
    }

    private void print() {
        System.out.println("-------------------------------------");
        System.out.println("temperature1111: " + temperature);
        System.out.println("humidity: " + humidity);
        System.out.println("co2_percent: " + co2_percent);
        System.out.println("air_pressure: " + air_pressure);
        System.out.println("wind_speed: " + wind_speed);
        // -------------------------------------------------------------------------

    }

    private void initTable() {
        Object[][] theData = { { "temperature", temperature }, { "humidity", humidity }, { "co2_percent", co2_percent },
                { "air_pressure", air_pressure }, { "wind_speed", wind_speed } };

        String[] columnName = { "Sensor", "Station 1" };
        myTable = new JTable(theData, columnName);
        myTable.setFont(new Font("Serif",0,23));
        myTable.setRowHeight(myTable.getRowHeight()+ 20);
        myTable.getColumnModel().getColumn(0).setMaxWidth(1000);
        myTable.getColumnModel().getColumn(0).setMinWidth(180);

        // myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // myTable.getColumnModel().getColumn(0).setPreferredWidth(207);
        myPane = new JScrollPane(myTable);
        // myTable.setBounds(200,100,100,200);
    }

    private void showTable() {
        initTable();
        // myLabel.setText("text");
        // myFrame.add(myLabel);
        myFrame.add(myPane);
        myFrame.setVisible(true);
    }
}