import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        
       while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Créer un rendez-vous");
            System.out.println("2. Ajouter des nouveaux patients");
            System.out.println("3. Dossiers Médicaux");
            System.out.println("0. Retour");

            int choix = sc.nextInt();
            sc.nextLine();

            try {
                switch (choix) {

                    case 1: // créer un rendez-vous
                        
                        break;

                    case 2: // Ajouter des nouveaux patients 
                        
                        break;

                    case 3: // sous-menu dossiers médicaux
                        
                        break;

                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }
}
