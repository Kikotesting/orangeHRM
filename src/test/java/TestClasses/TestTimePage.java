package TestClasses;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.TimePage;
import UtilityClasses.setupCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class TestTimePage extends setupCode {
    LoginPage actLP;
    DashboardPage actDashboard;
    TimePage actTime;

    @Test
    @DisplayName("Check available data for marked employee")
    public void searchSelectEmployee(){
        actLP = new LoginPage(browser);
        actDashboard = new DashboardPage(browser);
        actTime = new TimePage(browser);

        actLP.executeValidLogin();
        actDashboard.clickMenuTime();

        actTime.clickEmployeeField();
        actTime.setEmployeeName("Sara Tencrady");
        actTime.clickViewButton();
    }
}
