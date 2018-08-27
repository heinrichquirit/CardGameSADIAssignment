package model;

import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private HashSet<PlayingCard> deck = new HashSet<PlayingCard>();
	private volatile Collection<Player> players = new HashSet<Player>();
	private volatile Collection<GameEngineCallback> gameEngineCallbacks = new HashSet<GameEngineCallback>();
	private GameEngineCallback gameEngineCallback;

	private int suitMin = 0;
	private int suitMax = 3;
	private int valueMin = 0;
	private int valueMax = 12;
	
	public GameEngineImpl() {
		// populate deck
		
	}

	@Override
	public void dealPlayer(Player player, int delay) {
		try {
			int result = 0;
			while (result <= GameEngine.BUST_LEVEL) {
				// deal card to player

				int randomSuit = ThreadLocalRandom.current().nextInt(suitMin, suitMax + 1);
				int randomValue = ThreadLocalRandom.current().nextInt(valueMin, valueMax + 1);
				int cardScore = 0;
				Value v = Value.values()[randomValue];
				
				switch(v) {
					case ACE:
						cardScore = 1;
						break;
					case TWO:
						cardScore = 2;
						break;
					case THREE:
						cardScore = 3;
						break;
					case FOUR:
						cardScore = 4;
						break;
					case FIVE:
						cardScore = 5;
						break;
					case SIX:
						cardScore = 6;
						break;
					case SEVEN:
						cardScore = 7;
						break;
					case EIGHT:
						cardScore = 8;
						break;
					case NINE:
						cardScore = 9;
						break;
					case TEN:
						cardScore = 10;
						break;
					case JACK:
						cardScore = 10;
						break;
					case QUEEN:
						cardScore = 10;
						break;
					case KING:
						cardScore = 10;
						break;
					default:
						cardScore = 0;
						break;
				}
				
				// Generate random card
				PlayingCard playingCard = new PlayingCardImpl(Suit.values()[randomSuit], Value.values()[randomValue], cardScore);
				result = result += cardScore;
				gameEngineCallback.nextCard(player, playingCard, this);
				if (result >= GameEngine.BUST_LEVEL) {
					System.out.println("BUSTED");
					gameEngineCallback.bustCard(player, playingCard, this);
					gameEngineCallback.result(player, result, this);
					System.exit(0);
				}
				Thread.sleep(delay);
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dealHouse(int delay) {
		try {
			int result = 0;
			while (result <= GameEngine.BUST_LEVEL) {
				// deal card to player

				int randomSuit = ThreadLocalRandom.current().nextInt(suitMin, suitMax + 1);
				int randomValue = ThreadLocalRandom.current().nextInt(valueMin, valueMax + 1);
				int cardScore = 0;
				Value v = Value.values()[randomValue];
				
				switch(v) {
					case ACE:
						cardScore = 1;
						break;
					case TWO:
						cardScore = 2;
						break;
					case THREE:
						cardScore = 3;
						break;
					case FOUR:
						cardScore = 4;
						break;
					case FIVE:
						cardScore = 5;
						break;
					case SIX:
						cardScore = 6;
						break;
					case SEVEN:
						cardScore = 7;
						break;
					case EIGHT:
						cardScore = 8;
						break;
					case NINE:
						cardScore = 9;
						break;
					case TEN:
						cardScore = 10;
						break;
					case JACK:
						cardScore = 10;
						break;
					case QUEEN:
						cardScore = 10;
						break;
					case KING:
						cardScore = 10;
						break;
					default:
						cardScore = 0;
						break;
				}
				
				// Generate random card
				PlayingCard playingCard = new PlayingCardImpl(Suit.values()[randomSuit], Value.values()[randomValue], cardScore);
				result = result += cardScore;
				gameEngineCallback.nextHouseCard(playingCard, this);
				if (result >= GameEngine.BUST_LEVEL) {
					System.out.println("BUSTED");
					gameEngineCallback.houseBustCard(playingCard, this);
					gameEngineCallback.houseResult(result, this);
					System.exit(0);
				}
				Thread.sleep(delay);
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player p : players) {
			if (p.getPlayerId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		if (players.contains(player)) {
			players.remove(player);
			return true;
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallback = gameEngineCallback;
		gameEngineCallbacks.add(this.gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (gameEngineCallbacks.contains(gameEngineCallback)) {
			gameEngineCallbacks.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return false;
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() {
		return null;
	}

}
