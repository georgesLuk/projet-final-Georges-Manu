



import model.*;
import Service.GestionCentre;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GestionCentre centre = new GestionCentre();

    public static void main(String[] args) {

        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // vider buffer

            switch (choix) {
                case 1:
                    ajouterPatient();
                    break;

                case 2:
                    ajouterProfessionnel();
                    break;

                case 3:
                    creerRendezVous();
                    break;

                case 4:
                    afficherPatients();
                    break;

                case 5:
                    afficherRendezVous();
                    break;

                case 6:
                    System.out.println("Test");
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }

    // ================= MENU =================

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ajouter un patient");
        System.out.println("2. Ajouter un professionnel");
        System.out.println("3. Créer un rendez-vous");
        System.out.println("4. Afficher les patients");
        System.out.println("5. Afficher les rendez-vous");
        System.out.println("0. Quitter");
        System.out.print("Choix : ");
    }

    // ================= ACTIONS =================

    private static void ajouterPatient() {
        try {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();

            int id = centre.getPatients().size() + 1;

            Patient p = new Patient(id, nom, prenom, "000000000", "2000-01-01", "QC");
            centre.ajouterPatient(p);

            System.out.println("✅ Patient ajouté !");
        } catch (Exception e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }
    }

    private static void ajouterProfessionnel() {
        try {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();

            System.out.print("Spécialité : ");
            String specialite = scanner.nextLine();

            int id = centre.getProfessionnels().size() + 1;

            ProfessionnelSante pro = new ProfessionnelSante(
                    id, nom, prenom, "000000000", specialite, "Médecin"
            );

            centre.ajouterProfessionnel(pro);

            System.out.println("✅ Professionnel ajouté !");
        } catch (Exception e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }
    }

    private static void creerRendezVous() {
        try {
            if (centre.getPatients().isEmpty() || centre.getProfessionnels().isEmpty()) {
                System.out.println("⚠️ Ajoute au moins un patient et un professionnel !");
                return;
            }

            Patient p = choisirPatient();
            ProfessionnelSante pro = choisirProfessionnel();

            RendezVous rdv = new RendezVous(new Date(), "Consultation", p, pro);
            centre.ajouterRendezVous(rdv);

            System.out.println("✅ Rendez-vous créé !");
        } catch (Exception e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }
    }

    private static void afficherPatients() {
        if (centre.getPatients().isEmpty()) {
            System.out.println("Aucun patient.");
            return;
        }

        for (Patient p : centre.getPatients()) {
            System.out.println(p.afficherInfos());
        }
    }

    private static void afficherRendezVous() {
        if (centre.getRendezVous().isEmpty()) {
            System.out.println("Aucun rendez-vous.");
            return;
        }

        for (RendezVous r : centre.getRendezVous()) {
            System.out.println(r.afficher());
        }
    }

    // ================= CHOIX =================

    private static Patient choisirPatient() {
        System.out.println("Choisir un patient :");

        for (int i = 0; i < centre.getPatients().size(); i++) {
            System.out.println((i + 1) + ". " + centre.getPatients().get(i).afficherInfos());
        }

        int choix = scanner.nextInt();
        scanner.nextLine();

        return centre.getPatients().get(choix - 1);
    }

    private static ProfessionnelSante choisirProfessionnel() {
        System.out.println("Choisir un professionnel :");

        for (int i = 0; i < centre.getProfessionnels().size(); i++) {
            System.out.println((i + 1) + ". " + centre.getProfessionnels().get(i).afficherInfos());
        }

        int choix = scanner.nextInt();
        scanner.nextLine();

        return centre.getProfessionnels().get(choix - 1);
    }
}