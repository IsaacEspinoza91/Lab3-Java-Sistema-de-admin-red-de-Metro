package TDAs;

public class Section_212788287_EspinozaBarria {

    //Atributos
    private Station_212788287_EspinozaBarria station1;
    private Station_212788287_EspinozaBarria station2;
    private double distance;
    private double cost;



    //Constructores
    public Section_212788287_EspinozaBarria() {}
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
        return "Section{" +
                "station1=" + station1 +
                ", station2=" + station2 +
                ", distance=" + distance +
                ", cost=" + cost +
                '}';
    }
}
