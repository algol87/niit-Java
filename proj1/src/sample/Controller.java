package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Properties;

public class Controller {
    @FXML
    private Button btn1;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private TextField txtDiff;
    @FXML
    private ComboBox cBox;
    @FXML
    private CheckBox check;
    private class Number{
        String name;
        int price;
        Number(String name,int price){
            this.name=name;
            this.price=price;
        }
    }


    @FXML
    public void onMouseMoved(){
        date1.setValue(LocalDate.now());
        date2.setValue(LocalDate.now());
        Number n1=new Number("Люкс",500);
        Number n2=new Number("Люкс2",700);
        //cBox=new ComboBox();
        cBox.getItems().addAll(n1.name,n2.name);
    }

    @FXML
    public void onClick(){



        LocalDate one=date1.getValue();
        LocalDate two=date2.getValue();
        int difYear=(one.getYear()-two.getYear())*365;
        int dif=one.getDayOfYear()-two.getDayOfYear();

        txtDiff.setText(String.valueOf(Math.abs(dif)+Math.abs(difYear)));


    }
}
