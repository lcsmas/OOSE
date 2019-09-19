package fr.polymontp.mas.swing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.print("Nombre de boutons ? ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nbBtn = Integer.valueOf(in.readLine());
		Fenetre f = new Fenetre(nbBtn);
		f.pack();
		f.setVisible(true);
	}
}
