package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("ru"));

    public static void main(String[] args) {
//        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(111, 99999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomBirthDay());
        System.out.println(getRandomBirthMonth());
        System.out.println(getRandomBirthYear());
        System.out.println(getRandomSubject());
        System.out.println(getRandomHobby());
        System.out.println(getRandomState());
        System.out.println(getRandomState());
    }

//    public static String getRandomString(int len) {
////        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom rnd = new SecureRandom();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < len; i++)
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//
//        return sb.toString();
//    }


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
        String[] hobbies = {"Sport", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
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