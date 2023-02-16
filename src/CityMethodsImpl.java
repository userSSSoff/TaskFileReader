// TODO: 11.02.2023
//  Реализовать readFile(). Логика проста...
//  Вытащить данные из текстового файла и записать их к объекту класса City.
//  Небольшая подсказказка можно использовать метод .split() класса String.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// TODO: 11.02.2023
//  После того как ты закончил предыдущий метод можешь приступить к следуещему.
//  Вся суть printAllCities() заключается в том, что надо вывести все города на консоль.
public class CityMethodsImpl implements CityMethods {

    @Override
    public City[] readFile() {
        City[] cities = new City[1109];
        try {
            FileReader fileReader = new FileReader("city_ru.csv");
            Scanner scanner = new Scanner(fileReader);
            int i = 0;
            while (scanner.hasNext()) {
                String[] fileContent = scanner.nextLine().split(";");
                City city = new City();
                city.setId(Integer.parseInt(fileContent[0]));
                city.setName(fileContent[1]);
                city.setRegion(fileContent[2]);
                city.setDistrict(fileContent[3]);
                city.setPopulation(Integer.parseInt(fileContent[4]));
                try {
                    city.setFoundation(fileContent[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    city.setFoundation(null);
                    System.out.println(e.getMessage());
                }
                cities[i] = city;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void printAllCities(City[] cities) {
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }
    }

    @Override
    public void groupByRegion(City[] cities) {

    }

    @Override
    public void searchByName(String name) {

    }
}
