package com.jotracker.jo_tracker.Views;

import com.jotracker.jo_tracker.Controllers.MedaillesCellController;
import com.jotracker.jo_tracker.Models.Medaille;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class MedaillesCellFactory extends ListCell<Medaille> {
    @Override
    protected void updateItem(Medaille medailles, boolean empty) {
        super.updateItem(medailles, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MedaillesCell.fxml"));
            MedaillesCellController controller = new MedaillesCellController(medailles);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
