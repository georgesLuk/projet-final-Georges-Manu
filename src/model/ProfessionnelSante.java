package model;

public class ProfessionnelSante extends Personne{

    private int idProfessionnel;
    private String specialite;
    private String role;

    public ProfessionnelSante(int id, String nom, String prenom, String telephone, String specialite, String role) {
        super(nom, prenom, telephone);
        this.idProfessionnel = id;
        this.specialite = specialite;
        this.role = role;
    }

    @Override
    public String afficherInfos() {
        return role + " : " + getNom();
    }
}
