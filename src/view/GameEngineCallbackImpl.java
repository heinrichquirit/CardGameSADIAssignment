package view;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	private String time = Calendar.getInstance().getTime().toString();
	private String packageName = getClass().getCanonicalName();

	public GameEngineCallbackImpl() {
		// FINE shows dealing output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		// Logging details
		System.out.println(String.format("%s %s nextCard", time, packageName));

		// Player and Card details
		String playerInfo = String.format("Card Dealt to %s", player.getPlayerName());
		String seperator = " .. ";
		String cardInfo = String.format("Suit: %s, Value: %s, Score: %d", card.getSuit(), card.getValue(),
				card.getScore());

		// logger.log(Level.FINE, playerInfo + seperator + cardInfo);
		System.out.println(playerInfo + seperator + cardInfo);
	}

	public void result(Player player, int result, GameEngine engine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
		// TODO: complete this method to log results
	}

	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// Logging details
		System.out.println(String.format("%s %s nextCard", time, packageName));

		// Player and Card details
		String playerInfo = String.format("Card Dealt to %s", player.getPlayerName());
		String seperator = " .. ";
		String cardInfo = String.format("Suit: %s, Value: %s, Score: %d", card.getSuit(), card.getValue(), card.getScore());
		String bustInfo = " ... YOU BUSTED!";

		System.out.println(playerInfo + seperator + cardInfo + bustInfo);
	}

	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	public void houseResult(int result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	// TODO implement the rest of the GameEngineCallback interface
}
