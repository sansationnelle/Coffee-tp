import java.util.Scanner;

public class Coffee {
    private int eau;
    private int graine;
    private int gobelets;
    private int servis;
    private int argent;
    private int moneyeur;

    public Coffee(int cl, int g,int nbr,int serv,int gold, int cred) {
        this.eau = cl;
        this.graine = g;
        this.gobelets = nbr;
        this.servis = serv;
        this.argent = gold;
        this.moneyeur = cred;
    }

    public void menu(){
        Scanner txt = new Scanner(System.in);
        System.out.println("---------------------\nEtat : EAU : " + this.eau + "cl | GRAINS : " + this.graine + "g | GOBLETS: " + this.gobelets + "\nCREDIT : " + printEuros(this.moneyeur) + " PANNE : \n--------------------\n1. Insérer une pièce (Simuler +0$50)\n2. Commender un Expresso (1$50)\n3. Commander un Allongé (2$00)\n4. MENU TECHNITIEN (Maintenance)\n5. Quitter");
        String choix = txt.nextLine();
        if (choix.equals("1")){
            getCredit(50);
        } else if (choix.equals("2")){
            if (this.moneyeur < 150) {
                System.out.println("Crédit insuffisant, ajoutez de la monnaie");
            } else if (servis >= 5){
                System.out.println("ERREUR: Machine\r\n" + "entartrée - Appelez le technicien");
            } else if (this.eau < 10 || this.graine < 10 || this.gobelets <= 0) {
                System.out.println("ERREUR: Machine\r\n" + "ingrédients insuffisant - Appelez le technicien");
            } else {
                this.eau -= 10;
                this.graine -= 10;
                this.gobelets -= 1;
                this.moneyeur -= 150;
                this.argent += 150;
                this.servis += 1;
                System.out.println("Votre café est prêt");
            }
        } else if (choix.equals("3")){
            if (this.moneyeur < 200) {
                System.out.println("Pas assez d'argent inseré");
            } else if (servis >= 5){
                System.out.println("ERREUR: Machine\r\n" + "entartrée - Appelez le technicien");
            } else if (this.eau < 20 || this.graine < 10 || this.gobelets <= 0) {
                System.out.println("ERREUR: Machine\r\n" + "ingrédients insuffisant - Appelez le technicien");
            } else {
                this.eau -= 20;
                this.graine -= 10;
                this.gobelets -= 1;
                this.moneyeur -= 200;
                this.argent += 200;
                this.servis += 1;
                System.out.println("Votre café est prêt");
            }
        } else if (choix.equals("4")){
            System.out.println("---------------------\n Bienvenue dans le Menu Technicien, que voulez vous faire?---------------------\n1. Recharger la machine\n2. Détartrer la machine\n3. Prendre l'argent de la machine");
            choix = txt.nextLine();
            if (choix.equals("1")) {
                this.eau = 100;
                this.graine = 50;
                this.gobelets = 10;
            } else if (choix.equals("2")) {
                this.servis = 0;
            } else if (choix.equals("3")) {
                System.out.println("La machine a " + printEuros(this.argent));
                this.argent = 0;
            }
        } else if (choix.equals("5")){
            System.exit(0);
        }
    }

    public void getCredit(int montant){
        this.moneyeur += montant;
    }

    public static String printEuros(int money) {
        if (money < 10) {
            return "0$0" + money + "";
        } else if (money < 100) {
            return "0$" + money;
        }
        String lastnbr;
        if (money%100 == 0) {
            lastnbr = "00";
        } else {
            lastnbr = Integer.toString(money%100);
        }
        return money/100 + "$" + lastnbr;
    }
}
