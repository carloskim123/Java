package Keywords.Final;

public class Dog extends Animal{
    private int walkDistancePreference;

    public void bark() {
        System.out.println("Woof");
    }

    public void eat() {
        System.out.println(FinalExample.pi * 3);
    }

    public int getWalkDistancePreference() {
        return walkDistancePreference;
    }

    public void setWalkDistancePreference(int walkDistancePreference) {
        this.walkDistancePreference = walkDistancePreference;
    }


}
