package br.unifor.rpgdd.game.dice;

public class DiceDraw {
    private final static int MAX_RELEASES = 3;

    public static int draws() {
        Dice dice = new Dice();
        int result = 0;

        for (int i = 0; i < MAX_RELEASES; i++) {
            result += dice.roll();
        }

        return result;
    }
}
