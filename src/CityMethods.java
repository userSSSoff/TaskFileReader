public interface CityMethods {
    City[] readFile();

    void printAllCities(City[] cities);

    void groupByRegion(City[] cities);

    void searchByName(String name);
}
