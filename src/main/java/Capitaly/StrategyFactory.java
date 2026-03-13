/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class StrategyFactory {
    /**
     * Creates a strategy based on the provided type.
     * @param type The type of strategy to create ("CAREFUL", "GREEDY", "TACTICAL").
     * @return An instance of the corresponding Strategy subclass.
     * @throws IllegalArgumentException if the type is unknown.
     */
    public Strategy createStrategy(String type){
        switch (type.toUpperCase()) {
            case "CAREFUL":
                return new Careful();
            case "GREEDY":
                return new Greedy();
            case "TACTICAL":
                return new Tactical();
            default:
                throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }
}
