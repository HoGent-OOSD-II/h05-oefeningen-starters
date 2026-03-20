package gui;

import domein.DomeinController;
import javafx.scene.control.Alert;

public class ToevoegController {
    private DomeinController dc;
    private OverzichtsScherm overzichtsScherm;

    public ToevoegController(DomeinController dc, OverzichtsScherm overzichtsScherm) {
        this.dc = dc;
        this.overzichtsScherm = overzichtsScherm;
    }

    private void toonFoutmelding(String melding) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Container kan niet toegevoegd worden");
        alert.setContentText(melding);
        alert.showAndWait();
    }
}