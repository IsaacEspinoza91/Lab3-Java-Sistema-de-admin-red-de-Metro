package TDAs;

import java.util.Date;

/**
 * RecorridoDriverTrain es la abstraccion de un recorrido asignado a un Driver y Train determinado
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-15
 */
public class RecorridoDriverTrain_212788287_EspinozaBarria {

    //Atributos
    private Train_212788287_EspinozaBarria train;
    private Driver_212788287_EspinozaBarria driver;
    private Date inicialDate;
    private Station_212788287_EspinozaBarria inicialStation;
    private Station_212788287_EspinozaBarria finalStation;



    //Constructor
    /**
     * Constructor de un objeto RecorridoDriverTrain
     * @param train Tren (Train) del recorrido
     * @param driver Conductor (Driver) del recorrido
     * @param inicialDate Fecha (Date) de inicio de recorrido
     * @param inicialStation Estacion (Station) inicial de recorrido
     * @param finalStation Estacion (Station) final de recorrido
     */
    public RecorridoDriverTrain_212788287_EspinozaBarria(Train_212788287_EspinozaBarria train,
                                                         Driver_212788287_EspinozaBarria driver, Date inicialDate,
                                                         Station_212788287_EspinozaBarria inicialStation,
                                                         Station_212788287_EspinozaBarria finalStation) {
        this.train = train;
        this.driver = driver;
        this.inicialDate = inicialDate;
        this.inicialStation = inicialStation;
        this.finalStation = finalStation;
    }



    //Metodos
    //getters y setters
    public Train_212788287_EspinozaBarria getTrain() {
        return train;
    }
    public void setTrain(Train_212788287_EspinozaBarria train) {
        this.train = train;
    }

    public Driver_212788287_EspinozaBarria getDriver() {
        return driver;
    }
    public void setDriver(Driver_212788287_EspinozaBarria driver) {
        this.driver = driver;
    }

    public Date getInicialDate() {
        return inicialDate;
    }
    public void setInicialDate(Date inicialDate) {
        this.inicialDate = inicialDate;
    }

    public Station_212788287_EspinozaBarria getInicialStation() {
        return inicialStation;
    }
    public void setInicialStation(Station_212788287_EspinozaBarria inicialStation) {
        this.inicialStation = inicialStation;
    }

    public Station_212788287_EspinozaBarria getFinalStation() {
        return finalStation;
    }
    public void setFinalStation(Station_212788287_EspinozaBarria finalStation) {
        this.finalStation = finalStation;
    }


    @Override
    public String toString() {
        return "\tID Tren: " + train.getId() + ", Conductor: " + driver.getName() + ", Tiempo de Partida: " + inicialDate
                + ",  Estacion Inicio: " + inicialStation.getName() + ", Estacion Fin: " + finalStation.getName() + "\n";
    }


}
