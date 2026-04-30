package model;

import java.util.ArrayList;
import java.util.List;

public class DossierPatient {
    private int idDossier;
    private List<String> notes;
    private StatutDossier statut;

    public DossierPatient(int id) {
        this.idDossier = id;
        this.notes = new ArrayList<>();
        this.statut = StatutDossier.ACTIF;
    }

    public void ajouterNote(String note) {
        notes.add(note);
    }

    public void changerStatut(StatutDossier statut) {
        this.statut = statut;
    }

    public List<String> getNotes() {
        return notes;
    }

}
