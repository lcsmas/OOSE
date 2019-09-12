package fr.polymontp.mas.entreprise;

public class Directeur extends Employe{
	private float sommeFixe = 2000 ;

	Directeur(String nom, Entreprise e) {
		super(nom, e);
	}
	
	public float getSalaire() {
		float sommeCA = 0;
		Employe[] emp = super.entreprise._emp;
		for (int i = 0; i < emp.length; i++) {
			if(emp[i] == null) {
				break;
			}
			if(emp[i].getClass().equals(Commercial.class)) {
				sommeCA = sommeCA + (float) (((Commercial)emp[i]).getCA()*0.04);
			}
		}
		return sommeCA + sommeFixe;
	}
}
