package model;

import java.util.Date;

public class RendezVous {
    private Date date;
    private String typeConsultation;
    private EtatRendezVous etat;
    private Patient patient;
    private ProfessionnelSante professionnel;

    public RendezVous(Date date, String type, Patient patient, ProfessionnelSante pro) {
        this.date = date;
        this.typeConsultation = type;
        this.patient = patient;
        this.professionnel = pro;
        this.etat = EtatRendezVous.PLANIFIE;
    }

    public void changerEtat(EtatRendezVous etat) {
        this.etat = etat;
    }

    public String afficher() {
        return date + " - " + typeConsultation + " - " + etat;
    }
}

