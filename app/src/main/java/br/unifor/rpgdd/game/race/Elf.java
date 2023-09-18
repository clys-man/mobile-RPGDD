package br.unifor.rpgdd.game.race;

public class Elf extends Character {
    public Elf(int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super("Elfo", force, dexterity, constitution, intelligence, wisdom, charisma);
    }

    @Override
    public int getDexterity() {
        return this.dexterity + 1;
    }
}
