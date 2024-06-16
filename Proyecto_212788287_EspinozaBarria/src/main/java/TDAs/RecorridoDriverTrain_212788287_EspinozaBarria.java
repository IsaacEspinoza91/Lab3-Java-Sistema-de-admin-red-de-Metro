package TDAs;

//import java.util.Date;
import java.util.GregorianCalendar;

/**
 * RecorridoDriverTrain es la abstraccion de un recorrido asignado a un Driver y Train determinado
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-16
 */
public class RecorridoDriverTrain_212788287_EspinozaBarria {

    //Atributos
    private Train_212788287_EspinozaBarria train;
    private Driver_212788287_EspinozaBarria driver;
    //private Date inicialDate;
    private GregorianCalendar inicialDate;
    private Station_212788287_EspinozaBarria inicialStation;
    private Station_212788287_EspinozaBarria finalStation;



    //Constructor
    /**
     * Constructor de un objeto RecorridoDriverTrain
     * @param train Tren (Train) del recorrido
     * @param driver Conductor (Driver) del recorrido
     * @param inicialDate Fecha (GregorianCalendar) de inicio de recorrido
     * @param inicialStation Estacion (Station) inicial de recorrido
     * @param finalStation Estacion (Station) final de recorrido
     */
    public RecorridoDriverTrain_212788287_EspinozaBarria(Train_212788287_EspinozaBarria train,
                                                         Driver_212788287_EspinozaBarria driver, GregorianCalendar inicialDate,
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

    public GregorianCalendar getInicialDate() {
        return inicialDate;
    }
    public void setInicialDate(GregorianCalendar inicialDate) {
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
        String salida = "\tID Tren: " + train.getId() + ", Conductor: " + driver.getName() + ", Fecha de Partida: " +
                inicialDate.get(GregorianCalendar.YEAR) + "/" + inicialDate.get(GregorianCalendar.MONTH) + "/" +
                inicialDate.get(GregorianCalendar.DATE) + " ";
        //casos para dar formato a la hora dependiendo de la cantidad de digitos
        if(inicialDate.get(GregorianCalendar.HOUR_OF_DAY) < 10){
            salida = salida + "0" + inicialDate.get(GregorianCalendar.HOUR_OF_DAY) + ":" ;
        }else{
            salida = salida + inicialDate.get(GregorianCalendar.HOUR_OF_DAY) + ":" ;
        }
        if(inicialDate.get(GregorianCalendar.MINUTE) < 10){
            salida = salida + "0" + inicialDate.get(GregorianCalendar.MINUTE);
        }else{
            salida = salida + inicialDate.get(GregorianCalendar.MINUTE);
        }
        return  salida + ",  Estacion Inicio: " + inicialStation.getName() +
                ", Estacion Fin: " + finalStation.getName() + "\n";
    }


}
