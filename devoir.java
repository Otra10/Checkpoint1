import java.util.ArrayList;
import java.util.Scanner;

class Commande {
    private static int dernierId = 0;

    private int id;
    private String reference;
    private String date;
    private double montant;
    private String statut;

    public Commande(String reference, String date, double montant, String statut) {
        this.id = ++dernierId;
        this.reference = reference;
        this.date = date;
        this.montant = montant;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Référence: " + reference + " - Date: " + date + " - Montant: " + montant + " - Statut: " + statut;
    }
}

public class GestionCommandes {
    private static ArrayList<Commande> commandes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choixMenu;
        do {
            afficherMenu();
            choixMenu = scanner.nextInt();
            switch (choixMenu) {
                case 1:
                    enregistrerCommande();
                    break;
                case 2:
                    listerToutesCommandes();
                    break;
                case 3:
                    listerCommandesParStatut();
                    break;
                case 4:
                    quitterProgramme();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choixMenu != 4);
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Enregistrer une commande");
        System.out.println("2. Lister toutes les commandes");
        System.out.println("3. Lister les commandes par statut");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
    }

    private static void enregistrerCommande() {
        System.out.print("Entrez la référence de la commande : ");
        String reference = scanner.next();
        System.out.print("Entrez la date de la commande : ");
        String date = scanner.next();
        System.out.print("Entrez le montant de la commande : ");
        double montant = scanner.nextDouble();
        System.out.print("Entrez le statut de la commande (Payé ou Impayé) : ");
        String statut = scanner.next();

        Commande commande = new Commande(reference, date, montant, statut);
        commandes.add(commande);
        System.out.println("Commande enregistrée avec succès.");
    }

    private static void listerToutesCommandes() {
        System.out.println("Liste de toutes les commandes :");
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    private static void listerCommandesParStatut() {
        System.out.print("Entrez le statut des commandes à afficher (Payé ou Impayé) : ");
        String statutRecherche = scanner.next();
        System.out.println("Liste des commandes avec le statut '" + statutRecherche + "' :");
        for (Commande commande : commandes) {
            if (commande.getStatut().equalsIgnoreCase(statutRecherche)) {
                System.out.println(commande);
            }
        }
    }

    private static void quitterProgramme() {
        System.out.println("Au revoir !");
        System.exit(0);
    }
}
