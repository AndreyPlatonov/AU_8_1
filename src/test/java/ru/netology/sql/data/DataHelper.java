package ru.netology.sql.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private final static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static String randomLogin() {

        return faker.name().username();
    }

    public static String randomPassword() {

        return faker.internet().password();
    }

    public static VerificationCode randomToken() {

        return new VerificationCode(faker.numerify("#######"));
    }

    public static AuthInfo randomUser() {

        return new AuthInfo(randomLogin(), randomPassword());

    }

    @Value
    public static class AuthInfo {
        public String login;
        public String password;
    }

    @Value
    public static class VerificationCode {
        public String code;
    }
}
