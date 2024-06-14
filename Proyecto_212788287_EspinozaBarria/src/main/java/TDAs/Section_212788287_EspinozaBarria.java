package TDAs;

/**
 * Section es una abstraccion de una seccion|tramo de un sistema de metro.
 * @author Isaac Espinoza
 * @version 1.0 en Java 11
 * @since 2024-06-12
 */
public class Section_212788287_EspinozaBarria {

    //Atributos
    private Station_212788287_EspinozaBarria station1;  //Estacion 1 de una seccion
    private Station_212788287_EspinozaBarria station2;  //Estacion 2 de una seccion
    private double distance;                            //Distancia entre estaciones
    private double cost;                                //Costo de recorrer una seccion



    //Constructor
    /**
     * Constructor de un objeto Section.
     * Requerimiento Funcional 2
     * Conseidera los casos de parametros invalidos y no crea el objeto, lanzando una excepcion
     * @param station1 Primera estacion (Station) de la section
     * @param station2 Segunda estacion (Station) de la section
     * @param distance Distancia en km (double mayor a 0) entre las estaciones de la section
     * @param cost Costo (double no negativo) de recorrer la section
     * @throws IllegalArgumentException Al ingresar parametros invalidos como distancia o costo menor a 0, que las
     * Stations ingresadas sean la misma
     */
    public Section_212788287_EspinozaBarria(Station_212788287_EspinozaBarria station1,
                                            Station_212788287_EspinozaBarria station2,
                                            double distance, double cost) {
        if (station1.equals(station2)){//verifica que las stations ingresadas no sean la misma
            throw new IllegalArgumentException("Las Stations no pueden ser iguales");
        }
        if (distance <= 0){
            throw new IllegalArgumentException("La distancia no puede ser no positiva");
        }
        if (cost < 0){
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.cost = cost;
    }



    //Metodos
    //getters y setters
    public Station_212788287_EspinozaBarria getStation1() {
        return station1;
    }
    public void setStation1(Station_212788287_EspinozaBarria station1) {
        this.station1 = station1;
    }

    public Station_212788287_EspinozaBarria getStation2() {
        return station2;
    }
    public void setStation2(Station_212788287_EspinozaBarria station2) {
        this.station2 = station2;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    //no es necesaria funcion de pertencia porque no es posible crear objetos Sections invalidos




    @Override
    public String toString() {
        return "\t\t\tEstacion1->  " + station1 + ",        Estacion1->  " + station2 +
                "\n\t\t\tDistancia (Km): " + distance + ", Costo: " + cost + "\n";
    }
}
