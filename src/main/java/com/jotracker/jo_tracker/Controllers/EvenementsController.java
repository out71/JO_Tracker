package com.jotracker.jo_tracker.Controllers;

import com.calendarfx.view.CalendarView;
import com.jotracker.jo_tracker.Models.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EvenementsController implements Initializable {
    public CalendarView calendarView;
    public Button add_event;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_event.setOnAction(event -> onAdd());
        initCalendarView();
    }

    private void initCalendarView() {
        Model.getInstance().setCalendar();
        calendarView.getCalendarSources().addAll(Model.getInstance().getCalendarSource());
    }

    private void onAdd() {
        Model.getInstance().getViewFactory().showAddEventWindow();
    }
}
