package ConceptionCommande;

public class Produit {
	private int idProduct; 
    private String designation;
    private double prixUnit; 
    private int qteStock;
  
    public Produit(int id, String designation, double prixUnit, int qteStock) {
        this.idProduct = idProduct;
        this.designation = designation; 
        this.prixUnit = prixUnit;
        this.qteStock = qteStock;
    }
    public double getPrixUnit() {
		return prixUnit;
	}  
    
    
    public int getQteStock() {
		return qteStock;
	}
    
    public String getDesignation() {
		return designation;
	}
      
}  
   