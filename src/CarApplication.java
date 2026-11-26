void main() {
    // Instance of this class
    CarController cc = new CarController();

    // TODO uncomment, and adapt if necessary
    cc.cars.add(new Volvo240(100,200));
    cc.cars.add(new Saab95(100,300));
    System.out.println(cc.cars);
    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();
}