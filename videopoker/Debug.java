package videopoker;

import java.io.File;                                            // Import the File class
import java.io.FileNotFoundException;                           // Import this class to handle errors
import java.util.Scanner;                                       // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;

public class Debug extends VideoPoker {
    private List<String> comand_List;
    private int comand_idx;

    public Debug(Deck deck, Player player, String comand_file) {
        super(deck, player);

        this.comand_idx = 0;

        comand_List = new ArrayList<String>();
        String comand = new String();

        try {
            File myObj = new File(comand_file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.next();
                if (myReader.hasNextInt()) {
                    comand = comand + data + " ";
                } else {
                    comand = comand + data;
                    this.comand_List.add(comand);
                    comand = new String();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred reading commands file");
            e.printStackTrace();
        }
        this.comand_List.add("e");
    }

    String get_command() {
        return this.comand_List.get(this.comand_idx++);
    }

    void reset_deck() {
		int num = this.played_cards.get_cards().size();
		for (int i=0; i<num; i++) {
			this.played_cards.remove_card(0);
        }
	}
}