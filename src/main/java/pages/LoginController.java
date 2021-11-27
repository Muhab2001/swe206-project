package pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField usernameInput;

    @FXML
    void login(ActionEvent event) throws IOException {
        //TODO: authenticating the credentials
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../main.fxml")); // get the fxml file
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow(); // get the current stage
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        MainController controller = fxmlLoader.getController();
        controller.fillContent("realName", "s201945570@kfpupm.edu.sa");
        stage.setScene(scene);
        stage.show();
    }

    private void authenticate(String username, String password){
        // we will use a txt file to store credentials for our users
    }

}
