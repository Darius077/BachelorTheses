package gui;


import domain.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import service.Service;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;


public class Controller {

    private Service serv;
    ObservableList<Student> studentsList;
    ObservableList<String> stringList;

    @FXML
    private ListView<Student> studentsListView;



    // Exercise 1
    public void initialize() {
        List<Student> students = serv.viewAll();
        studentsList = FXCollections.observableList(students);
        studentsListView.setItems(FXCollections.observableList(studentsList));

    }

    // Exercise 2

    @FXML
    private TextField searchTextField;
    @FXML
    private Button buttonCheck;

    @FXML
    void checkHandler(ActionEvent event) {

        List<Student> filteredStudents = serv.searchStudents();
        studentsList = FXCollections.observableList(filteredStudents);
        studentsListView.setItems(FXCollections.observableList(studentsList));
    }


    // Exercise 3
    @FXML
    private Button buttonUpdate;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField percentageTextField;

    @FXML
    void updateHandler(ActionEvent event) {
        String title = titleTextField.getText();
        String percentage = percentageTextField.getText();
        Student student = studentsListView.getSelectionModel().getSelectedItem();
        serv.updateRecipe(title, percentage, student);
    }



    public Controller(Service serv) {
        this.serv = serv;

    }

    public Controller() {
        // Optionally initialize the Service here or use a setter method
    }


}
