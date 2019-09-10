package fr.polymontp.mas.entreprise;

public class Commercial extends Employe {
	private float somme;
	private float CA;

	public Commercial(String nom, Entreprise e) {
		super(nom, e);
		// TODO Auto-generated constructor stub
	}

	public Commercial(String nom, float somme, float CA, Entreprise e) {
		super(nom, e);
		this.somme = somme;
		this.CA = CA;
	}
	
	@Override
	public float getSalaire() {
		return (float) (this.somme + 0.01*getCA());
	}
	
	public void setInfosSalaire(int somme) {
		this.somme = somme;
	}
	
	public float getCA() {
		return CA;
	}
}
