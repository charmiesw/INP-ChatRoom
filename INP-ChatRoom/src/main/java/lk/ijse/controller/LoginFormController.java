package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private TextField txtUsername;

    @FXML
    private AnchorPane root;

    public static String username;

    @FXML
    void txtUsernameOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        btnLoginOnAction(actionEvent);
    }

    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        if (!txtUsername.getText().equals("")) {
            username = txtUsername.getText();
            navigateToMainForm();
        }
    }

    private void navigateToMainForm() throws SQLException, IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/chatRoom.fxml"));
        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Chat Room");
    }
}
