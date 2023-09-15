package Classes;

class Params {
    int modelYear;
    String modelName;

    public Params(int year, String name) {
        modelYear = year;
        modelName = name;
    }

    public static void main(String[] args) {
        Params myCar = new Params(1969, "Mustang");
        System.out.println(myCar.modelYear + " " + myCar.modelName);
    }
}



