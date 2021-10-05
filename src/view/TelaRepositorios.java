package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.ws.rs.client.Client;

import model.Account;
import model.Repositorio;

public class TelaRepositorios extends JFrame implements ActionListener{

	private Repositorio[] repos;
	private JLabel message;
	private JPanel panel;
	private JButton voltar;
	private Account usuario;
	private Client client;
	
	public TelaRepositorios(Repositorio[] repos, Client client, Account usuario) {
		this.repos = repos;
		this.client = client;
		this.usuario = usuario;
	}
	
	public void inicializar() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane srcPane = new JScrollPane(panel);
		for (Repositorio r : repos) {
			message = new JLabel();
			message.setText("<html>Nome: " + r.getSlug() + 
					"<br>Updated: " + r.getUpdated_on() + 
					"<br>Privado: " + r.isIs_private());
			panel.add(message);	
			panel.add(new JSeparator());
		}
	    
		
		voltar = new JButton("Voltar");
		panel.add(voltar);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		voltar.addActionListener(this);
        add(srcPane, BorderLayout.CENTER);
        setTitle("Repositórios");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Menu menu = new Menu(usuario, client);
		setVisible(false);
		menu.inicializar();
	}
}
