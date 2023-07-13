package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public DashboardPage() {

        SelenideElement dashboardHeading = $("[data-test-id=dashboard]");
        dashboardHeading.shouldHave(Condition.exactText("Личный кабинет")).shouldBe(Condition.visible);

    }

}
