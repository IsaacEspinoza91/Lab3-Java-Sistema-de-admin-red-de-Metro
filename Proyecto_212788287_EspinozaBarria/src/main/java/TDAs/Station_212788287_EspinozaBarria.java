package TDAs;

public class Station_212788287_EspinozaBarria {

    //Atributos
    private int id;        //id de la estacion
    private String name;   //nombre de la estacion
    private String type;   //tipo de estacion, puede ser String "r", "m", "c", "t"
    private int stopTime;  //tiempo de parada por estacion en segundos



    //Constructores
    public Station_212788287_EspinozaBarria() {}; //constructor vacio
    public Station_212788287_EspinozaBarria(int id, String name, String type, int stopTime) {
        if (stopTime < 0){
            throw new IllegalArgumentException("El stopTime no puede ser negativo");
        }
        if ((type != "m") && (type != "r") && (type != "c") && (type != "t")){
            throw new IllegalArgumentException("El tipo de station invalido. Debe ser 'm', 't', 'r' o 'c'.");
        }
        this.id = id;
        this.stopTime = stopTime;
        this.type = type;
        this.name = name;
    }



    //Metodos
    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStopTime() {
        return stopTime;
    }
    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    //no es necesaria funcion de pertencia porque no es posible crear objetos Station con valores invalidos






    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", stopTime=" + stopTime +
                '}';
    }
}
