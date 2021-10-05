package control;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Account;

public class GetAccount {
	private WebTarget webTarget;
	private Account user;
	private Response response;

	public GetAccount(Client client) {
		webTarget = client.target("https://api.bitbucket.org/2.0");
	}
	
	public Account getAccount() {
		response = webTarget.path("user")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get();
		if (response.getStatus() == 200) {
			user = response.readEntity(Account.class);
			return user;
		} else {
			return null;
		}
	}
}
