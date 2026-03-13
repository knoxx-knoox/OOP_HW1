/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;
import java.util.*;
import java.io.*;
/**
 *
 * @author knoxy
 */
public class Board {
    private List<Field> _fields = new ArrayList<>();
    public int size() {
        return _fields.size();
    }
    public Field getField(int pos) {
        return _fields.get(pos);
    }
    /**
     * Loads a board configuration from a file.
     * The file format is number that we skip and each line that contains actual data as Field type and value.
     * Field types can be "PROPERTY", "SERVICE", or "LUCKY".
     * Example:
     * 3
     * PROPERTY 1000
     * For property fields 
     * SERVICE 500
     * LUCKY 1000
     * @param filename the name of the file to load the board configuration from
     * @return a Board object initialized with the fields from the file
     * @throws IOException if an I/O error occurs reading from the file
     * @throws FileNotFoundException if the file does not exist
     */
    public static Board load(String filename){
        Board board = new Board();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            line = br.readLine();
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                String type = parts[0];
                int value = Integer.parseInt(parts[1]);
                if(type.equals("PROPERTY")){
                    board._fields.add(new Property(board._fields.size(), value));
                } else if(type.equals("SERVICE")){
                    board._fields.add(new Service(board._fields.size(), value));
                } else if(type.equals("LUCKY")){
                    board._fields.add(new Lucky(board._fields.size(), value));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + filename + " not found.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        return board;
    }
}
