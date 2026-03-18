package gui;

import domein.DomeinController;
import domein.Simon;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.Kleur;

import java.util.Arrays;
import java.util.List;

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
        this.setPadding(new Insets(20));
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        Label lblKiesKleuren = new Label(String.format("Kies de %d kleuren", Simon.AANTAL_KLEUREN));
        lblKiesKleuren.setFont(Font.font("Montserrat", FontWeight.NORMAL, 20));
        this.getChildren().add(lblKiesKleuren);

        List<Kleur> kleuren = Arrays.asList(Kleur.values());
        for (int i = 0; i < Simon.AANTAL_KLEUREN; i++) {
            final int kleurIndex = i;
            ComboBox<Kleur> cmbKleuren = new ComboBox<>(FXCollections.observableList(kleuren));
            cmbKleuren.setPromptText(String.format("Kies kleur %d", i + 1));
            this.getChildren().add(cmbKleuren);
            cmbKleuren
                    .setOnAction(evt -> registreerKleur(kleurIndex, cmbKleuren.getSelectionModel().getSelectedItem()));

        }

        // TODO
    }

    private void startSpel() {
        // TODO
    }

    private void registreerKleur(int kleurIndex, Kleur geselecteerdeKleur) {
        lblFeedback.setText("");
        gekozenKleuren[kleurIndex] = geselecteerdeKleur;
    }
}