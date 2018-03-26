package com.bwieckowski.toolbox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class COCR extends Controller implements Initializable{

    private OCR ocr;

    @FXML
    protected TextField dirfield, filefield;
    @FXML
    private TextArea output;
    @FXML
    private ChoiceBox languages;
    @FXML
    private Hyperlink languageslink;

    public COCR() {
        this.ocr = new OCR();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dirfield.setText(new File("").getAbsolutePath());
    }

    @FXML
    private void chooseDir(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Image File");
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        File file = directoryChooser.showDialog(stage);
        if(file != null){
            dirfield.setText(file.getAbsolutePath());
        }
        updateMenu(file);
    }

    private void updateMenu(File dir){
        File[] sdDirectories = dir.listFiles();
        ObservableList<String> list = FXCollections.observableArrayList();
        for (File file : sdDirectories){
            String str = file.getName();
            if(str.contains(".traineddata")){
                list.add(str.replace(".traineddata", ""));
            }
        }
        languages.setItems(list);
        languages.getSelectionModel().selectFirst();
    }

    @FXML
    private void chooseFile(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
            filefield.setText(file.getAbsolutePath());
        }
    }

    @FXML
    private void doOCR() {
        try {
            output.setText(ocr.doOCR(filefield.getText(), dirfield.getText()));
        } catch (TesseractException e) {
            output.setText(e.getMessage());
        }
    }
}
