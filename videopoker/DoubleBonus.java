package videopoker;

public class DoubleBonus {

	void credit_player(Player player, Deck hand, int bet, String str) {
		int earnings;
		if (str == "RF") {
			if (bet == 5)
				earnings = 4000;
			else
				earnings = 250 * bet;
			player.add_credit(earnings);
		} else if (str == "SF") {
			earnings = 50 * bet;
			player.add_credit(earnings);
		} else if (str == "FoaK") {
			if (hand.get_cards().get(1).get_rank() == 1)
				earnings = 160 * bet;
			else if (hand.get_cards().get(1).get_rank() <= 4)
				earnings = 80 * bet;
			else
				earnings = 50 * bet;
			player.add_credit(earnings);
		} else if (str == "FH") {
			earnings = 10 * bet;
			player.add_credit(earnings);
		} else if (str == "F") {
			earnings = 7 * bet;
			player.add_credit(earnings);
		} else if (str == "S") {
			earnings = 5 * bet;
			player.add_credit(earnings);
		} else if (str == "ToaK") {
			earnings = 3 * bet;
			player.add_credit(earnings);
		} else if (str == "TP") {
			earnings = bet;
			player.add_credit(earnings);
		} else if (str == "JOB") {
			earnings = bet;
			player.add_credit(earnings);
		}
	}

}
