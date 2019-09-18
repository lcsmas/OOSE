package fr.polymontp.mas.thread;

/**
 * Tri d'un tableau d'entiers multi-thread.
 * Version qui utilise join().
 */
public class Trieur implements Runnable {

  private int[] t; // tableau à trier
  private int debut, fin; // tranche de ce tableau qu'il faut trier
  

  public Trieur(int[] t, int debut, int fin) {
	  this.debut = debut;
	  this.fin = fin;
	  this.t = t;
  }

  public void run() {
	trier();
  }
  
  /**
   * Trie une tranche de t
   * @param debut indice du d�but de la partie � trier
   * @param debut indice de la fin de la partie � trier
   */
  private void trier() {
    if (fin - debut < 2) {
      if (t[debut] > t[fin]) {
        echanger(debut, fin);
      }
      notify();
    }
    else {
      int milieu = debut + (fin - debut) / 2;
      Trieur trieur1 = new Trieur(t, debut, milieu);
      Trieur trieur2 = new Trieur(t, milieu + 1, fin);
      Thread t1 = new Thread(trieur1);
      Thread t2 = new Thread(trieur2);
      t1.start();
      t2.start();
      try {
    	wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      this.triFusion();
    }
  }

  /**
   * Echanger t[i] et t[j]
   */
  private void echanger(int i, int j) {
    int valeur = t[i];
    t[i] = t[j];
    t[j] = valeur;
  }
  
  /**
   * Fusionne 2 tranches déjà triées du tableau t.
   *   - 1ère tranche : de debut à milieu
   *   - 2ème tranche : de milieu + 1 à fin
   * @param milieu indique le dernier indice de la 1ère tranche
   */
  private void triFusion() {
    // tableau où va aller la fusion
    int[] tFusion = new int[fin - debut + 1];
    int milieu = (debut + fin) / 2;
    // Indices des éléments à comparer
    int i1 = debut, 
        i2 = milieu + 1;
    // indice de la prochaine case du tableau tFusion à remplir
    int iFusion = 0;
    while (i1 <= milieu && i2 <= fin) {
      if (t[i1] < t[i2]) {
        tFusion[iFusion++] = t[i1++];
      }
      else {
        tFusion[iFusion++] = t[i2++]; 
      }
    }
    if (i1 > milieu) {
      // la 1ère tranche est épuisée
      for (int i = i2; i <= fin; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    else {
      // la 2ème tranche est épuisée
      for (int i = i1; i <= milieu; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    // Copie tFusion dans t
    for (int i = 0, j = debut; i <= fin - debut; ) {
      t[j++] = tFusion[i++];
    }
  }
  
  public static void main(String[] args) {
    int[] t = {5, 8, 3, 2, 7, 10, 1};
    
    Trieur trieur = new Trieur(t, 0, t.length -1);
    Thread th = new Thread(trieur);
    th.start();
    try {
		th.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    trieur.triFusion();

    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }
    System.out.println();
  }

}

