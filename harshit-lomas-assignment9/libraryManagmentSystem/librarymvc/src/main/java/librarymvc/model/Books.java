package librarymvc.model;

public class Books {
	
	private int id;
	private String name;
	private String dateadded;
	private String author;
	
	public Books() {
		
	}
	
	public Books(int id, String name, String dateadded, String author) {
		this.id = id;
		this.name = name;
		this.dateadded = dateadded;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateadded() {
		return dateadded;
	}

	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", dateadded=" + dateadded + ", author=" + author + "]";
	}
	
}
