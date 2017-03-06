package views;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private ChoiceBox machine_sel;
    @FXML
    private Label error_text;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passWord;

    private ObservableList<String> mach = FXCollections.observableArrayList("\t\t192.168.1.2\t\t","\t\t192.168.1.8\t\t");

    @FXML
    public void initialize(){
        machine_sel.setItems(mach);
    }

    @FXML
    public void handle_login(ActionEvent event){
        String uN = userName.getText();
        String pW = passWord.getText();
        if (uN.equals("zeref") && (pW.equals("Acnologia12"))){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                Parent root = fxmlLoader.load(getClass().getResource("../views/main.fxml"));
                Stage st = new Stage();
                st.initModality(Modality.APPLICATION_MODAL);
                st.setTitle("AutoTest");
                st.setScene(new Scene(root, 800, 600));
                st.setMinHeight(600);
                st.setMinWidth(800);
                st.show();
                ((Node) event.getSource()).getScene().getWindow().hide();
            }
            catch (IOException e) { e.printStackTrace(); }
        }
        else{
            error_text.setText("Invalid User Name / Password");
            passWord.setText("");
        }
    }

    @FXML
    public void handle_cancel(ActionEvent event){
        Platform.exit();
    }

}
