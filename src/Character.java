import java.util.Random;

abstract public class Character {
    private int defense;
    private int attack;
    private int HP;

    public Character(int defense, int attack, int HP) {
        this.defense = defense;
        this.attack = attack;
        this.HP = HP;
    }


    public double getRandomNumber() {
        return 1 + (10 - 1) * new Random().nextDouble();
    }

    abstract public boolean attack();

    public void receiveDamage(int damage) {
        int damageReceived = 0;

        if (damage > defense) {
            damageReceived = attack - defense;
        }

        int currentHP = getHP() - damageReceived;

        setHP(Math.max(0, currentHP));
    }

    public void info() {
        System.out.println("----- STATUS -----");
        System.out.println("Role\t: " + getClass().getSimpleName());
        System.out.println("HP\t\t: " + getHP());
        System.out.println("Attack\t: " + getAttack());
        System.out.println("Defense\t: " + getDefense());
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
