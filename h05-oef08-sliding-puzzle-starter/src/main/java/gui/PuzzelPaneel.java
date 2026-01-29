package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class PuzzelPaneel extends GridPane {
    private static final int AFBEELDINGSGROOTTE = 99;
    private DomeinController dc;
    private SpelScherm mijnContainer;
    private Label lblClicks;

    public PuzzelPaneel(DomeinController dc, SpelScherm container) {
        this.dc = dc;
        this.mijnContainer = container;
        bouwScherm();
    }

    private void bouwScherm() {
        setAlignment(Pos.CENTER);
        ColumnConstraints colConstraint = new ColumnConstraints(AFBEELDINGSGROOTTE + 1);
        RowConstraints rowConstraint = new RowConstraints(AFBEELDINGSGROOTTE + 1);
        for (int i = 0; i < dc.geefDimensie(); i++)
            getRowConstraints().add(rowConstraint);
        for (int j = 0; j < dc.geefDimensie(); j++)
            getColumnConstraints().add(colConstraint);
        toonPuzzel();
        toonAantalClicks();
    }

    private void toonAantalClicks() {
        // TODO
    }

    private void toonPuzzel() {
        String[][] puzzelstukken = dc.geefPuzzel();
        for (int rij = 0; rij < puzzelstukken.length; rij++)
            for (int kolom = 0; kolom < puzzelstukken[rij].length; kolom++) {
                String image = puzzelstukken[kolom][rij] != null
                        ? String.format("/images/%s/size%s/%s", dc.geefThema().name().toLowerCase(),
                        dc.geefAantalStukken(), puzzelstukken[kolom][rij])
                        : "/images/emptyspace.jpg";
                ImageView ivCard = new ImageView(new Image(getClass().getResourceAsStream(image)));
                ivCard.setFitWidth(AFBEELDINGSGROOTTE);
                ivCard.setCursor(Cursor.HAND);
                ivCard.setPreserveRatio(true);
                setHalignment(ivCard, HPos.CENTER);
                setValignment(ivCard, VPos.CENTER);
                add(ivCard, kolom, rij);
                final int fKolom = kolom, fRij = rij;
                ivCard.setOnMouseClicked(evt -> {
                    dc.verschuifPuzzelstuk(fKolom, fRij);
                    updatePuzzel();
                });
            }
    }

    private void updatePuzzel() {
        String[][] puzzelstukken = dc.geefPuzzel();
        for (Node node : getChildren()) {
            int rij = getRowIndex(node);
            int kolom = getColumnIndex(node);
            String image = puzzelstukken[kolom][rij] != null ? String.format("/images/%s/size%s/%s",
                    dc.geefThema().name().toLowerCase(), dc.geefAantalStukken(), puzzelstukken[kolom][rij])
                    : "/images/emptyspace.jpg";
            ImageView ivCard = (ImageView) node;
            ivCard.setImage(new Image(getClass().getResourceAsStream(image)));
        }
        lblClicks.setText("# clicks: " + dc.geefAantalClicks());
        if (dc.isPuzzelOpgelost())
            alertEindeSpel();
    }

    private void alertEindeSpel() {
        // TODO
    }
}