package fr.polymontp.mas.entreprise;

public class EntrepriseSatureDeCommerciauxException extends Exception {
	private Entreprise entreprise;
	
	public EntrepriseSatureDeCommerciauxException(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
		}
	public void printError() {
		System.out.println("Impossible d'ajouter un nouveau commercial à cette entreprise car elle ne peut contenir que "+ String.valueOf(this.entreprise.getNbComMax()) +" commerciaux");
	}
}
