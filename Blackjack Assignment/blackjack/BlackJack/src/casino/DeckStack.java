package casino;

public class DeckStack {
	
	private Deck[] decks;
	int topCard = 0;
	int deckIndex = 0;
	
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		for (int i = 0; i < numDecks; i++) decks[i] = new Deck();
	}
	
	public Card dealTopCard() {
		if (topCard == 52) {
			topCard = 0;
			deckIndex++;
		}
		if (deckIndex == decks.length) {
			deckIndex = 0;
			restoreDecks();
		}
		topCard++;
		return decks[deckIndex].dealTopCard();
	}
	
	protected void restoreDecks() {
		for (Deck d : decks) d.restockDeck();
	}
	
	public int cardsLeft() {
		return (decks.length * 52) - (topCard + (deckIndex * 52));
	}

}