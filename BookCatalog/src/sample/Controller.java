package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Controller {
    private ObservableList<Book> bookData= FXCollections.observableArrayList();
    private FilteredList<Book> filteredData;

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnOpen;
    @FXML
    private Button btnSelect;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfAuthor;
    @FXML
    private TextField tfYear;
    @FXML
    private TableView<Book> tblCatalog;
    @FXML
    private TableColumn<Book,Integer> tbcId;
    @FXML
    private TableColumn<Book,String> tbcTitle;
    @FXML
    private TableColumn<Book,String> tbcAuthor;
    @FXML
    private TableColumn<Book,Integer> tbcYear;
    @FXML
    private CheckBox chBoxFilter;


    @FXML
    private void initialize(){
        tbcId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tbcTitle.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        tbcAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tbcYear.setCellValueFactory(new PropertyValueFactory<Book,Integer>("year"));
        tblCatalog.setItems(bookData);

    }

    @FXML
    public void addClick(){
            bookData.add(new Book(
                    Integer.parseInt(tfId.getText()),
                    tfTitle.getText(),
                    tfAuthor.getText(),
                    Integer.parseInt(tfYear.getText())
            ));

        }
    @FXML
    public void onClickOpen(){
            FileChooser fileChooser=new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON","*.json"));
            File selectedFile=fileChooser.showOpenDialog(new Stage());
            importJSON(selectedFile.getName());
        }

        public void importJSON(String filename){
            JSONParser parser=new JSONParser();
            int id=0;
            try{
                Object obj=parser.parse(new FileReader(filename));
                JSONArray books=(JSONArray)obj;
                Iterator bookIterator=books.iterator();
                while(bookIterator.hasNext()){
                    JSONObject book=(JSONObject)bookIterator.next();
                    String title=book.get("title").toString();
                    String author=book.get("author").toString();
                    int year=Integer.parseInt(book.get("year").toString());
                    bookData.add(new Book(id++,title,author,year));
                }

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    @FXML
    public void onClickSelect(){
        if (!chBoxFilter.isSelected()){
            tblCatalog.setItems(bookData);
            return;
        }

        filteredData=new FilteredList<Book>(bookData,book ->
        {

            if(
                    String.valueOf(book.getId()).contains(tfId.getText())&&
                    String.valueOf(book.getYear()).contains(tfYear.getText())&&
                    book.getTitle().contains(tfTitle.getText())&&
                    book.getAuthor().contains((tfAuthor.getText()))) return true;
            else return false;
        });
        tblCatalog.setItems(filteredData);
        }



}
