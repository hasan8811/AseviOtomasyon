package asevi.bl;

public class kullanici {
	public static int id;
	public static String username;
	public static String password;

	public kullanici() {

	}

	public kullanici(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
