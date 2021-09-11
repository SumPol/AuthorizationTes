package ru.mirapolis;

import java.util.Arrays;

public class ParametersLoginPage {
    private static String correctLogin = "fominaelena";
    private static String correctPassword = "z0K6CTQR";

    public static Iterable<Object[]> getDataForTest() {
        return Arrays.asList(new Object[][]{
                {correctLogin, correctPassword, true, "Right login & password"},
                {"", "", false, "Empty fields"},
                {correctLogin, "", false, "Empty password"},
                {"", correctPassword, false, "Empty login"},
                {correctLogin, "123456", false, "Wrong password"},
                {"falselogin", correctPassword, false, "Wrong login"},
        });
    }
}
