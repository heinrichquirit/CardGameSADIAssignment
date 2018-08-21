package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private int result;

	public SimplePlayer() {
		playerId = "";
		playerName = "";
		points = 0;
	}

	public SimplePlayer(String playerId, String playerName, int points) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = points;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public String getPlayerId() {
		return playerId;
	}

	public boolean placeBet(int bet) {
		return bet > 0 ? true : false;
	}

	public int getBet() {
		return bet;
	}

	public void resetBet() {
		bet = 0;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}

}
