
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class Fenetre extends JFrame	{
	List<JButton> jbs = new ArrayList<>();
	JPanel panelBtns = new JPanel();
	Container contentPane = getContentPane();
	int nbBtn;
	
	//Constructeur exo2
//	public Fenetre(int nbBtn) {
//		this.nbBtn = nbBtn;	
//		addBtn();
//		
//	}
	
	public Fenetre() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int hauteurEcran = d.height;
		int largeurEcran = d.width;
		setSize(largeurEcran/2, hauteurEcran/2);
		setLocation(largeurEcran/4, hauteurEcran/4);
		
		showForm();
	}

	public void showForm() {
		JPanel panelBouttons = new JPanel();
		JTextArea textArea = new JTextArea(5, 5);
		JPanel panelForm = new JPanel();
		panelForm.setLayout(new GridLayout(3,2));
		contentPane.add(textArea, BorderLayout.CENTER);
		
		//Nom
		JLabel nameLabel = new JLabel("Nom :");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(65, 68, 80, 14);
	    panelForm.add(nameLabel);
	    
	    JTextField name = new JTextField();
	    name.setBounds(148, 68, 86, 20);
	    panelForm.add(name);
	    name.setColumns(10);
	    
	    // Prenom
	    JLabel firstNameLabel = new JLabel("Prenom :");
	    firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	    firstNameLabel.setBounds(65, 88, 80, 14);
	    panelForm.add(firstNameLabel);
	    
	    JTextField firstName = new JTextField();
	    firstName.setHorizontalAlignment(SwingConstants.RIGHT);
	    firstName.setBounds(148, 88, 86, 20);
	    panelForm.add(firstName);
	    firstName.setColumns(10);
	    
	    //Telephone
	    JLabel lblPhone = new JLabel("Telephone :");
	    lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblPhone.setBounds(65, 108, 80, 14);
	    panelForm.add(lblPhone);
	    
	    JTextField phone = new JTextField();
	    phone.setBounds(148, 108, 86, 20);
	    panelForm.add(phone);
	    phone.setColumns(10);
	    
	    contentPane.add(panelForm, BorderLayout.NORTH);
	    
	    
		JButton envoyer = new JButton("Envoyer");
		panelBouttons.add(envoyer);
		
		JButton quit = new JButton("Quitter");
		panelBouttons.add(quit);
		
		contentPane.add(panelBouttons, BorderLayout.SOUTH);
		
		
	}
	
	
	//Exo 2
//	private void addBtn() {
//		for (int i = 0; i < this.nbBtn; i++) {
//			JButton btn = new JButton("BOUTON"+String.valueOf(i+1));
//			btn.addActionListener( new BtnListener() );
//			btn.setActionCommand(String.valueOf(i+1));
//			this.jbs.add(btn);
//			this.panelBtns.add(btn);
//		}
//		this.contentPane.add(panelBtns);
//	}

	

	
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
