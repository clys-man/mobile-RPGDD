package br.unifor.rpgdd.game.race;

public class Elf extends Character {
    public Elf(String name, int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, force, dexterity, constitution, intelligence, wisdom, charisma);
    }

    @Override
    public int getDexterity() {
        return this.dexterity + 1;
    }
}
