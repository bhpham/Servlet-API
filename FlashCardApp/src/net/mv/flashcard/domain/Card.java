package net.mv.flashcard.domain;

public class Card {
	
	private long cardId;
	private String question;
	private String answer;
	private CardUser user;
	
	
	
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", question=" + question
				+ ", answer=" + answer + ", user=" + user + "]";
	}

	public long getCardId() {
		return cardId;
	}


	public void setCardId(long cardId) {
		this.cardId = cardId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public CardUser getUser() {
		return user;
	}

	public void setUser(CardUser user) {
		this.user = user;
	}
	
	
	
}
