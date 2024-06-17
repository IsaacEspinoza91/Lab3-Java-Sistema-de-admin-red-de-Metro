package TDAs;

import java.util.List;

/**
 * Train es la abstraccion de un Tren dentro de una red de metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-14
 */
public class Train_212788287_EspinozaBarria {

    //Atributos
    private int id;
    private String trainMaker;
    private String typeRail;
    private double speed;
    private List<PassengerCar_212788287_EspinozaBarria> carList;



    //Constructor
    /**
     * Constructor de un objeto Train de una red de metro.
     * Requerimiento Funcional 11
     * @param id Identificador (int) del Train
     * @param trainMaker Fabricante (String) del Train
     * @param typeRail Tipo de riel (String) del Train
     * @param speed Rapidez del Train en km/h (double mayor a 0)
     * @param carList Lista de carros de un Train (List&lt;PassengerCar&gt;)
     * @throws IllegalArgumentException Al ingresar la rapidez negativa o 0
     */
    public Train_212788287_EspinozaBarria(int id, String trainMaker, String typeRail, double speed,
                                          List<PassengerCar_212788287_EspinozaBarria> carList) {
        if (speed <= 0){
            throw new IllegalArgumentException("La rapidez maxima no puede ser negativa o 0");
        }
        this.id = id;
        this.trainMaker = trainMaker;
        this.typeRail = typeRail;
        this.speed = speed;
        this.carList = carList;
        System.out.println(" --- Se creo exitosamente el objeto Train ---");
    }



    //Metodos
    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTrainMaker() {
        return trainMaker;
    }
    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    public String getTypeRail() {
        return typeRail;
    }
    public void setTypeRail(String typeRail) {
        this.typeRail = typeRail;
    }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public List<PassengerCar_212788287_EspinozaBarria> getCarList() {
        return carList;
    }
    public void setCarList(List<PassengerCar_212788287_EspinozaBarria> carList) {
        this.carList = carList;
    }




    //Otros metodos

    /**
     * Agrega un Carro al Train en una posicion determinada. En el caso de ingresar una posicion invalida, no se
     * modifica la lista de carros del tren.
     * Requerimiento Funcional 12
     * @param pCar Carro a ingresar en el Train (PassengerCar)
     * @param posicion Posicion (int no negativo)dentro de la lista de carros del tren. Los valores comienzan
     * desde el 0 hasta el largo de la lista-1
     */
    public void addCar(PassengerCar_212788287_EspinozaBarria pCar, int posicion){
        if(posicion==0 && carList.size()==0){//caso especial primer elemento
            carList.add(pCar);
            System.out.println(" --- Se agrego exitosamente el carro al tren en addCar ---");
        }else if(posicion<0 || posicion > carList.size()){
            System.out.println("Error Posicion no valida. No se agrego el PassagerCar al Train");
        }else{
            carList.add(posicion, pCar);
            System.out.println(" --- Se agrego exitosamente el carro al tren en addCar ---");
        }
    }

    /**
     * Elimina un Carro dentro del Train en una posicion determina. En el caso de ingresar una posicion invalida,
     * no se modifica la lista de carros del tren.
     * Requerimiento Funcional 13
     * @param posicion Posicion (int no negativo)dentro de la lista de carros del tren. Los valores comienzan
     * desde el 0 hasta el largo de la lista-1
     */
    public void removeCar( int posicion){
        if(posicion<0 || posicion >= carList.size()){
            System.out.println("Error Posicion no valida. No se elimino el PassagerCar al Train");
        }else{
            carList.remove(posicion);
            System.out.println(" --- Se elimino exitosamente el carro al tren en addCar ---");
        }
    }

    /**
     * Verifica la compatibilidad de los Carros de un Train de modo que los carros extremos sean de la clase
     * TerminalPCar y que los centrales sean de la clase CentralPCar. Considerando la estructura minima
     * valida como Terminal-Terminal
     * @return Resultado booleano
     */
    public boolean compatibleCarsOfTrain(){
        for(int p = 0; p < carList.size(); p++){
            if(p==0 || p==carList.size()-1){
                if(!(carList.get(p) instanceof TerminalPCar_212788287_EspinozaBarria)){
                    return false;//caso en que el primer o ultimo carro no sean terminales
                }
            }else if(!(carList.get(p) instanceof CentralPCar_212788287_EspinozaBarria)){
                return false;//caso en que algun carro del centro no sea central
            }
        }
        return true;//caso en que no se cumplen condiciones de carro mal construido
    }

    /**
     * Verifica que un tren sea efectivamente valida, considerando la estructura minima Terminal-Terminal, la
     * compatibilidad de tipos de carros, que todos los carros tengo mismo fabricnate y modelo.
     * Requerimiento Funcional 14
     * @return Resultado booleano
     */
    public boolean isTrain(){
        if (carList.size()==1){
            return false;//un unico carro no puede ser train. Recordar Estructura minima -> tr-tr
        }
        boolean sameModelOfCars = true, sameMakerOfCars = true;
        String modeloCarro1 = carList.get(0).getModel();
        String makerCarro1 = carList.get(0).getTrainMaker();
        for(PassengerCar_212788287_EspinozaBarria carro : carList){
            if(!(carro.getModel().equals(modeloCarro1))){
                sameModelOfCars = false;//caso de que la lista de carros tiene algun modelo diferente
            }else if(!(carro.getTrainMaker().equals(makerCarro1))){
                sameMakerOfCars = false;//caso en que la lista de carros tenga algun maker diferente
            }
        }
        //verificamos mismo modelo, mismo maker, y que los carros sean compatibles de tipo
        System.out.println(" --- Se verifico exitosamente si el tren es valido en isTrain ---");
        return sameModelOfCars && sameMakerOfCars && compatibleCarsOfTrain();
    }

    /**
     * Determina la capacidad maxima de pasajeros en un Train.
     * Requerimiento Funcional 15
     * @return Capacidad maxima (int)
     */
    public int fetchCapacity(){
        int capacidadTotal = 0;
        for(PassengerCar_212788287_EspinozaBarria pcar : carList){
            capacidadTotal = capacidadTotal + pcar.getPassengerCapacity();
        }
        System.out.println(" --- Se calculo exitosamente la capacidad total del tren en fetchCapacity ---");
        return capacidadTotal;
    }



    @Override
    public String toString() {
        String str = "\tTren:\n\t\t{ID: " + id + ", Fabricante:" + trainMaker + ", Tipo de Riel: "
                + typeRail + ", Rapidez: " + speed + "}\n\t\tCarros:\n";
        for(PassengerCar_212788287_EspinozaBarria carro : carList){
            str += "\t\t" + carro.toString() + "\n";
        }
        return str;
    }


}
