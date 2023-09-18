package br.unifor.rpgdd.game.dice;

public class Dice {
    private int faces;

    public Dice() {
        this.faces = 6;
    }

    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll() {
        return (int) (Math.random() * this.faces) + 1;
    }
}
