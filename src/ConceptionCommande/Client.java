package ConceptionCommande;

public class Client {
	
	private int idClient;
	private String nom;
	private String adress;
	private String tel; 
	
	public Client() {}
	public Client(int id, String nom , String adress ,String tel) {
		this.idClient=idClient;
		this.nom=nom;
		this.adress=adress; 
		this.tel= tel;
	}   
	 public String getNom() {
		return nom;
	}
} 
