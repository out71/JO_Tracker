package com.jotracker.jo_tracker.Controllers;

import com.calendarfx.view.page.DayPage;
import com.jotracker.jo_tracker.Models.Medaille;
import com.jotracker.jo_tracker.Models.Model;
import com.jotracker.jo_tracker.Views.MedaillesCellFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DashboardController implements Initializable {
    public Button country_btn;
    public Button athlete_btn;
    public ListView<Medaille> medals_listview;
    public DayPage daypage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        daypage.getCalendarSources().addAll(Model.getInstance().getCalendarSource());
        country_btn.setOnAction(event -> onCountries());
        athlete_btn.setOnAction(event -> onAthletes());
        Model.getInstance().getViewFactory().getDashboardMedalsListViewState().addListener((observableValue, oldVal, newVal) -> {
            if (newVal.equals("byCountries")) {
                initMedalsByCountriesListView();
                medals_listview.setItems(Model.getInstance().getTopMedaillesByCountries());
            } else {
                initMedalsByAthletesListView();
                medals_listview.setItems(Model.getInstance().getTopMedaillesByAthletes());
            }
        });
        medals_listview.setCellFactory(e -> new MedaillesCellFactory());
    }

    private void initMedalsByCountriesListView() {
        if (Model.getInstance().getTopMedaillesByCountries().isEmpty()) {
            Model.getInstance().setTopMedaillesByCountries();
        }
    }

    private void initMedalsByAthletesListView() {
        if (Model.getInstance().getTopMedaillesByAthletes().isEmpty()) {
            Model.getInstance().setTopMedaillesByAthletes();
        }
    }

    public void onCountries() {
        Model.getInstance().getViewFactory().getDashboardMedalsListViewState().set("byCountries");
    }

    public void onAthletes() {
        Model.getInstance().getViewFactory().getDashboardMedalsListViewState().set("byAthletes");
    }
}
