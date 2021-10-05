package model;
public class Account {

	private String type;
	private String created_on;
	private String display_name;
	private Object links;
	private String username;
	private String uuid;
	private String website;
	private boolean has_2fa_enabled;
	private String account_id;
	private String nickname;
	private boolean is_staff;
	private String location;
	private String account_status;
	
	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIs_staff() {
		return is_staff;
	}

	public void setIs_staff(boolean is_staff) {
		this.is_staff = is_staff;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	
	public void mostrarAccount() {
		System.out.println(getUsername());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public Object getLinks() {
		return links;
	}

	public void setLinks(Object links) {
		this.links = links;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isHas_2fa_enabled() {
		return has_2fa_enabled;
	}

	public void setHas_2fa_enabled(boolean has_2fa_enabled) {
		this.has_2fa_enabled = has_2fa_enabled;
	}
	
}
