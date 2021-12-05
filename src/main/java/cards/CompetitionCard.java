package cards;

import models.Competition;
import pages.CompetitionController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import utils.Navigator;
import java.io.IOException;

public class CompetitionCard {

    private int id = -1;

    private Competition currentCompetition;


    @FXML
    private Label name;

    @FXML
    private Label status;

    @FXML
    private Label teamNum;

    @FXML
    private Label teamSize;

    // TODO: pass a competition object according to the index
    @FXML
    void openDetails(MouseEvent event) throws IOException {

        CompetitionController controller = Navigator.<CompetitionController>next("competition", event);
        controller.fillContent(currentCompetition, controller);

    }

    public void fillContent(Competition competition){
        // populating the card with the content
        String status = competition.isOpen ? "open" : "closed";
        currentCompetition = competition;
        id = competition.index;
        this.name.setText(competition.name);
        this.status.setText(status);
        this.teamNum.setText(Integer.toString(competition.teams.size()));
        this.teamSize.setText(Integer.toString(competition.teamSize));
    }

}
