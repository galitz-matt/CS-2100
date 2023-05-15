public class Deck {
	private Card[] deck; //An Array of cards
	private int top  = 0; 
	
	public Deck() {
		deck = new Card[52];
		// Instantiate each individual card
		int i = 0;
		for (int r = 1; r <= 13; r++) {
			for(Card.Suit s : Card.Suit.values()) {
				deck[i] = new Card(r, s);
				i++;
			}
		}
		shuffle();
	}
	
	public void shuffle() {
		for (int i = 0; i < deck.length - 1 ; i++) {
			int r = (int)(Math.random()*(52-i)) + i;
			
			Card temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
	}
	
	public Card dealTopCard() {
		if (top >= deck.length) reStockDeck();
		
		top++;
		return deck[top - 1];
	}
	
	public void reStockDeck() {
		top = 0;
		shuffle();
	}
}
