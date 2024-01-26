package ConceptionCommande;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat; 

public class GestionCommande {
 
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("-Entrer l'ID de Client : ");
		int clientId = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Entrez le nom du client : ");
        String clientNom = scan.nextLine();
        
        System.out.print("Entrez l'adresse du client : ");
        String clientAdresse = scan.nextLine();
        
        System.out.print("Entrez le numéro de téléphone du client : ");
        String clientTel = scan.nextLine();
        
        System.out.println("Création d'un Client par initialisation: ");
        Client client= new Client( clientId,  clientNom ,  clientAdresse , clientTel); 
		 
        
        Commande commande= Commande.createCommandeFromUser(client);
         
        System.out.println("Entrer le nombre de produit de la commande : ");
        int nombreProduit = scan.nextInt();
        scan.nextLine(); 
        
        Produit [] produits = new Produit[nombreProduit];
        
        for(int i=0;i<nombreProduit;i++)
        {
        	System.out.println("Produit #"+(i+1)); 
        	System.out.print("ID : ");
            int productId = scan.nextInt();
            scan.nextLine(); 
            System.out.print("Désignation : ");
            String productDesignation = scan.nextLine();
            System.out.print("Prix unitaire : ");
            double productPrixUnit = scan.nextDouble();
            System.out.print("Quantité en stock : ");
            int productQteStock = scan.nextInt();
            System.out.print("Quantité commandée : ");
            int qteCommande = scan.nextInt(); 
            System.out.print("Réduction (%) : ");
            double reduction = scan.nextDouble();
            
           produits[i] = new Produit(productId,  productDesignation,  productPrixUnit,  productQteStock);
           
           LigneCommande ligneCommande = new LigneCommande( produits[i], commande,  qteCommande,  reduction);
             
           commande.ajouterLigneCommande( produits[i],  qteCommande,  reduction);  

        }  
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd/MM/yyyy");
        System.out.println("Bon de commande NO : " + commande.getIdCommande() + " - Date : " + sdf.format(commande.getDate()));
        System.out.println("Client : " + commande.getClient().getNom());
        System.out.println("Article : Description\tQte\tPrixUnitaire\tTotal");
        
        double totalCommande = 0;
        for (Produit produit : produits) {
            LigneCommande ligneCommande = new LigneCommande(produit, commande, produit.getQteStock(), 0);
            double totalProduit = ligneCommande.calculTotalProduit();
            System.out.println(produit.getDesignation()+ "\t" + produit.getQteStock()+ "\t" + produit.getPrixUnit() + "\t" + totalProduit);
            totalCommande += totalProduit;
        }
 
        System.out.println("Total de la commande (TTC) : " + totalCommande);
	} 

}
 