package model;

import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private Collection<Player> players = new HashSet<Player>();
	private GameEngineCallbackImpl engineCallback = new GameEngineCallbackImpl();

	public void dealPlayer(Player player, int delay) {
		if (players.contains(player)) {
			for (Player p : players) {
				if (p.getPlayerId().equals(player.getPlayerId())) {

					// next card
					engineCallback.nextCard(player, new PlayingCardImpl(Suit.CLUBS, Value.ACE, 1), this);
					// bust card
				}
			}
		}
	}

	public void dealHouse(int delay) {

	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public Player getPlayer(String id) {
		for (Player p : players) {
			if (p.getPlayerId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public boolean removePlayer(Player player) {
		if (players.contains(player)) {
			players.remove(player);
			return true;
		}
		return false;
	}

	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {

	}

	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return false;
	}

	public Collection<Player> getAllPlayers() {
		return players;
	}

	public boolean placeBet(Player player, int bet) {
		return false;
	}

	public Deque<PlayingCard> getShuffledDeck() {
		return null;
	}

}
