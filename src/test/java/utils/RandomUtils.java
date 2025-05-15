package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("ru"));

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomPhone() {
        return String.format("%s%s%s%s%s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(1, 9));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomSubject() {
        String[] subject = {"Math", "Biology", "English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies", "Arts", "History", "Physics", "Hindi", "Accounting"};
        return getRandomItemFromArray(subject);
    }

    public static String getRandomBirthDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    public static String getRandomBirthMonth() {
        String[] birthMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(birthMonths);
    }

    public static String getRandomBirthYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2020));
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomImage() {
        String[] images = {"image.png", "image1.jpg", "image2.jpeg", "image3.jpg"};
        return getRandomItemFromArray(images);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String city) {
        return switch (city) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("City not found: " + city);
        };

    }
}