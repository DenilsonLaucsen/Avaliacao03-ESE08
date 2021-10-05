package control;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import model.Account;
import model.PaginatedRepository;
import model.Repositorio;

public class GetRepositories {
	private WebTarget webTarget;
	private Account user;
	
	public GetRepositories(Client client, Account user) {
		this.webTarget = client.target("https://api.bitbucket.org/2.0");
		this.user = user;
	}
	
	public Repositorio[] getRepositories() {
	PaginatedRepository repo = webTarget.path("users")
			.path(user.getUsername())
			.path("repositories")
			.request(MediaType.APPLICATION_JSON_TYPE)
			.get()
			.readEntity(PaginatedRepository.class);
	return repo.getRepositorios();
	}
}
