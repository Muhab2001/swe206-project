package pages;

import cards.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.StageStyle;
import models.Competition;
import models.Team;
import utils.Navigator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CompetitionController {

    @FXML
    public void initialize() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse("12/1/2021", formatter);

        dateLabel.setText("12/1/2021");
        if(LocalDate.now().compareTo(date) > 0){

            Navigator.<DueDialog>nextDialog("due", "This competition is due!");
            statusIndicator.setFill(Color.RED);
            statusLabel.setText("Closed");
        }else {
            statusIndicator.setFill(Color.GREENYELLOW);
            statusLabel.setText("Open");
        }
    }

    private Competition currentCompetition;

    @FXML
    private Circle statusIndicator;

    @FXML
    private Button addTeamBtn;

    @FXML
    private Label competitionName;

    @FXML
    private Label dateLabel;

    @FXML
    private Button editDetailsBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private Label sizeLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label teamNumLAbel;

    @FXML
    private Button visitWebsiteBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private ScrollPane teamsContainer;

    @FXML
    private Button announceRanking;

    @FXML
    void announceRanks(ActionEvent event) throws IOException {
        RankingDialog controller = Navigator.<RankingDialog>nextDialog("ranking", "Add a New Team");
        controller.fillContent();
    }

    @FXML
    void editDetails(ActionEvent event) throws IOException {
        CompetitionDialog dialogController = Navigator.<CompetitionDialog>nextDialog("competition",
                "Edit a Competition");
        dialogController.fillContent();

    }

    @FXML
    void navigateBack(ActionEvent event) throws IOException {
        Navigator.<MainController>next("main", event);
    }

    @FXML
    void addTeam(ActionEvent event) throws IOException {
        TeamDialog controller = Navigator.<TeamDialog>nextDialog("team", "Add a Team");
        controller.setHeader("Add a Team");

    }

    // TODO: Perform a proper dynamic routing using fetched websites, this is just a
    // test
    @FXML
    void visitWebsite(ActionEvent event) throws IOException {
        WebsiteController controller = Navigator.<WebsiteController>next("website", event);
        controller.showWebsite("https://www.google.com");
    }

    // TODO: Perform a proper deletion , this is just a test
    @FXML
    void delete(ActionEvent event) throws IOException {
        // implement the deletion process before navigating
        Navigator.<MainController>next("../main", event);

    }

    // TODO: replace with dynamic population
    public void fillContent() throws IOException {

        VBox vbox = new VBox(8);
        for (int i = 0; i < 10; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../team-card.fxml"));
            vbox.getChildren().add((Node) fxmlLoader.load());
            TeamCard controller = fxmlLoader.getController();
            controller.setContent();
        }

        teamsContainer.setContent(vbox);

    }

}
