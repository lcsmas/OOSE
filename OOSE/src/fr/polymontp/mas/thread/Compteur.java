package fr.polymontp.mas.thread;

public class Compteur implements Runnable{
	String name;
	int value;
	int lim;
	
	public Compteur(String name, int lim) {
		this.name = name;
		this.lim = lim;
	}

	@Override
	public void run() {
		while (value < lim) {
			value = value + 1;
			try {
				long sleepTime = Math.round(Math.random()*5000);
				Thread.sleep(sleepTime);
				System.out.println(this.name + " : " + this.value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("***" + this.name + " a fini de compter jusqu'à " + this.value);
	}
	
	
	
}
