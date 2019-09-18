package fr.polymontp.mas.thread;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread( new Compteur("Toto", 10) );
		Thread t2 = new Thread( new Compteur("Titi", 10) );
		Thread t3 = new Thread( new Compteur("Tata", 10) );
		t1.start();
		t2.start();
		t3.start();
	}
}
