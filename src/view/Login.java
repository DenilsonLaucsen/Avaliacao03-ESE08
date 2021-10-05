package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import control.GetAccount;
import model.Account;

public class Login extends JFrame implements ActionListener{
	
	private JPanel panel;
    private JLabel labUser, labPassword, labMessage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton enviar;
    private String username, password;
    private Client client;
    private GetAccount conta;
    private Account usuario;

    public void inicializar() {
        
        labUser = new JLabel();
        labUser.setText("Nome do usuário: ");
        txtUsername = new JTextField();
        labPassword = new JLabel();
        labPassword.setText("Senha:");
        txtPassword = new JPasswordField();
        enviar = new JButton("ENVIAR");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(labUser);
        panel.add(txtUsername);
        panel.add(labPassword);
        panel.add(txtPassword);

        labMessage = new JLabel();
        panel.add(labMessage);
        panel.add(enviar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        enviar.addActionListener(this);;
        add(panel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // username testedeestudos00@gmail.com
    // senha testando1234
    @Override
    public void actionPerformed(ActionEvent ae) {
        setUsername(txtUsername.getText());
        setPassword(txtPassword.getText());
		Client client = ClientBuilder.newClient();
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(getUsername(), getPassword());
		client.register(feature);
		conta = new GetAccount(client);
		usuario = conta.getAccount();
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Algo deu errado no login! Tente novamente");
		}else {
			JOptionPane.showMessageDialog(null, "Seja bem-vindo " + usuario.getUsername());
			Menu menu = new Menu(usuario, client);
			setVisible(false);
			menu.inicializar();
		}

        
    }

    
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
