package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.ws.rs.client.Client;

import control.GetRepositories;
import model.Account;
import model.Repositorio;

public class Menu extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel mensagem;
	private JButton btnCriarRepo, btnListarRepo;
	private Account usuario;
	private Client client;
	private Repositorio[] repos;
	
	public Menu (Account usuario, Client client) {
		this.usuario = usuario;
		this.client = client;
	}

	public void inicializar() {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		mensagem = new JLabel();
		mensagem.setText("Ola " + usuario.getUsername() + ", aqui você pode criar e ver seus repositórios.");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(mensagem, c);

		btnCriarRepo = new JButton("Criar repositório");
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(btnCriarRepo, c);
				
		btnListarRepo = new JButton("Ver repositórios");
		c.gridx = 0;
		c.gridy = 2;
		panel.add(btnListarRepo, c);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
        btnCriarRepo.addActionListener(this);
        btnListarRepo.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Menu");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCriarRepo) {
			TelaCriarRepo telaCriarRepo = new TelaCriarRepo(client, usuario);
			setVisible(false);
			telaCriarRepo.inicializar();
		}
		if (e.getSource() == btnListarRepo) {
			GetRepositories getRepos = new GetRepositories(client, usuario);
			repos = getRepos.getRepositories();
			TelaRepositorios telaRepos = new TelaRepositorios(repos, client, usuario);
			setVisible(false);
			telaRepos.inicializar();	
		}
	}

	
	
}
