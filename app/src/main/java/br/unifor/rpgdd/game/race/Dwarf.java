package br.unifor.rpgdd.game.race;

public class Dwarf extends Character {
    public Dwarf(int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super("Anão", force, dexterity, constitution, intelligence, wisdom, charisma);
    }

    @Override
    public int getConstitution() {
        return this.constitution + 1;
    }
}
