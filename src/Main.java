/**
 * УДАЧИ ТЕБЕ
 */
public class Main {
    public static void main(String[] args) {

        CityMethods cityMethods = new CityMethodsImpl();

        cityMethods.printAllCities(cityMethods.readFile());


    }
}