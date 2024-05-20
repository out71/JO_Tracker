package com.jotracker.jo_tracker.Views;

import com.jotracker.jo_tracker.Controllers.AthleteCellController;
import com.jotracker.jo_tracker.Models.Athlete;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class AthleteCellFactory extends ListCell<Athlete> {
    @Override
    protected void updateItem(Athlete athlete, boolean empty) {
        super.updateItem(athlete, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml/AthleteCell.fxml"));
            AthleteCellController controller = new AthleteCellController(athlete);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
