
public class Main{
    public static void main(String[] args) {

        CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(1);

        Saab95 saab1 = new Saab95();
 //       Saab95 saab2 = new Saab95();
        Volvo240 volvo = new Volvo240();

        saabWorkshop.turnInCar(saab1);
  //      saabWorkshop.turnInCar(saab2);
        //      saabWorkshop.turnInCar(volvo);

        System.out.println(saabWorkshop.getNrCars());

    }
}
