package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("ru"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomSubject() {
        return faker.options().option("Math", "Biology", "English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies", "Arts", "History", "Physics", "Hindi", "Accounting");
    }

    public static String getRandomBirthDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    public static String getRandomBirthMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomBirthYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2020));
    }

    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomImage() {
        return faker.options().option("image.png", "image1.jpg", "image2.jpeg", "image3.jpg");
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

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