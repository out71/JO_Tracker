package com.jotracker.jo_tracker.Controllers;

import com.jotracker.jo_tracker.Models.Athlete;
import com.jotracker.jo_tracker.Models.Model;
import com.jotracker.jo_tracker.Models.Sport;
import com.jotracker.jo_tracker.Views.AthleteCellFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

public class DisciplinesController implements Initializable {
    public ListView<Athlete> sports_listview;
    public ChoiceBox<String> sport_choicebox;
    public Button add_sport_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_sport_button.setOnAction(event -> onAdd());
        initSportChoiceBox();
        initAthletesBySportListView();
        sports_listview.setItems(Model.getInstance().getAthletesBySport());
        sports_listview.setCellFactory(e -> new AthleteCellFactory());
    }

    private void initSportChoiceBox() {
        Model.getInstance().setSportsList();
        List<String> sportsName = new ArrayList<>();
        for (Sport sport : Model.getInstance().getSportsList()) {
            sportsName.add(sport.getName().getValue());
        }
        sport_choicebox.getItems().addAll(sportsName);
        sport_choicebox.setOnAction(this::refreshList);
    }

    private void initAthletesBySportListView() {
        try {
            Model.getInstance().setAthletesBySport(Model.getInstance().getDatabaseDriver().getSportId(sport_choicebox.getValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshList(ActionEvent event) {
        initAthletesBySportListView();
    }

    private void onAdd() {
        Model.getInstance().getViewFactory().showAddSportWindow();
    }
}
