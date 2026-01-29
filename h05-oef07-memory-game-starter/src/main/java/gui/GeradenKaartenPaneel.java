package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GeradenKaartenPaneel extends HBox {

    private DomeinController dc;

    public void voegKaartjeToe(ImageView ivKaartje) {
        this.getChildren().add(ivKaartje);
    }

    public GeradenKaartenPaneel(DomeinController dc) {
        this.dc = dc;
        setPrefHeight(73);
        setSpacing(10);
        setId("geradenKaartjes");
        setPadding(new Insets(10));
        toonGeradenKaarten();
    }

    public void toonGeradenKaarten() {
        // TODO
    }
}