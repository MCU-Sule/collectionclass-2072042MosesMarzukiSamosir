package com.example.collectionclass2072042mosesmarzukisamosir;

import com.example.collectionclass2072042mosesmarzukisamosir.model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    public TableColumn column1;
    public TableColumn column2;
    public TextField txtNRP;
    public TextField txtNama;
    public TableView tableView;
    public TextField txtNRPdelete;

    private ObservableList<Mahasiswa> oList;

    public void initialize(){
        oList = FXCollections.observableArrayList(
                new Mahasiswa("2072042", "moses")
        );
        tableView.setItems(oList);
        column1.setText("NRP");
        column1.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        column2.setText("Nama");
        column2.setCellValueFactory(new PropertyValueFactory<>("nama"));

    }
    public void onAdd(ActionEvent event) {
        Mahasiswa mahasiswa = new Mahasiswa(txtNRP.getText(),txtNama.getText());
        tableView.getItems().add(mahasiswa);
    }

    public void onDelete(ActionEvent event) {
        String delNrp = txtNRPdelete.getText();
        for(int i=0; i < oList.size();i++){
            String a = String.valueOf(oList.get(i));
//            System.out.println(a);
//            System.out.println("INI" + delNrp);
            if (delNrp.equals(a)){
                tableView.getItems().remove(i);
            }
        }
    }
}