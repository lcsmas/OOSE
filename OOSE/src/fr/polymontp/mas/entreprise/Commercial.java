package fr.polymontp.mas.entreprise;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Commercial extends Employe  {
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
	
	
	public void enregistreToi(FileWriter f) throws IOException {
		String infos = this.getNom() + "|" + this.somme + "|" + this.CA;  
		f.write(infos);
		f.close();
	}
	
	public void enregistreToiBinaire(FileOutputStream fs) {
		byte[] infos = this.getNom().getBytes();
		try {
			fs.write(infos);
			fs.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void lire(FileReader f) {
		char[] str = new char[512];
		try {
			f.read(str);
			StringTokenizer st = new StringTokenizer(String.copyValueOf(str), "|");
			while (st.hasMoreTokens()) {
		         System.out.println(st.nextToken());
		     }
		} catch (IOException e) {
			System.err.print(e.getMessage());
		}
		
		
		
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
