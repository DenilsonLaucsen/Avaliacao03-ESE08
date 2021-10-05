package model;
public class PaginatedRepository {

	private String type;
	private String next;
	private int page;
	private int pagelen;
	private String previous;
	private int size;
	private Repositorio[] values;
	private Object error;

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

	public Repositorio[] getValues() {
		return values;
	}

	public void setValues(Repositorio[] values) {
		this.values = values;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagelen() {
		return pagelen;
	}

	public void setPagelen(int pagelen) {
		this.pagelen = pagelen;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Repositorio[] getRepositorios() {
		return values;
	}

	public void setRepositorios(Repositorio[] repositorios) {
		this.values = repositorios;
	}

	public void mostrarRepositorios() {
		System.out.println(values.length);
		for (Repositorio r : this.values) {
			System.out.println(r.getName());
		}

	}
}