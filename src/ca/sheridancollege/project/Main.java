/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author User
 */
// Main.java
// Main.java
public class Main {
    public static void main(String[] args) {
        GoFishGame game = new GoFishGame("Go Fish Game");

        game.getPlayers().add(new GoFishPlayer("Player 1"));
        game.getPlayers().add(new GoFishPlayer("Player 2"));

        game.play();
    }
}


