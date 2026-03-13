/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Capitaly;

import java.io.*;
import java.util.*;

/**
 *
 * @author knoxy
 */
public class Main {

    public static void main(String[] args) {
        String data = "data.txt";
        String players = "players.txt";
        String dice = "dice_roll.txt";
        Board board = Board.load(data);
        GameManager gameManager = new GameManager(board);
        for (Player p : GameManager.loadPlayers(players)) {
            gameManager.addPlayer(p);
        }
        gameManager.setDiceRolls(GameManager.loadDiceRolls(dice));
        gameManager.run();
        gameManager.print_this_last();
    }
}
