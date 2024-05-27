package com.jotracker.jo_tracker.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sport {
    private final IntegerProperty id;
    private final StringProperty name;

    public Sport(Integer id, String name) {
        this.id = new SimpleIntegerProperty(this, "id", id);
        this.name = new SimpleStringProperty(this, "name", name);
    }

    public StringProperty getName() {
       return this.name;
    }
}
