package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import control.PostRepository;
import model.Account;
import model.Repositorio;

public class TelaCriarRepo extends JFrame implements ActionListener{

	private Account usuario;
	private Client client;
	private JLabel nomeRepo, ehPrivado;
	private JButton enviar, voltar;
	private JPanel panel;
	private JTextField txtNomeRepo;
	private JCheckBox chbxPrivado;
	
	public TelaCriarRepo(Client client, Account usuario) {
		this.client = client;
		this.usuario = usuario;
	}
	
	public void inicializar() {
		JOptionPane.showMessageDialog(null, "O nome do repositório precisa estar com as letras minúsculas e sem espaço entra as palavras.");
        nomeRepo = new JLabel();
        nomeRepo.setText("Nome do repositório: ");
        ehPrivado = new JLabel();
        ehPrivado.setText("É privado: ");
        chbxPrivado = new JCheckBox();
        txtNomeRepo = new JTextField();
        enviar = new JButton("ENVIAR");
        voltar = new JButton("VOLTAR");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(nomeRepo);
        panel.add(txtNomeRepo);
        panel.add(ehPrivado);
        panel.add(chbxPrivado);
        panel.add(voltar);
        panel.add(enviar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        enviar.addActionListener(this);;
        voltar.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enviar) {
			Repositorio repo = new Repositorio();
			repo.setSlug(txtNomeRepo.getText());
			if(chbxPrivado.isSelected()) {
				repo.setIs_private(true);
			}else {
				repo.setIs_private(false);
			}
			repo.setOwner(usuario);
			PostRepository postRepositorio = new PostRepository(client, repo);
			Response response = postRepositorio.postRepositorio();
			if (response.getStatus() == 200) {
				JOptionPane.showMessageDialog(null, "Criado com sucesso");
				Menu menu = new Menu(usuario, client);
				setVisible(false);
				menu.inicializar();
			} else {
				JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente");
			}
			
		}
		if (e.getSource() == voltar) {
			Menu menu = new Menu(usuario, client);
			setVisible(false);
			menu.inicializar();
		}
	}
}
