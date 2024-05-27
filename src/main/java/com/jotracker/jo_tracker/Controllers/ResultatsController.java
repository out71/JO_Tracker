package com.jotracker.jo_tracker.Controllers;

import com.jotracker.jo_tracker.Models.Medaille;
import com.jotracker.jo_tracker.Models.Model;
import com.jotracker.jo_tracker.Views.MedaillesCellFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ResultatsController implements Initializable {
    public ListView<Medaille> results_listview;
    public Button add_medal_button;
    public Button country_btn;
    public Button athlete_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_medal_button.setOnAction(event -> onAdd());
        country_btn.setOnAction(event -> onCountries());
        athlete_btn.setOnAction(event -> onAthletes());
        Model.getInstance().getViewFactory().getResultsMedalsListViewState().addListener((observableValue, oldVal, newVal) -> {
            if (newVal.equals("byCountries")) {
                Model.getInstance().setAllMedaillesByCountries();
                results_listview.setItems(Model.getInstance().getAllMedaillesByCountries());
            } else {
                Model.getInstance().setAllMedaillesByAthletes();
                results_listview.setItems(Model.getInstance().getAllMedaillesByAthletes());
            }
        });
        results_listview.setCellFactory(e -> new MedaillesCellFactory());
    }


    public void onCountries() {
        Model.getInstance().getViewFactory().getResultsMedalsListViewState().set("byCountries");
    }

    public void onAthletes() {
        Model.getInstance().getViewFactory().getResultsMedalsListViewState().set("byAthletes");
    }

    private void onAdd() {
        Model.getInstance().getViewFactory().showAddMedalWindow();
    }
}
