/*import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Carstest {

    @Test
    public void testMove() {
        Volvo240 v = new Volvo240();
        v.startEngine();
        assertEquals(0.1, v.getCurrentSpeed());
    }

    @Test
    public void testRight() {
        Saab95 s = new Saab95();
        s.startEngine();
        s.turnRight();
        assertEquals("East", s.getDirection());
    }

    //@Test
    //public void testGas() {
    //    Volvo240 v = new Volvo240();
    //    v.startEngine();
    //    assertThrows(IllegalAccessException.class, () -> v.gas(2));
    //    assertNotEquals(2.1 ,v.getCurrentSpeed());
    //}

    @Test
    public void testRTBcorrect() {
        ScaniaTruck s = new ScaniaTruck();
        s.raiseTruckBed(60);
        assertEquals(60, s.CargoTruck.getAngle());
    }

    @Test
    public void testRTBerror() {
        ScaniaTruck s = new ScaniaTruck();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> s.raiseTruckBed(90));
        assertEquals("Invalid integer. Must be within the limits 0-70", exception.getMessage());    }

    @Test
    public void testRTBmove() {
        ScaniaTruck s = new ScaniaTruck();
        s.startEngine();
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> s.raiseTruckBed(60));
        assertEquals("Truck must be stationary to raise or lower the truckbed", exception.getMessage());
    }
    @Test
    public void testRTBAlreadyRaised() {
        ScaniaTruck s = new ScaniaTruck();
        s.raiseTruckBed((60));
        s.raiseTruckBed(20);
        assertEquals(70, s.CargoTruck.getAngle());
    }

    @Test
    public void testLoadCarmoving() {
        CarTransport b = new CarTransport(6);
        Saab95 s = new Saab95();
        b.startEngine();
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> b.loadCar(s));
        assertEquals("Truck must be both stationary and with the truckbed lowered to load cars.", exception.getMessage());
    }

    @Test
    public void testLoadBiltransport() {
        CarTransport b = new CarTransport(6);
        CarTransport s = new CarTransport(4);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> b.loadCar(s));
        assertEquals("Cannot load vehicle transports", exception.getMessage());
    }

    @Test
    public void testLoadCar() {
        CarTransport b = new CarTransport(6);
        Volvo240 v = new Volvo240();
        Saab95 s = new Saab95();
        b.loadCar(s);
        b.loadCar(v);
        assertEquals(v, b.cargo.get(1));
    }

    @Test
    public void testMoveCargo() {
        CarTransport b = new CarTransport(6);
        Volvo240 v = new Volvo240();
        b.loadCar(v);
        b.startEngine();
        b.turnRight();
        b.move();
        b.move();
        b.move();
        b.move();
        b.move();
        b.move();
        b.move();
        assertEquals(0.7, v.getX());
    }

    @Test
    public void testUnLoad() {
        CarTransport b = new CarTransport(6);
        Volvo240 v = new Volvo240();
        Saab95 s = new Saab95();
        b.loadCar(v);
        b.loadCar(s);
        b.raiseTruckBed();
        b.startEngine();
        b.move();
        b.move();
        b.stopEngine();
        b.lowerTruckBed();
        b.unLoadCar();
        assertEquals(5.2, s.getY());
        assertEquals(v, b.cargo.get(0));
    }
}*/