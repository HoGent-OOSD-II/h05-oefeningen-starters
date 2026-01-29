package gui;

import domein.DomeinController;
import dto.KaartDTO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;

public class KaartenPaneel extends GridPane {
    public static final String PAD_NAAR_IMAGES = "/images/masks/";
    private DomeinController dc;
    private GeradenKaartenPaneel geradenKaartenPaneel;
    private SpelScherm spelScherm;

    public KaartenPaneel(DomeinController dc, GeradenKaartenPaneel gk, SpelScherm spelScherm) {
        this.geradenKaartenPaneel = gk;
        this.spelScherm = spelScherm;
        this.dc = dc;
        bouwScherm();
    }

    private void bouwScherm() {
        Image imgWelkom = new Image(getClass().getResourceAsStream("/images/welkom.jpg"));
        setBackground(new Background(new BackgroundImage(imgWelkom, null, null, null, null)));
        setAlignment(Pos.CENTER);

        // TODO rijen en kolommen definiëren


        toonKaartenOpTafel();
    }

    private void toonKaartenOpTafel() {
        boolean alleOmgedraaideKaartenVerwerkt = dc.zijnAlleOmgedraaideKaartenVerwerkt();
        stelGridPaneIn(alleOmgedraaideKaartenVerwerkt);
        if (dc.isTafelLeeg())
            vraagOmNogEensTeSpelen();
        else
            for (KaartDTO kaart : dc.geefKaartenOpTafel()) {
                String image = kaart.faceUp() ? PAD_NAAR_IMAGES + kaart.image() : "/images/faceDown.jpg";
                ImageView ivCard = new ImageView(new Image(getClass().getResourceAsStream(image)));
                ivCard.setFitWidth(110);
                ivCard.setCursor(Cursor.HAND);
                ivCard.setPreserveRatio(true);
                setHalignment(ivCard, HPos.CENTER);
                setValignment(ivCard, VPos.CENTER);
                add(ivCard, kaart.posX(), kaart.posY());
                stelImageViewIn(ivCard, kaart, alleOmgedraaideKaartenVerwerkt);
            }
    }

    private void stelImageViewIn(ImageView ivCard, KaartDTO kaart, boolean alleOmgedraaideKaartenVerwerkt) {
        ivCard.setOnMouseClicked(evt -> {
            evt.consume();
            if (!alleOmgedraaideKaartenVerwerkt)
                verwerkOmgedraaideKaarten();
            else
                toonKaart(kaart);
        });
    }

    private void stelGridPaneIn(boolean alleOmgedraaideKaartjesVerwerkt) {
        if (alleOmgedraaideKaartjesVerwerkt) {
            setCursor(Cursor.DEFAULT);
            setOnMouseClicked(null);
        } else {
            setCursor(Cursor.HAND);
            setOnMouseClicked(evt -> {
                evt.consume();
                verwerkOmgedraaideKaarten();
            });
        }
    }

    private void toonKaart(KaartDTO kaartDTO) {
        dc.draaiKaart(kaartDTO);
        this.getChildren().clear();
        toonKaartenOpTafel();
    }

    private void verwerkOmgedraaideKaarten() {
        dc.verwerkOmgedraaideKaarten();
        this.getChildren().clear();
        toonKaartenOpTafel();
        geradenKaartenPaneel.toonGeradenKaarten();
    }

    private void vraagOmNogEensTeSpelen() {
        // TODO
    }
}