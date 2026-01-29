package gui;

import domein.DomeinController;
import domein.Simon;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.Kleur;

public class KiesSpelKleurenScherm extends VBox {
    private final DomeinController dc;
    private Kleur[] gekozenKleuren;
    private Label lblFeedback;

    public KiesSpelKleurenScherm(DomeinController dc) {
        this.dc = dc;
        gekozenKleuren = new Kleur[Simon.AANTAL_KLEUREN];
        bouwScherm();
    }

    private void bouwScherm() {
        // TODO
    }

    private void startSpel() {
        // TODO
    }

    private void registreerKleur(int kleurIndex, String selectedItem) {
        // TODO
    }
}