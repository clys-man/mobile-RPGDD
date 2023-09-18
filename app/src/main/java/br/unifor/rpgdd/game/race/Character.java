package br.unifor.rpgdd.game.race;

abstract public class Character {
    protected String name;
    protected int force;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;

    public Character(String name, int force, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public double calculateHp() {
        return Math.ceil(this.constitution * 3.5);
    }

    public String getName() {
        return this.name;
    }

    public int getForce() {
        return this.force;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\n" +
                "HP: " + String.format("%.2f", this.calculateHp()) + "\n" +
                "Força: " + this.force + "\n" +
                "Destreza: " + this.dexterity + "\n" +
                "Constituição: " + this.constitution + "\n" +
                "Inteligência: " + this.intelligence + "\n" +
                "Sabedoria: " + this.wisdom + "\n" +
                "Carisma: " + this.charisma + "\n";
    }
}
