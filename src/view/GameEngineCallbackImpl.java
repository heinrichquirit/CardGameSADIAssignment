package view;

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

	public GameEngineCallbackImpl() {
		// FINE shows dealing output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		// player and Card details
		String playerInfo = String.format("%s %s", "Card dealt to ", player.getPlayerName());
		String seperator = " .. ";
		String cardInfo = String.format("%s %s, %s %s, %s %d", 
										"Suit :", card.getSuit(), 
										"Value : ", card.getValue(), 
										"Score :", card.getScore());

		logger.log(Level.INFO, String.format("%s%s%s", playerInfo, seperator, cardInfo));
	}

	public void result(Player player, int result, GameEngine engine) {
		logger.log(Level.INFO, String.format("%s,%s%d", player.getPlayerName(), " final result=", result));
	}

	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// player and card details
		String playerInfo = String.format("%s%s", "Card dealt to ", player.getPlayerName());
		String seperator = " .. ";
		String cardInfo = String.format("%s%s,%s%s,%s%d", 
									"Suit :", card.getSuit(), 
									"Value :", card.getValue(),
									"Score: ", card.getScore());
		
		String bustInfo = " ... YOU BUSTED!";

		logger.log(Level.FINE, String.format("%s%s%s%s", playerInfo, seperator, cardInfo, bustInfo));
	}

	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// player and Card details
		String houseInfo = String.format("%s", "Card dealt to house");
		String seperator = " .. ";
		String cardInfo = String.format("%s %s, %s %s, %s %d", 
										"Suit :", card.getSuit(), 
										"Value : ", card.getValue(), 
										"Score :", card.getScore());

		logger.log(Level.FINE, String.format("%s%s%s", houseInfo, seperator, cardInfo));
	}

	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// player and card details
		String houseInfo = String.format("%s", "Card dealt to house");
		String seperator = " .. ";
		String cardInfo = String.format("%s%s,%s%s,%s%d", 
									"Suit :", card.getSuit(), 
									"Value :", card.getValue(),
									"Score: ", card.getScore());
				
		String bustInfo = " ... HOUSE BUSTED!";

		logger.log(Level.FINE, String.format("%s%s%s%s", houseInfo, seperator, cardInfo, bustInfo));
	}

	public void houseResult(int result, GameEngine engine) {
		logger.log(Level.INFO, String.format("%s%d", "House, final result=", result));
	}

	// TODO implement the rest of the GameEngineCallback interface
}
