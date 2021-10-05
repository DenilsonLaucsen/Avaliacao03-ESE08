package control;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Repositorio;

public class PostRepository {
	private WebTarget webTarget;
	private Repositorio repo;
	
	public PostRepository (Client client, Repositorio repo) {
		webTarget = client.target("https://api.bitbucket.org/2.0");
		this.repo  = repo;
	}
	
	public Response postRepositorio() {
		Response response = webTarget.path("repositories")
				.path(repo.getOwner().getUsername())
				.path(repo.getSlug())
				.request()
				.post(Entity.entity(repo, MediaType.APPLICATION_JSON_TYPE));

		return response;
	}
}
