package Service;

import model.Patient;
import model.ProfessionnelSante;
import model.RendezVous;

import java.util.ArrayList;
import java.util.List;

public class GestionCentre {

    private List<Patient> patients;
    private List<ProfessionnelSante> professionnels;
    private List<RendezVous> rendezVous;

    // ================= CONSTRUCTEUR =================

    public GestionCentre() {
        this.patients = new ArrayList<>();
        this.professionnels = new ArrayList<>();
        this.rendezVous = new ArrayList<>();
    }

    // ================= AJOUT =================

    public void ajouterPatient(Patient p) {
        if (p == null) {
            throw new IllegalArgumentException("Patient invalide");
        }

        // Anti-doublon (numéro patient unique)
        for (Patient patient : patients) {
            if (patient.getNumeroPatient() == p.getNumeroPatient()) {
                throw new IllegalArgumentException("Patient déjà existant !");
            }
        }

        patients.add(p);
    }

    public void ajouterProfessionnel(ProfessionnelSante p) {
        if (p == null) {
            throw new IllegalArgumentException("Professionnel invalide");
        }

        professionnels.add(p);
    }

    public void ajouterRendezVous(RendezVous r) {
        if (r == null) {
            throw new IllegalArgumentException("Rendez-vous invalide");
        }

        rendezVous.add(r);
    }

    // ================= AFFICHAGE =================

    public void afficherPatients() {
        if (patients.isEmpty()) {
            System.out.println("Aucun patient.");
            return;
        }

        for (Patient p : patients) {
            System.out.println(p.afficherInfos());
        }
    }

    public void afficherRendezVous() {
        if (rendezVous.isEmpty()) {
            System.out.println("Aucun rendez-vous.");
            return;
        }

        for (RendezVous r : rendezVous) {
            System.out.println(r.afficher());
        }
    }

    // ================= GETTERS =================

    public List<Patient> getPatients() {
        return patients;
    }

    public List<ProfessionnelSante> getProfessionnels() {
        return professionnels;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }
}
