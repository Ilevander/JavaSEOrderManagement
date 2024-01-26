package ConceptionCommande;
 
public class LigneCommande {
	private Produit produit;   
    private Commande commande;
    private int qteCommande; 
    private double reduction;

    public LigneCommande(Produit produit, Commande commande, int qteCommande, double reduction) {
        this.produit = produit;
        this.commande = commande;
        this.qteCommande = qteCommande;
        this.reduction = reduction;
    } 
   
    public double calculTotalProduit() {

     return produit.getPrixUnit()*qteCommande * (1 - reduction / 100);
    }  
}  
       