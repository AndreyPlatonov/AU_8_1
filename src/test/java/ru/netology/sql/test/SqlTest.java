package ru.netology.sql.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.sql.data.DataHelper;
import ru.netology.sql.data.SQLHelper;
import ru.netology.sql.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class SqlTest {

    @AfterAll
    static void cleanDb() {

        SQLHelper.cleanDatabase();

    }

    @Test
    public void shouldBeSuccessLogin() {

        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());

    }

    @Test

    public void shouldBeFailedRandomUserLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.randomUser();
        loginPage.loginInput(authInfo);
        loginPage.errorNotifyCheck();

    }

    @Test
    public void shouldBeRandomTokenLoginFailed() {

        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.randomToken();
        verificationPage.verifyCode(verificationCode.getCode());
        verificationPage.errorNotifyCheck();

    }

}
