
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {
	
	// Main exo 2 
//	public static void main(String[] args)  {
//		System.out.print("Nombre de boutons ? ");
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int nbBtn=0;
//		Fenetre f;
//		try {
//			nbBtn = Integer.valueOf(in.readLine());
//			 
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		f = new Fenetre(nbBtn);
//		f.pack();
//		f.setVisible(true);
//	}
	
	// Main exo3 
	public static void main(String[] args)  {
		Fenetre f;
		f = new Fenetre();
		f.showForm();
		//f.pack();
		f.setVisible(true);
	}
}
