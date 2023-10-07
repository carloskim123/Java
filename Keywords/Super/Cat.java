package Keywords.Super;

public class Cat extends Animal{
    String catFoodPreferences;

    public Cat(int age, String name, String catFoodPreferences) {
        super(age, name);
        this.catFoodPreferences = catFoodPreferences;
    }
    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Meow meow meow");
        eat();

    }


}
