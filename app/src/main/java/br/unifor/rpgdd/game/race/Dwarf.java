package br.unifor.rpgdd.game.race;

public class Dwarf extends Character {
    public Dwarf(String name, int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(name, force, dexterity, constitution, intelligence, wisdom, charisma);
    }

    @Override
    public int getConstitution() {
        return this.constitution + 1;
    }
}
