package br.unifor.rpgdd.game.race;

public class HalfGiant extends Character {
    public HalfGiant(int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super("Meio-Gigante", force, dexterity, constitution, intelligence, wisdom, charisma);
    }

    @Override
    public int getConstitution() {
        return this.constitution + 2;
    }

    @Override
    public int getCharisma() {
        return this.charisma - 1;
    }
}
