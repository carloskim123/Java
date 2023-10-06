package Lambda;

public class Lambdas{
    public static void main(String[] args) {

        Printable lambdaPrintable = s -> System.out.println("Meoow" + s);
        printThing(lambdaPrintable);
    }
    static void printThing(Printable thing) {
        thing.print(null);
    }
}
