
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main{


    public static void main(String[] args) {
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);


        ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList Object

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);

        LinkedList<String> newMakes = new LinkedList<String>();

        newMakes.add("VoxWarden");
        newMakes.add("Subaru");

        System.out.println(newMakes);

        HashMap<String, String> capitalCities = new HashMap<String, String>();

        capitalCities.put("Nairobi", "London");
        capitalCities.put("Germany", "Europe");

        System.out.println(capitalCities);

        System.out.println(capitalCities.size());

        for (String i : capitalCities.keySet()) {
            System.out.println("Key: " + i + " value: " + capitalCities.get(i));
        }

        capitalCities.remove("Nairobi");


        System.out.println(capitalCities);

        capitalCities.clear();

        System.out.println(capitalCities);

        HashSet<String> oldMakes = new HashSet<String>();
        oldMakes.add("Wagons");
        oldMakes.add("Carts");

        for (String i : oldMakes) {
            System.out.println(i);
        }


        System.out.println(oldMakes);

        cars.remove("Carts");

        System.out.println(oldMakes);

        oldMakes.clear();

        System.out.println(oldMakes);


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it = numbers.iterator();


        numbers.removeIf( i -> i < 10);

        System.out.println(numbers);

    }



}