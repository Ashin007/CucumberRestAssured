package stepdefinitions;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@dataDriven")
    public void beforeDataDriven(){
        System.out.println("before data driven");
    }
}
