package model;

public class Repositorio {

		private String type;
		private String created_on;
		private String description;
		private String fork_policy;
		private String full_name;
		private boolean has_issues;
		private boolean has_wiki;
		private boolean is_private;
		private String language;
		private Object links;
		private String name;
		private Account account;
		private Repositorio parent;
		private String scm;
		private int size;
		private String updated_on;
		private String uuid;
		private Object error;
		private String website;
		private Object project;
		private Object mainbranch;
		private Object workspace;
		private Account owner;
		private String slug;
		
		public Repositorio() {
			
		}
		
		public Repositorio(Account owner, String slug) {
			this.slug = slug;
			this.owner = owner;
		}
		
		public String getSlug() {
			return slug;
		}
		public void setSlug(String slug) {
			this.slug = slug;
		}
		public Account getOwner() {
			return owner;
		}
		public void setOwner(Account owner) {
			this.owner = owner;
		}
		public Object getWorkspace() {
			return workspace;
		}
		public void setWorkspace(Object workspace) {
			this.workspace = workspace;
		}
		public Object getMainbranch() {
			return mainbranch;
		}
		public void setMainbranch(Object mainbranch) {
			this.mainbranch = mainbranch;
		}
		public Object getProject() {
			return project;
		}
		public void setProject(Object project) {
			this.project = project;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		public Object getError() {
			return error;
		}
		public void setError(Object error) {
			this.error = error;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getFork_policy() {
			return fork_policy;
		}
		public void setFork_policy(String fork_policy) {
			this.fork_policy = fork_policy;
		}
		public String getFull_name() {
			return full_name;
		}
		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}
		public boolean isHas_issues() {
			return has_issues;
		}
		public void setHas_issues(boolean has_issues) {
			this.has_issues = has_issues;
		}
		public boolean isHas_wiki() {
			return has_wiki;
		}
		public void setHas_wiki(boolean has_wiki) {
			this.has_wiki = has_wiki;
		}
		public boolean isIs_private() {
			return is_private;
		}
		public void setIs_private(boolean is_private) {
			this.is_private = is_private;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public Object getLinks() {
			return links;
		}
		public void setLinks(Object links) {
			this.links = links;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public Repositorio getParent() {
			return parent;
		}
		public void setParent(Repositorio parent) {
			this.parent = parent;
		}
		public String getScm() {
			return scm;
		}
		public void setScm(String scm) {
			this.scm = scm;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getUpdated_on() {
			return updated_on;
		}
		public void setUpdated_on(String updated_on) {
			this.updated_on = updated_on;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		
		
		
}
