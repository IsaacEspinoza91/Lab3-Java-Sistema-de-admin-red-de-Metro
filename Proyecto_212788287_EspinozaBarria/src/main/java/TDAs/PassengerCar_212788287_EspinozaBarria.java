package TDAs;

/**
 * PassengerCar es una clase abstracta que representa un carro de tren para los trenes de un metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-14
 */
public abstract class PassengerCar_212788287_EspinozaBarria {

    //Atributos
    protected int id;
    protected int passengerCapacity;
    protected String model;
    protected String trainMaker;



    //Constructor

    /**
     * Constructor de un objeto PassangerCar. Como es clase abstracta no se puede inicializar, pero es utilizado en la
     * clase heredada.
     * Requerimiento Funcional 10
     * @param id Identificacion (int) de un carro de pasajeros
     * @param passengerCapacity Capacidad maxima (int) de un carro de pasajeros
     * @param model Modelo (String) de un carro de pasajeros
     * @param trainMaker Fabricante (String) de un carro de pasajeros
     */
    public PassengerCar_212788287_EspinozaBarria(int id, int passengerCapacity, String model, String trainMaker) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
    }

    //Metodos
    //Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getTrainMaker() {
        return trainMaker;
    }
    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }
}