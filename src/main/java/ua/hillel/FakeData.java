package ua.hillel;

import com.github.javafaker.Faker;

public class FakeData {
    public static void main(String[] args) {
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s %s %s%n", faker.name().firstName(), faker.name().lastName(), faker.name().bloodGroup());
        }
    }
}
