package fr.polymontp.mas.entreprise;

import java.util.ArrayList;
import java.util.List;

public class Directeur extends Employe{
	private float sommeFixe = 2000 ;
	static Directeur leDirecteur = null ;
	private List<Commercial> commerciaux = new ArrayList<>();
	
	public static Directeur CreeDirecteur(String nom, List<Employe> employes) {
		if(leDirecteur == null) {
			leDirecteur = new Directeur(nom, employes);
		}
		return leDirecteur;
	}

	private Directeur(String nom, List<Employe> employes) {
		super(nom);		
		for(Employe employe : employes) {
			if(employe.getClass().equals(Commercial.class)) {
				commerciaux.add((Commercial)employe);
			}
		}
	}
	
	public float getSalaire() {
		float sommeCA = 0;
		for (Commercial commercial : commerciaux) {
			sommeCA = sommeCA + (float) (commercial.getCA()*0.04);
		}
		return sommeCA + sommeFixe;
	}
}
