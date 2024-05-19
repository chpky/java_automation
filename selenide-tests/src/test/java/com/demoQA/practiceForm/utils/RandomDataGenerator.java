package com.demoQA.practiceForm.utils;

import com.github.javafaker.Faker;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class RandomDataGenerator {
    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final Map<String, List<String>> stateCityMap = new HashMap<>();
    static {
        stateCityMap.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        stateCityMap.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        stateCityMap.put("Haryana", Arrays.asList("Karnal", "Panipat"));
        stateCityMap.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
    }
    static Faker faker = new Faker();
    private static File file;
    private static final Random RANDOM = new Random();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return "7" + faker.number().numberBetween(800000000, 999999999);
    }

    public static String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getRandomMonth() {
        return MONTHS[RANDOM.nextInt(MONTHS.length)];
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1970, LocalDate.now().getYear()));
    }

    public static File getRandomPngFile() {
        BufferedImage bufferedImage = new BufferedImage(RANDOM.nextInt(1920), RANDOM.nextInt(1080), BufferedImage.TYPE_INT_ARGB);
        file = new File(faker.file().fileName("src/test/resources/pictures", faker.lorem().word().toLowerCase(), "png", null));

        try {
            ImageIO.write(bufferedImage, "png", file);
            System.out.println("PNG file created successfully: " + file.getPath());
        } catch (IOException e) {
            System.err.println("Error while saving empty PNG file: " + e.getMessage());
        }
        return file;
    }

    public static void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get(file.getPath()));
            System.out.println("File deleted successfully: " + file.getPath());
        } catch (IOException e) {
            System.err.println("Error while deleting file: " + e.getMessage());
        }
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomState() {
        List<String> states = new ArrayList<>(stateCityMap.keySet());
        return states.get(RANDOM.nextInt(states.size()));
    }

    public static String getRandomCity(String state) {
        List<String> cities = stateCityMap.get(state);
        if (cities == null) {
            throw new IllegalArgumentException("Invalid state: " + state);
        }
        return cities.get(RANDOM.nextInt(cities.size()));
    }
}
