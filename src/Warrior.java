public class Warrior extends Character{
    public Warrior(){
        super(80, 25, 30);
    }

    @Override
    public boolean attack() {
        return 1 <= getRandomNumber() && getRandomNumber() <= (0.6 * 10);
    }
}
