package com.jotracker.jo_tracker.Controllers;

import com.jotracker.jo_tracker.Models.Medailles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MedaillesCellController implements Initializable {
    public ImageView flag_img;
    public Label name_lbl;
    public Label golden_lbl;
    public ImageView golden_imgView;
    public Label silver_lbl;
    public ImageView silver_imgView;
    public Label bronze_lbl;
    public ImageView bronze_imgView;
    public Label all_medals_lbl;
    public ImageView all_medals_imgView;

    private final Medailles medailles;

    public MedaillesCellController(Medailles medailles) {
        this.medailles = medailles;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
