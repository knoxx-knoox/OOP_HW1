/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;
import java.io.*;
import java.util.*;
/**
 *
 * @author knoxy
 */
public class GameManager {
    private Board _board;
    private List<Player> _players = new ArrayList<>();
    private List<Integer> _diceRolls = new ArrayList<>();
    public GameManager(Board b){
        _board = b;
    }
    public void addPlayer(Player p){
        _players.add(p);
    }
    /**
     * Runs the game until all dice rolls are used or only one player remains active, notice that the board is circular in this logic.
     */
    public void run() {
        int turn = 0;
        while (turn < _diceRolls.size() && aliveCount() > 1) {
            for (int i = 0; i < _players.size() && turn < _diceRolls.size() && aliveCount() > 1; i++) {
                Player p = _players.get(i);
                if (p.isActive()) {
                    int roll = _diceRolls.get(turn++);
                    System.out.println(p.getName() + " rolls " + roll);
                    p.move(roll, _board.size());
                    _board.getField(p.getPosition()).here(p, this);
                    p.print_this_each_round();
                }
            }
        }
        System.out.println("Game over");
    }

    /**
     * Counts the number of active players.
     * @return the number of active players
     */
    private int aliveCount() {
        int count = 0;
        for (Player p : _players){
            if (p.isActive()){
                count++;
            }
        }
        return count;
    }
    /**
     * Prints the final state of all players, indicating whether they have lost or their current status.
     */
    public void print_this_last(){
        System.out.println("Final state:");
        for (Player p : _players){
            if (p.isActive()){
                System.out.println(p.print_this_each_round());
            } else {
                System.out.println(p.getName() + " has LOST");
            }
        }
    }
    /**
     * Loads players from a specified file.
     * @param filename the name of the file containing player data
     * @return a list of players loaded from the file
     * @throws IOException if an I/O error occurs reading from the file
     * @throws FileNotFoundException if the file does not exist 
     */
    public static List<Player> loadPlayers(String filename) {
        List<Player> players = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            line = reader.readLine();
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String name = parts[0];
                    String strategy = parts[1];
                    players.add(new Player(name, strategy));
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + filename + " not found.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        
        return players;
    }
    /**
     * Loads dice rolls from a specified file.
     * @param filename the name of the file containing dice roll data
     * @return a list of dice rolls loaded from the file
     * @throws IOException if an I/O error occurs reading from the file
     * @throws FileNotFoundException if the file does not exist
     */
    public static List<Integer> loadDiceRolls(String filename) {
        List<Integer> diceRolls = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 1) {
                    for (String part : parts) {
                        try {
                            int roll = Integer.parseInt(part);
                            diceRolls.add(roll);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid dice roll: " + part);
                        }
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + filename + " not found.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        
        return diceRolls;
    }
    /**
     * Sets the dice rolls for the game.
     * @param rolls a list of integers representing the dice rolls
     */
    public void setDiceRolls(List<Integer> rolls){
        _diceRolls= new ArrayList<>(rolls);
    }
}
