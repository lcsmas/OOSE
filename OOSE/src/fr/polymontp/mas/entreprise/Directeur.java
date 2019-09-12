package fr.polymontp.mas.entreprise;

import java.util.ArrayList;

public class Directeur extends Employe{
	private float sommeFixe = 2000 ;

	Directeur(String nom, Entreprise e) {
		super(nom, e);
	}
	
	public float getSalaire() {
		float sommeCA = 0;
		ArrayList<Employe> emp = super.entreprise.getEmp();
		
		for (Employe employe : emp) {
			if (Employe.class.equals(Commercial.class)){
				sommeCA = sommeCA + (float) (((Commercial)employe).getCA()*0.04);
			}
		}
		return sommeCA + sommeFixe;
	}
}
