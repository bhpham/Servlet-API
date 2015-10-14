package net.mv.flashcard.domain;

public class CardUser {

	private long userId;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "CardUser [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
