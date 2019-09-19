package fr.polymontp.mas.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame	{
	List<JButton> jbs = new ArrayList<>();
	JPanel panelBtns = new JPanel();
	Container contentPane = getContentPane();
	int nbBtn;
	
	public Fenetre(int nbBtn) {
		this.nbBtn = nbBtn;	
		addBtn();
		
	}
	
	private void addBtn() {
		for (int i = 0; i < this.nbBtn; i++) {
			JButton btn = new JButton("BOUTON"+String.valueOf(i+1));
			btn.addActionListener( new BtnListener() );
			btn.setActionCommand(String.valueOf(i+1));
			this.jbs.add(btn);
			this.panelBtns.add(btn);
		}
		this.contentPane.add(panelBtns);
	}

//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		int numBtn = -1;
//		Object source = arg0.getSource();
//		
//		int i = 1;
//		for (Iterator iterator = jbs.iterator(); iterator.hasNext(); i++) {
//			if(iterator.next() == source) {
//				numBtn = i;
//				break;
//			}
//		}
//		System.out.println(numBtn);
//	}
	
	class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String actionCommand = arg0.getActionCommand();
			int i = 0;
			while(i < Integer.valueOf(actionCommand)) {
				System.out.print("*");
				i++;
			}
			System.out.println();
		}
		
	}
}
