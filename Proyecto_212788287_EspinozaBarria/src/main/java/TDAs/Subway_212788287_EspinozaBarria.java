package TDAs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Subway es la abstraccion de una red de metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-15
 */
public class Subway_212788287_EspinozaBarria {

    //Atributos
    private int id;
    private String name;
    private List<Train_212788287_EspinozaBarria> trains = new ArrayList<>();
    private List<Line_212788287_EspinozaBarria> lines = new ArrayList<>();
    private List<Driver_212788287_EspinozaBarria> drivers = new ArrayList<>();
    private List<AsignacionTrainLine_212788287_EspinozaBarria> asignacionesTrainLine = new ArrayList<>();
    private List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDriverTrain  = new ArrayList<>();



    //Constructor
    /**
     * Constructor de un objeto Subway o red de metro.
     * Requerimiento Funcional 17
     * @param id Identificador (int) del Subway
     * @param nombre Nombre (String) del Subway
     */
    public Subway_212788287_EspinozaBarria(int id, String nombre) {
        this.id = id;
        this.name = nombre;
        System.out.println("\n --- Se creo exitosamente el objeto Subway ---\n");
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

    public List<Train_212788287_EspinozaBarria> getTrains() {
        return trains;
    }
    public void setTrains(List<Train_212788287_EspinozaBarria> trains) {
        this.trains = trains;
    }

    public List<Line_212788287_EspinozaBarria> getLines() {
        return lines;
    }
    public void setLines(List<Line_212788287_EspinozaBarria> lines) {
        this.lines = lines;
    }

    public List<Driver_212788287_EspinozaBarria> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver_212788287_EspinozaBarria> drivers) {
        this.drivers = drivers;
    }

    public List<AsignacionTrainLine_212788287_EspinozaBarria> getAsignacionesTrainLine() {
        return asignacionesTrainLine;
    }
    public void setAsignacionesTrainLine(List<AsignacionTrainLine_212788287_EspinozaBarria> asignacionesTrainLine) {
        this.asignacionesTrainLine = asignacionesTrainLine;
    }

    public List<RecorridoDriverTrain_212788287_EspinozaBarria> getRecorridosDriverTrain() {
        return recorridosDriverTrain;
    }
    public void setRecorridosDriverTrain(List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDriverTrain) {
        this.recorridosDriverTrain = recorridosDriverTrain;
    }



    //Otros metodos
    /**
     * Agrega un tren al Subway. En el caso de que el tren exista en el subway, no se agrega y se imprime en pantalla
     * un mensaje indicando tren repetido.
     * Requerimiento Funcional 18
     * @param train Tren (Train) a agregar
     */
    public void addTrain(Train_212788287_EspinozaBarria train) {
        if(!trains.contains(train) && train.isTrain()) {
            trains.add(train);
            System.out.println("\n --- Se agrego exitosamente el tren al metro en addTrain ---\n");
        }else{
            System.out.println("El tren ingresado ya existe en el Subway. No se agrego el tren.");
        }
    }

    /**
     * Agrega un lista de trenes al Subway. En caso de que algun tren ya exista en el subway, no se
     * agrega y se imprime en pantalla un mensaje indicando tren repetido.
     * Requerimiento Funcional 18. Notar sobrecarga y polimorfismo en tiempo de compilacion
     * @param listaTrenesIngresar Lista de Trenes (List&lt;Train&gt;) a ingresar
     */
    public void addTrain(List<Train_212788287_EspinozaBarria> listaTrenesIngresar){
        for(Train_212788287_EspinozaBarria trenActual : listaTrenesIngresar){
            addTrain(trenActual);
            System.out.println("\n --- Se agrego exitosamente el tren al metro en addTrain ---\n");
        }
    }

    /**
     * Agrega una linea al Subway. En caso de linea ya existente en el subway, no se agregar y
     * se imprime en pantalla un mensaje indicando Line repetida.
     * Requerimiento Funcional 19
     * @param line Linea (Line) a agregar
     */
    public void addLine(Line_212788287_EspinozaBarria line){
        if(!(lines.contains(line)) && line.isLine()) {
            lines.add(line);
            System.out.println("\n --- Se agrego exitosamente el tren al metro en addLine ---\n");
        }else{
            System.out.println("La linea ingresada ya existe en el Subway. No se agrego");
        }
    }

    /**
     * Agrega un lista de lineas al Subway. En caso de que alguna linea ya exista en el subway, no se
     * agrega y se imprime en pantalla un mensaje indicando linea repetido.
     * Requerimiento Funcional 19. Notar sobrecarga
     * @param listaLinesIngresar Lista de lineas (List&lt;Line&gt;) a ingresar
     */
    public void addLine(List<Line_212788287_EspinozaBarria> listaLinesIngresar){
        for(Line_212788287_EspinozaBarria lineActual : listaLinesIngresar){
            addLine(lineActual);
            System.out.println("\n --- Se agrego exitosamente el tren al metro en addLine ---\n");
        }
    }

    /**
     * Agrega un conductor a un subway. En caso de que ya exista en el subway, no se agrega y se
     * imprime por pantalla un mensaje indicando conductor repetido.
     * Requerimiento Funcional 20
     * @param driver Conductor (Driver) a ingresar
     */
    public void addDriver(Driver_212788287_EspinozaBarria driver){
        if(!drivers.contains(driver)) {
            drivers.add(driver);
            System.out.println("\n --- Se agrego exitosamente el conductor al metro en addLine ---\n");
        }else{
            System.out.println("El driver ingresado ya existe en el Subway");
        }
    }

    /**
     * Agrega un lista de conductores al Subway. En caso de que algun conductor ya exista en el subway, no se
     * agrega y se imprime en pantalla un mensaje indicando conductor repetido.
     * Requerimiento Funcional 20
     * @param listaDrivers Lista de conductores (List&lt;Driver&gt;) a ingresar
     */
    public void addDriver(List<Driver_212788287_EspinozaBarria> listaDrivers){
        for(Driver_212788287_EspinozaBarria driverActual : listaDrivers){
            addDriver(driverActual);
            System.out.println("\n --- Se agrego exitosamente el conductor al metro en addLine ---\n");
        }
    }


}
