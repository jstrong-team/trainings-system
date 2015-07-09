package exadel.jsTrong.forTrainings.controller;

public class Controller {
    private EmployeeController eci;
    private TrainingsController tci;

    public Controller() {
        eci = new EmployeeControllerImpl();
        tci = new TrainingsControllerImpl();
    }
}
