package fr.polymontp.mas.entreprise;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Object> {
	private int sign;
	public final static int ASCENDING_ORDER = 1;
	public final static int DESCENDING_ORDER = -1;
	
	
	public SalaryComparator(int sign) {
		this.sign = sign;
	}


	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return (int) ((((Employe)o1).getSalaire() - ((Employe)o2).getSalaire())*sign);
	}

}
