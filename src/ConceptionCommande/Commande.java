package ConceptionCommande;
//import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Commande {
 
	private int idCommande;
	private String date; 
	private String type;
	private int payee;
	private Client client;
    private List<LigneCommande> lignesCommande;
  
	public Commande() {}
	public Commande(int id,String date,String type,int payee,Client client) {
		this.idCommande=idCommande;
		this.date=date;
		this.type=type;
		this.payee=payee;
		this.client = client; 
	} 
	
   public static Commande createCommandeFromUser(Client client)
   {
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.print("Entrer l'ID de la commande : ");
	  int id = scan.nextInt(); 
	  scan.nextLine();
	  System.out.print("Entrer la date de la commande (YY/MM/DD) : ");
	  String date = scan.nextLine();
	   
	   
	  System.out.print("Est ce que la commande  est (Express ou Normale) : ");
	  String type = scan.nextLine();
	  
	  
	  System.out.print("Est ce  que la commande est payé ou non ? (1/0) : ");
	  int payee = scan.nextInt();
	  scan.nextLine();   
	  
	  return new Commande(id,date,type,payee,client);
	       
   }
   
   public double calculTotalProduit() {
       double total = 0.0;
       for (LigneCommande ligne : lignesCommande) {
           total += ligne.calculTotalProduit();
       }
       return total;
   }  
   
   public void ajouterLigneCommande(Produit produit, int qteCommande, double reduction) {
       LigneCommande ligneCommande = new LigneCommande(produit, this, qteCommande, reduction);
       lignesCommande.add(ligneCommande);
   }
   
   public int getIdCommande() {
	return idCommande;
}   
   
   public String getDate() {
	return date;
}
   
   public Client getClient() {
	return client;

}
   
   
}
