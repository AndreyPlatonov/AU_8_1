package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static SelenideElement loginField = $("[data-test-id=login] input");
    private final static SelenideElement passwordField = $("[data-test-id=password] input");
    private final static SelenideElement loginButton = $("[data-test-id=action-login].button");
    private final static SelenideElement errorNotify = $("[data-test-id=error-notification] .notification__content");


    public void errorNotifyCheck() {

        errorNotify.shouldHave(Condition.exactText("Ошибка! Неверно указан логин или пароль")).shouldBe(Condition.visible);

    }

    public VerificationPage validLogin(DataHelper.AuthInfo infoClient) {

        loginInput(infoClient);
        return new VerificationPage();

    }

    public void loginInput(DataHelper.AuthInfo infoClient) {
        loginField.setValue(infoClient.getLogin());
        passwordField.setValue(infoClient.getPassword());
        loginButton.click();

    }


}



