package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer{
	
	
	@Override
	public int getBet() {
		return 10;
	}

	@Override
	public Move getMove() {
		int dealerScore = this.dealer.getVisibleCard().getRank();
		if (17 <= this.handScore()) return Move.STAY;
		if (13 <= this.handScore() && this.handScore() <= 16) {
			if (2 <= dealerScore && dealerScore <= 6) return Move.STAY;
			else return Move.HIT;
		}
		if (this.handScore() == 12) {
			if (4 <= dealerScore && dealerScore <= 6) return Move.STAY;
			else return Move.HIT;
		}
		if (this.handScore() == 11) {
			if (2 <= dealerScore && dealerScore <= 10) return Move.DOUBLE;
			else return Move.HIT;
		}
		if (this.handScore() == 10) {
			if (2 <= dealerScore && dealerScore <= 9) return Move.DOUBLE;
			else return Move.HIT;
		}
		if (this.handScore() == 9) {
			if (3 <= dealerScore && dealerScore <= 9) return Move.DOUBLE;
			else return Move.HIT;
		}
		return Move.STAY;
	}
	
//	public Move getMove() {
//		int dealerScore = this.dealer.getVisibleCard().getRank();
//		if (17 <= this.handScore()) return Move.STAY;
//		if (13 <= this.handScore() && this.handScore() <= 16) {
//			if (2 <= dealerScore && dealerScore <= 6) return Move.STAY;
//			else return Move.HIT;
//		}
//		if (this.handScore() == 12) {
//			if (4 <= dealerScore && dealerScore <= 6) return Move.STAY;
//			else return Move.HIT;
//		}
//		if (this.handScore() == 11) {
//			if (2 <= dealerScore && dealerScore <= 10) return Move.DOUBLE;
//			else return Move.HIT;
//		}
//		if (this.handScore() == 10) {
//			if (2 <= dealerScore && dealerScore <= 9) return Move.DOUBLE;
//			else return Move.HIT;
//		}
//		if (this.handScore() == 9) {
//			if (3 <= dealerScore && dealerScore <= 9) return Move.DOUBLE;
//			else return Move.HIT;
//		}
//		return Move.HIT;
//	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process.
		 */
		
	}

	
}
