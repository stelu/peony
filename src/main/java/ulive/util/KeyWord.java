package ulive.util;

public class KeyWord{
	
	private int id;
	private String Name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "KeyWord [id=" + id + ", Name=" + Name + "]";
	}
	
}
