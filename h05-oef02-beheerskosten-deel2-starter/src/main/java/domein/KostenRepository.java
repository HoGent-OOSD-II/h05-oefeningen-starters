package domein;

import persistentie.BeheerskostenMapper;

import java.util.ArrayList;
import java.util.List;

public class KostenRepository {
    private List<Beheerskost> kosten;
    private BeheerskostenMapper bm;

    public KostenRepository() {
        bm = new BeheerskostenMapper();
        kosten = bm.geefBeheerskosten();
    }

    public List<Beheerskost> getKosten() {
        return kosten;
    }

    public Beheerskost geefBeheerskost(int index) {
        return kosten.get(index);
    }

    public List<Rekening> geefRekeningen() {
        // TODO Maak en retourneer een lijst met alle Rekeningen
        return new ArrayList<>();
    }

    public Rekening geefRekening(int index) {
        return geefRekeningen().get(index);
    }
}