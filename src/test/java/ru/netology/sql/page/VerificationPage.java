package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotify = $("[data-test-id=error-notification] .notification__content");

    public void errorNotifyCheck() {

        errorNotify.shouldHave(Condition.exactText("Ошибка! Неверно указан код! Попробуйте ещё раз.")).shouldBe(Condition.visible);
    }


    public VerificationPage() {

        codeField.shouldBe(Condition.visible);

    }

    public void verifyCode(String verificationCode) {

        codeField.setValue(verificationCode);
        verifyButton.click();
    }

    public DashboardPage validVerify(String verificationCode) {

        verifyCode(verificationCode);
        return new DashboardPage();

    }
}