public class Card {
	
	public enum Suit {
		Hearts, Diamonds, Spades, Clubs 
	}
	
	private int rank;
	private Suit suit;
	
	public Card() {
		this.rank = 1;
		this.suit = Suit.Spades; 
	}
	
	public Card(int rank, Suit suit) {
		this.setRank(rank);
		setSuit(suit);
	}
	
	public int getRank() { return this.rank; }
	public Suit getSuit() { return this.suit; }
	
	public void setRank(int newRank) {
		if (newRank < 1 || newRank > 13) return;
		
		this.rank = newRank;
	}
	
	public void setSuit(Suit newSuit) {
		this.suit = newSuit;
	}
	
	@Override
	public String toString() {
		String rank = "";
		switch(this.rank) {
		case 11 :
			rank = "Jack";
			break;
		case 12 :
			rank = "Queen";
			break;
		case 13:
			rank = "King";
			break;
		case 14 :
			rank = "Ace";
			break;
		}
		return  rank + " of " + this.suit;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Card)) { // Check if object types match
			return false;
		}
		
		Card otherCard = (Card) other; // other is an object, but it must be treated as card, might be instance of other object, must cast
		return otherCard.rank == this.rank && otherCard.suit == this.suit; // "==" can be used for enum because data refers to same memory location
	}
	
	
	public static void main(String[] args) {

		}
}

