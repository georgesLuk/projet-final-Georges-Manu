package model;

public class Patient extends Personne {
    private int numeroPatient;
    private String dateNaissance;
    private String adresse;
    private DossierPatient dossier;

    public Patient(int numeroPatient, String nom, String prenom, String telephone, String dateNaissance, String adresse) {
        super(nom, prenom, telephone);
        this.numeroPatient = numeroPatient;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.dossier = new DossierPatient(numeroPatient);
    }

    public int getNumeroPatient() { return numeroPatient; }
    public DossierPatient getDossier() { return dossier; }

    @Override
    public String afficherInfos() {
        return "Patient #" + numeroPatient + " : " + getNom() + " " + getPrenom();
    }
}
