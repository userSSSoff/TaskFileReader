// TODO: 11.02.2023
//  Реализовать readFile(). Логика проста...
//  Вытащить данные из текстового файла и записать их к объекту класса City.
//  Небольшая подсказказка можно использовать метод .split() класса String.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// TODO: 11.02.2023
//  После того как ты закончил предыдущий метод можешь приступить к следуещему.
//  Вся суть printAllCities() заключается в том, что надо вывести все города на консоль.
public class CityMethodsImpl implements CityMethods {


    @Override
    public City[] readFile() {
        City[] cities = new City[1109];
        try (FileReader fileReader = new FileReader("city_ru.csv")) {
            Scanner sc = new Scanner(fileReader);
            int i = 0;
            while (sc.hasNextLine()) {
                String[] file = sc.nextLine().split(";");
                City city = new City();
                city.setId(Integer.parseInt(file[0]));
                city.setName(file[1]);
                city.setRegion(file[2]);
                city.setDistrict(file[3]);
                city.setPopulation(Integer.parseInt(file[4]));
                try {
                    city.setFoundation(file[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    city.setFoundation(null);
                }
                cities[i] = city;
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    @Override
    public void printAllCities(City[] cities) {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    @Override
    public void groupByRegion(City[] cities) {
        String[] regions = new String[cities.length];
        int[] counters = new int[cities.length];

        int index = 0;
        for (City city : cities) {
            String region = city.getRegion();
            int regionIndex = findRegionIndex(regions, region);

            if (regionIndex == -1) {
                regions[index] = region;
                counters[index] = 1;
                index++;
            } else {
                counters[regionIndex]++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(regions[i] + " = " + counters[i]);
        }
    }

    @Override
    public void searchByName(String name) {
        City [] cities = readFile();
        for (int i = 0; i <cities.length ; i++) {
            if (name.equals(cities[i].getName())){
                System.out.println(cities[i]);
            }
        }
    }

    private static int findRegionIndex(String[] regions, String region) {
        for (int i = 0; i < regions.length; i++) {
            if (regions[i] != null && regions[i].equals(region)) {
                return i;
            }
        }
        return -1;
    }
    }


