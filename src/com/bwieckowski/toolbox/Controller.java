package com.bwieckowski.toolbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private TextField input1, input2;
    @FXML
    private TextArea args, query, input3, output, php, sql;

    @FXML
    protected void switchScene(ActionEvent event) throws IOException {
        String choice = event.getSource().toString();
        System.out.println(choice);
        Parent scene = null;
        switch(choice){
            case "Button[id=back, styleClass=button]'<-'":
                scene = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                break;
            case "Button[id=phptosql, styleClass=button]'PHP <-> SQL'":
                scene = FXMLLoader.load(getClass().getResource("PhpToSql.fxml"));
                break;
            case "Button[id=argreplace, styleClass=button]'Arg -> SQL'":
                scene = FXMLLoader.load(getClass().getResource("Arg.fxml"));
                break;
            case "Button[id=strreplace, styleClass=button]'StrReplace'":
                scene = FXMLLoader.load(getClass().getResource("StrReplace.fxml"));
                break;
            case "Button[id=ocr, styleClass=button]'IMG -> TXT'":
                scene = FXMLLoader.load(getClass().getResource("ImgToTxt.fxml"));
                break;
            default:
                System.out.println(choice);
        }

        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(new Scene(scene));
        stageTheEventSourceNodeBelongs.centerOnScreen();
    }

    @FXML
    private void strConvert(){
        output.setText(StringReplace.strReplace(input1.getText(), input2.getText(), input3.getText()));
    }

    @FXML
    private void argConvert(){
        output.setText(StringReplace.argReplace(args.getText(), query.getText()));
    }

    @FXML
    private void phpToSqlConvert(){
        sql.setText(StringReplace.strReplace("\\\"", "\"", php.getText()));
    }

    @FXML
    private void sqlToPhpConvert(){
        php.setText(StringReplace.strReplace("\"", "\\\"", sql.getText()));
    }

}
