package edu.craptocraft.draw;

import edu.craptocraft.raffle.Entry;
import edu.craptocraft.raffle.Raffle;

public class GUI {

    public GUI(){}
    public static void drawSneaker(Raffle sneaker) {
        System.out.println(
                "\t\t" + " _    _" + "\n" +
                        "\t\t" + "(_\\__/(,_" + "\n" +
                        "\t\t" + "| \\ `_////-._" + "\n" +
                        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
                        "\t\t" + "|=====;__/___./" + "\n" +
                        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
                        "\t\t" + sneaker.toString());
    }

    public static void drawEntry(Entry entry) {
        System.out.println(entry.toString());
    }

    public static void drawWinner(Entry winner) {
        System.out.println("\t\t¡¡ You are the winner !! \n" +
                winner.toString());
    }
}
