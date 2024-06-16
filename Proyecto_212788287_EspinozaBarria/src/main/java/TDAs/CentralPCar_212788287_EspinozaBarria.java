package TDAs;

/**
 * CentralPcar es una clase heredada de la clase PassengerCar, que representa un carro tipo central
 * de tren para los trenes de un metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-14
 */
public class CentralPCar_212788287_EspinozaBarria extends PassengerCar_212788287_EspinozaBarria{

    //Sin Atributos

    //Constructor
    /**
     * Constructor de objeto carro de pasajeros tipo central
     * @param id Identificacion (int) de un carro de pasajeros
     * @param passengerCapacity Capacidad maxima (int) de un carro de pasajeros
     * @param model Modelo (String) de un carro de pasajeros
     * @param trainMaker Fabricante (String) de un carro de pasajeros
     */
    public CentralPCar_212788287_EspinozaBarria(int id, int passengerCapacity, String model, String trainMaker) {
        super(id, passengerCapacity, model, trainMaker);
    }

    //Metodos
    @Override
    public String toString() {
        return "CentralPCar{" +
                "id=" + id +
                ", passengerCapacity=" + passengerCapacity +
                ", model='" + model + '\'' +
                ", trainMaker='" + trainMaker + '\'' +
                '}';
    }
}
