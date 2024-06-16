package TDAs;

/**
 * Driver es la abstraccion de un conductor de trenes en una red de metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-15
 */
public class Driver_212788287_EspinozaBarria {

    //Atributos
    private int id;
    private String name;
    private String trainMaker;


    //Constructor
    /**
     * Constructor de un objeto Driver de una red de metro.
     * Requerimiento Funcional 16
     * @param id Identificador (int) del conductor Driver
     * @param name Nombre (String) del conductor
     * @param trainMaker Frabricante de los trenes que sabe operar el conductor
     */
    public Driver_212788287_EspinozaBarria(int id, String name, String trainMaker) {
        this.id = id;
        this.name = name;
        this.trainMaker = trainMaker;
        System.out.println("\n --- Se creo exitosamente el objeto Driver ---\n");
    }



    //Metodos
    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTrainMaker() {
        return trainMaker;
    }
    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }



    @Override
    public String toString() {
        return "{ID: " + id + ", Nombre: " + name +", Fabricante:" + trainMaker + "}";
    }
}
