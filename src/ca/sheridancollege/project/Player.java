/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * @author Denish Maisuriya
 */
public abstract class Player 
{
    private String name;
    private int score;

    public Player(String name) 
    {
        this.name = name;
        this.score = 0;
    }

    public String getName() 
    {
        return name;
    }

    public int getScore() 
    {
        return score;
    }

    public void setScore(int score) 
    {
        this.score = score;
    }

    public abstract void play();
}
