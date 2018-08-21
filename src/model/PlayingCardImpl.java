package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {

	private Suit suit;
	private Value value;
	private int score;

	public PlayingCardImpl() {
		suit = null;
		value = null;
		score = 0;
	}

	public PlayingCardImpl(Suit suit, Value value, int score) {
		this.suit = suit;
		this.value = value;
		this.score = score;
	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}

	public int getScore() {
		return score;
	}

	public boolean equals(PlayingCard card) {
		return false;
	}

}
