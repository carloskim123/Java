package Generics;

public class Printer <T, V> {
    T thingToPrint;
    V otherThingToPrint;
    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }

}
