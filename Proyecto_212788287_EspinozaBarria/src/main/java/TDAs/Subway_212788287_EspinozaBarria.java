package TDAs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


/**
 * Subway es la abstraccion de una red de metro
 * @author isaac
 * @version 3.0 Java 11
 * @since 2024-06-19
 */
public class Subway_212788287_EspinozaBarria {

    //Atributos
    private int id;
    private String name;
    private Map<Double, Line_212788287_EspinozaBarria> linesMap = new HashMap<>();
    private Map<Integer, Driver_212788287_EspinozaBarria> driversMap = new HashMap<>();
    private Map<Integer, Train_212788287_EspinozaBarria> trainsMap = new HashMap<>();
    private Map<Integer, PassengerCar_212788287_EspinozaBarria> passengerCarsMap = new HashMap<>();
    private Map<Integer, Station_212788287_EspinozaBarria> stationsMap = new HashMap<>();
    private Map<Integer, Section_212788287_EspinozaBarria> sectionsMap = new HashMap<>();
    private Map<Double, List<Train_212788287_EspinozaBarria>> asignacionesTL = new HashMap<>();
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
        System.out.println("\033[0;31m"+" --- Se creo exitosamente el objeto Subway ---"+"\033[0m");
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

    public Map<Double, Line_212788287_EspinozaBarria> getLinesMap() {
        return linesMap;
    }
    public void setLinesMap(Map<Double, Line_212788287_EspinozaBarria> linesMap) {
        this.linesMap = linesMap;
    }

    public Map<Integer, Driver_212788287_EspinozaBarria> getDriversMap() {
        return driversMap;
    }
    public void setDriversMap(Map<Integer, Driver_212788287_EspinozaBarria> driversMap) {
        this.driversMap = driversMap;
    }

    public Map<Integer, Train_212788287_EspinozaBarria> getTrainsMap() {
        return trainsMap;
    }
    public void setTrainsMap(Map<Integer, Train_212788287_EspinozaBarria> trainsMap) {
        this.trainsMap = trainsMap;
    }

    public Map<Integer, PassengerCar_212788287_EspinozaBarria> getPassengerCarsMap() {
        return passengerCarsMap;
    }
    public void setPassengerCarsMap(Map<Integer, PassengerCar_212788287_EspinozaBarria> passengerCarsMap) {
        this.passengerCarsMap = passengerCarsMap;
    }

    public Map<Integer, Station_212788287_EspinozaBarria> getStationsMap() {
        return stationsMap;
    }
    public void setStationsMap(Map<Integer, Station_212788287_EspinozaBarria> stationsMap) {
        this.stationsMap = stationsMap;
    }

    public Map<Integer, Section_212788287_EspinozaBarria> getSectionsMap() {
        return sectionsMap;
    }
    public void setSectionsMap(Map<Integer, Section_212788287_EspinozaBarria> sectionsMap) {
        this.sectionsMap = sectionsMap;
    }

    public Map<Double, List<Train_212788287_EspinozaBarria>> getAsignacionesTL() {
        return asignacionesTL;
    }
    public void setAsignacionesTL(Map<Double, List<Train_212788287_EspinozaBarria>> asignacionesTL) {
        this.asignacionesTL = asignacionesTL;
    }

    public List<RecorridoDriverTrain_212788287_EspinozaBarria> getRecorridosDriverTrain() {
        return recorridosDriverTrain;
    }
    public void setRecorridosDriverTrain(List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDriverTrain) {
        this.recorridosDriverTrain = recorridosDriverTrain;
    }



    //Otros metodos

    /**
     * Agrega una estacion a la red de metro
     * @param st Estacion (Station) a agregar
     */
    public void addStation(Station_212788287_EspinozaBarria st){
        if(!stationsMap.containsValue(st)){
            stationsMap.put(st.getId(),st);
            System.out.println("\033[0;31m"+" --- Se agrego exitosamente la estacion al metro ---"+"\033[0m");
        }else{
            System.out.println("La estacion ingresada ya existe en el subway. No se agrego la estacion.");
        }
    }

    /**
     * Agrega una seccion a la red de metro.
     * Es usada en la funcion addSectionsByTXT dado que esta verifica la consistencia de la seccion, buscando la
     * existencia de las estaciones en el metro
     * @param idSec Id (int) de la seccion a agregar
     * @param se Seccion (Section) a agregar
     */
    public void addSection(int idSec, Section_212788287_EspinozaBarria se){
        if(!sectionsMap.containsValue(se)){
            sectionsMap.put(idSec,se);
            System.out.println("\033[0;31m"+" --- Se agrego exitosamente la seccion al metro ---"+"\033[0m");
        }else{
            System.out.println("La seccion ingresada ya existe en el subway. No se agrego la seccion.");
        }
    }

    /**
     * Agrega un carro de pasajeros en la red de metro
     * @param carro Carro de pasajeros (PassengerCar)
     */
    public void addPassengerCar(PassengerCar_212788287_EspinozaBarria carro){
        if(!passengerCarsMap.containsValue(carro)){
            passengerCarsMap.put(carro.getId(),carro);
            System.out.println("\033[0;31m"+" --- Se agrego exitosamente el carro de pasajeros al metro ---"+"\033[0m");
        }else{
            System.out.println("El carro ingresada ya existe en el subway. No se agrego el carro.");
        }
    }

    /**
     * Agrega un tren valido al Subway. En el caso de que el tren exista en el subway, no se agrega y se imprime en pantalla
     * un mensaje indicando tren repetido.
     * Requerimiento Funcional 18
     * @param train Tren (Train) a agregar
     */
    public void addTrain(Train_212788287_EspinozaBarria train) {
        if(!trainsMap.containsValue(train) && train.isTrain()) {
            boolean carrosDisponibles = true;
            for(PassengerCar_212788287_EspinozaBarria carro : train.getCarList()){
                if(passengerCarsMap.get(carro.getId()).getAsignadoATren()){//CASO el carro ya esta asignado a otro tren
                    carrosDisponibles = false;
                }
            }
            if(carrosDisponibles){
                trainsMap.put(train.getId(), train);
                for(PassengerCar_212788287_EspinozaBarria carroAux : train.getCarList()){//cambiamos valor de asignados de los carros
                    passengerCarsMap.get(carroAux.getId()).setAsignadoATren(true);
                }
                System.out.println("\033[0;31m"+" --- Se agrego exitosamente el tren al metro en addTrain ---"+"\033[0m");
            }else{
                System.out.println("El tren tiene carros ya asignados a otros trenes. No se agrego el tren al metro.");
            }

        }else{
            System.out.println("El tren ingresado ya existe en el Subway. No se agrego el tren al metro.");
        }
    }

    /**
     * Agrega un lista de trenes al Subway. En caso de que algun tren ya exista en el subway o no sea valido, no se
     * agrega y se imprime en pantalla un mensaje indicando tren repetido.
     * Requerimiento Funcional 18. Notar sobrecarga y polimorfismo en tiempo de compilacion
     * @param listaTrenesIngresar Lista de Trenes (List&lt;Train&gt;) a ingresar
     */
    public void addTrain(List<Train_212788287_EspinozaBarria> listaTrenesIngresar){
        for(Train_212788287_EspinozaBarria trenActual : listaTrenesIngresar){
            addTrain(trenActual);
        }
        System.out.println("\033[0;31m"+" --- Se agrego exitosamente los trenes validos de la lista al metro en addTrain ---"+"\033[0m");
    }

    /**
     * Agrega una linea valida al Subway. En caso de linea ya existente en el subway, no se agrega y
     * se imprime en pantalla un mensaje indicando Line repetida.
     * Requerimiento Funcional 19
     * @param line Linea (Line) a agregar
     */
    public void addLine(Line_212788287_EspinozaBarria line){
        if(!(linesMap.containsValue(line)) && line.isLine()) {
            linesMap.put(line.getId(), line);
            System.out.println("\033[0;31m"+" --- Se agrego exitosamente la linea al metro en addLine ---"+"\033[0m");
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
        }
        System.out.println("\033[0;31m"+" --- Se agrego exitosamente las lineas validas de la lista al metro en addLine ---"+"\033[0m");
    }

    /**
     * Agrega un conductor a un subway. En caso de que ya exista en el subway, no se agrega y se
     * imprime por pantalla un mensaje indicando conductor repetido.
     * Requerimiento Funcional 20
     * @param driver Conductor (Driver) a ingresar
     */
    public void addDriver(Driver_212788287_EspinozaBarria driver){
        if(!driversMap.containsValue(driver)) {
            driversMap.put(driver.getId(), driver);
            System.out.println("\033[0;31m"+" --- Se agrego exitosamente el conductor al metro en addDriver ---"+"\033[0m");
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
        }
        System.out.println("\033[0;31m"+" --- Se agrego exitosamente los conductores validos de la lista al metro en addDriver ---"+"\033[0m");
    }

    /**
     * Crea un string con toda la informacion existente en una red de metro.
     * Requerimiento Funciona 21
     * @return (String) con la informacion
     */
    @Override
    public String toString(){
        String str = "\n\n\t\tInformacion de la red de Metro\n" + "Nombre: " + getName() + "\nID: " + getId();
        //String datos trenes
        str += toStringStations() + toStringSections() + toStringLines() + toStringCars() + toStringTrains() +
                toStringDrivers() + toStringAsignacionesTL() + toStringRecorridos();
        System.out.println("\033[0;31m"+" --- Se creo exitosamente el String con la informacion de subway en toString ---"+"\033[0m");
        return str+"\n";
    }

    /**
     * Crea un String con la informacion de las estaciones de la red de metro
     * @return (String) con la informacion
     */
    public String toStringStations(){
        String str = "\nLista de estaciones:\n";
        for(Station_212788287_EspinozaBarria st : stationsMap.values()){
            str += "\t\t" + st.toString() + "\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de las secciones de la red de metro
     * @return (String) con la informacion
     */
    public String toStringSections(){
        String str = "\nLista de secciones:\n";
        for(int sec : sectionsMap.keySet()){
            str += String.format("\t\t{ ID: %-3s    Estacion1: %-25s   Estacion2: %-25s   Distancia(Km): %-4s   Costo: %-5s }\n",
                    sec,sectionsMap.get(sec).getStation1().getName(),sectionsMap.get(sec).getStation2().getName(),
                    sectionsMap.get(sec).getDistance(),sectionsMap.get(sec).getCost());
        }
        return str;
    }

    /**
     * Crea un String con la informacion de las lineas de la red de metro
     * @return (String) con la informacion
     */
    public String toStringLines(){
        String str = "\nLista de lineas:\n";
        for(Line_212788287_EspinozaBarria line : linesMap.values()){
            str +=  "\tLinea:\n"+line.toString() + "\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de los carros de pasajeros de la red de metro
     * @return (String) con la informacion
     */
    public String toStringCars(){
        String str = "\nLista de carros:\n";
        for(PassengerCar_212788287_EspinozaBarria pcar : passengerCarsMap.values()){
            str += "\t\t" + pcar.toString() + "\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de los trenes de la red de metro
     * @return (String) con la informacion
     */
    public String toStringTrains(){
        String str = "\nLista de trenes:\n";
        for(Train_212788287_EspinozaBarria train : trainsMap.values()){
            str += train.toString() + "\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de los conductores de la red de metro
     * @return (String) con la informacion
     */
    public String toStringDrivers(){
        String str = "\nLista de conductores:\n";
        for(Driver_212788287_EspinozaBarria driver : driversMap.values()){
            str += "\t" + driver.toString() + "\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de las asignaciones Tren-Linea de la red de metro
     * @return (String) con la informacion
     */
    public String toStringAsignacionesTL(){
        String str = "\nLista de asignaciones Trenes-Linea:\n";
        for(double idsLineWithTrains : asignacionesTL.keySet()){
            str += "\tID Linea: " + idsLineWithTrains + ",      IDs Trenes:  [    ";
            for(Train_212788287_EspinozaBarria trenAsignado : asignacionesTL.get(idsLineWithTrains)){
                str += trenAsignado.getId() +"    ";
            }
            str += "]\n";
        }
        return str;
    }

    /**
     * Crea un String con la informacion de los recorridos de la red de metro
     * @return (String) con la informacion
     */
    public String toStringRecorridos(){
        String str = "\nLista de recorridos Conductor-Tren:\n";
        for(RecorridoDriverTrain_212788287_EspinozaBarria reco :recorridosDriverTrain){
            str += "\t{" + reco.toString() + " }\n";
        }
        return str;
    }

    /**
     * Asigna un tren a una linea especifica dentro de una red de metro.
     * Requerimiento Funcional 22
     * @param train Tren (Train) a asignar
     * @param line Linea (Line) a asignar
     */
    public void assignTrainToLine(Train_212788287_EspinozaBarria train, Line_212788287_EspinozaBarria line) {
        if(!train.isTrain() || !line.isLine()){ //verificar que train sea tren valido y line linea valida
            System.out.println("El tren o linea no son validas en construccion. No se realizo la asignacion");
            return;
        }else if(!trainsMap.containsValue(train)) {//verificar existencia del tren en el subway
            System.out.println("El tren no existe en el Subway. No se realizo la asignacion");
            return;
        }else if(!linesMap.containsValue(line)) {//verificar existencia de la linea en el subway
            System.out.println("La linea no existe en el Subway. No se realizo la asignacion");
            return;
        }else if(!train.getTypeRail().equals(line.getTypeRail())) {//verificar compatibilidad de tipo de riel
            System.out.println("Incompatibilidad de tipos de riel. No se realizo la asignacion");
            return;
        }

        //Verificar que el tren no este asignado a una linea anteriormente
        for(List<Train_212788287_EspinozaBarria> listaTrenesDeLinea : asignacionesTL.values()){
            for(Train_212788287_EspinozaBarria trenAct : listaTrenesDeLinea){
                if(trenAct.getId()==train.getId()){
                    System.out.println("El tren ya esta asignado a una linea en el Subway. No se realizo la asignacion nueva");
                    return;
                }
            }
        }

        //Caso en que ya habian asignaciones en la linea determinada
        for (double idsLineasDeAsignaciones : asignacionesTL.keySet()){
            if(line.getId() == idsLineasDeAsignaciones){//se encontro los trenes de la linea
                List<Train_212788287_EspinozaBarria> trenesAux = asignacionesTL.get(idsLineasDeAsignaciones);
                trenesAux.add(train);
                asignacionesTL.replace(idsLineasDeAsignaciones, trenesAux);
                System.out.println("\033[0;31m"+" --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n"+"\033[0m");
                return;
            }
        }

        //caso en que sea la primera asignacion de tren de una linea
        asignacionesTL.put(line.getId(), new ArrayList<>(Arrays.asList(train)));
        System.out.println("\033[0;31m"+" --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---"+"\033[0m");
    }

    /**
     * Asigna un Conductor a un recorrido determinado dentro de la red de metro. Crea instancias de la clase
     * RecorridoDriverTrain. Utiliza la clase externa de java del paquete java.Utils.
     * Requerimiento Funcional 23
     * @param train Tren (Train) a asignar recorrido
     * @param driver Conductor (Driver) a asignar recorrido
     * @param tiempoInicio Fecha-Tiempo (GregorianCalendar) de partida para el recorrido. Clase perteneciente
     * a java.utils.GregorianCalendar
     * @param stInicio Estacion (Station) de inicio del recorrido
     * @param stFinal Estacion (Station) de termino del recorrido
     */
    public void assignDriverToTrain(Train_212788287_EspinozaBarria train, Driver_212788287_EspinozaBarria driver,
                                    GregorianCalendar tiempoInicio,Station_212788287_EspinozaBarria stInicio,
                                    Station_212788287_EspinozaBarria stFinal) {
        if(!train.isTrain() || stInicio.equals(stFinal)){//verifica tren valido y que las estaciones sean distintas
            System.out.println("Tren invalido o las Estaciones ingresadas no son validas. No se realizo la asignacion");
            return;
        }else if(!driver.getTrainMaker().equals(train.getTrainMaker())){
            System.out.println("Fabricante de trenes incompatible, No se realizo la asignacion");
            return;
        }

        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux =
                new RecorridoDriverTrain_212788287_EspinozaBarria(train, driver, tiempoInicio, stInicio, stFinal);
        if(recorridosDriverTrain.contains(recorridoAux)){
            System.out.println("El recorrido ya existe en el metro. No se realizo la asignacion");
            return;
        }
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorridoActual : recorridosDriverTrain){
            if(recorridoActual.getTrain().getId()==train.getId() && recorridoActual.getDriver().getName().equals(driver.getName()) &&
                    recorridoActual.getInicialDate().equals(tiempoInicio) &&
                    recorridoActual.getInicialStation().getName().equals(stInicio.getName()) &&
                    recorridoActual.getFinalStation().getName().equals(stFinal.getName())){
                System.out.println("El recorrido ya existe en el metro. No se realizo la asignacion");
                return;
            }
        }
        recorridosDriverTrain.add(recorridoAux);
        System.out.println("\033[0;31m"+" --- Se realizo la asignacion de recorrido Conductor-Tren correctamente al metro en assignDriverToTrain---"+"\033[0m");
    }

    /**
     * Determina la informacion en String sobre la estacion mas cercana a un tren determinado en un recorrido segun un
     * horario ingresado. La busqueda de la estacion la realiza la funcion externa getStationWhereIsTrain, la
     * considera recorridos en ambos sentidos para las estaciones
     * Requerimiento Funcional 24
     * @param idTrencito Id tren (int) a consultar donde esta
     * @param time Fecha/Tiempo (GregorianCalendar) a consultar donde esta el tren
     * @return Informacion (String) de la estacion y la linea donde se encuentra el tren
     */
    public String whereIsTrain(int idTrencito, GregorianCalendar time) {
        double idLinea =0;
        Station_212788287_EspinozaBarria estacionEncontrada = getStationWhereIsTrain(idTrencito,time);
        for(double idLi : asignacionesTL.keySet()){
            if(asignacionesTL.get(idLi).contains(trainsMap.get(idTrencito))){
                idLinea = idLi;
            }
        }
        System.out.println("\033[0;31m"+" --- Se encontro el tren correctamente en el metro en whereIsTrain ---"+"\033[0m");
        return "\n\nEl tren se encuentra cerca de la Estacion:   " + estacionEncontrada.getName() +"    de la linea ID: " + idLinea;
    }

    /**
     * Busca la Estacion mas cercana a un tren a un recorrido determinado segun un horario ingresado. Considera
     * caso de recorrido normal de las sections y el caso de recorrido inverso
     * @param idTrencito Id del tren (int) a consultar donde esta
     * @param time Fecha/Tiempo (GregorianCalendar) a consultar donde esta el tren
     * @return Estacion (Station) mas cercana al tren el horario ingresado
     */
    public Station_212788287_EspinozaBarria getStationWhereIsTrain(int idTrencito, GregorianCalendar time){
        int a=0;
        double idLinea=-1;
        int sumaParcialSegundos, segundosRecorridoSection = 0, segundosStation2Section = 0;
        Line_212788287_EspinozaBarria lineAux = null;
        Train_212788287_EspinozaBarria train = trainsMap.get(idTrencito);

        //notar que un tren puede tener multiples recorridos, por lo que se tiene que buscar el adecuado al horario preguntado
        //creamos sublista con todos los recorridos de un tren en especifico
        List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDelTren = new ArrayList<>();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorr : recorridosDriverTrain){
            if(recorr.getTrain().equals(train)){
                recorridosDelTren.add(recorr);
            }
        }
        //buscamos recorrido mas cercano al ingresado segun horario
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;
        long horaEnMiliSeg = time.getTimeInMillis();
        Long tiempoMasCercano = null;
        for(RecorridoDriverTrain_212788287_EspinozaBarria re : recorridosDelTren){
            if(re.getInicialDate().getTimeInMillis() <= horaEnMiliSeg){
                if(tiempoMasCercano == null || re.getInicialDate().getTimeInMillis() > tiempoMasCercano){
                    tiempoMasCercano = re.getInicialDate().getTimeInMillis();
                    recorridoAux = re;
                }
            }
        }

        //buscamos la id de la linea segun los trenes asignados en asignacionesTL
        for(double idLi : asignacionesTL.keySet()){
            if(asignacionesTL.get(idLi).contains(train)){
                idLinea = idLi;
            }
        }
        lineAux = linesMap.get(idLinea);//buscamos la linea segun el id encontrado

        //obtenemos secciones que efectivamente pertenecen al recorrido estipulado
        List<Section_212788287_EspinozaBarria> subSectionsRecorridas =
                lineAux.lineSubSectionsByNames(recorridoAux.getInicialStation().getName(), recorridoAux.getFinalStation().getName());

        //analizar sentido de recorrido, si este condicional es true significa que la recorrido es inverso. Por lo
        //que "invierte" la lista de sections y asi determinar la estacion donde se encuentra
        if(!recorridoAux.getInicialStation().equals(subSectionsRecorridas.get(0).getStation1())){
            List<Section_212788287_EspinozaBarria> subSectionsInvertidas = new ArrayList<>();
            Section_212788287_EspinozaBarria sectAux;
            for(Section_212788287_EspinozaBarria seccionAc : subSectionsRecorridas){
                sectAux = new Section_212788287_EspinozaBarria(seccionAc.getStation2(),seccionAc.getStation1(),
                        seccionAc.getDistance(), seccionAc.getCost(),false);
                subSectionsInvertidas.add(0,sectAux);//progresivamente se construye la lista inversa
            }
            subSectionsRecorridas = subSectionsInvertidas;//se copia la lista invertida en la lista a calcular el tiempo
        }

        //obtener diferencia de horas en segundos
        long difHoraEnSeg = (time.getTimeInMillis() - recorridoAux.getInicialDate().getTimeInMillis())/1000;
        if(difHoraEnSeg<=0){
            System.out.println("Tiempo invalido, no se realizo busqueda");
            return null;
        }

        //ahora recorremos las sections considerando tiempo de parada por estacion y tiempo de recorrido por section
        //hasta llegar a difHoraEnSeg
        a = 0;//reiniciamos indice
        sumaParcialSegundos = subSectionsRecorridas.get(0).getStation1().getStopTime();//segundos de la estacion1 inicial
        while(sumaParcialSegundos<=difHoraEnSeg && a<subSectionsRecorridas.size()){
            segundosRecorridoSection = (int) ((subSectionsRecorridas.get(a).getDistance() / train.getSpeed()) * 3600);
            segundosStation2Section = subSectionsRecorridas.get(a).getStation2().getStopTime();
            sumaParcialSegundos = sumaParcialSegundos + segundosRecorridoSection + segundosStation2Section;
            a++;
        }

        //Ahora, la Station en la posicion a-1 de las sections de la linea es la Station mas cercana en el tiempo determinado
        return subSectionsRecorridas.get(a-1).getStation2();
    }

    /**
     * Crea una lista de las Estaciones proximas de un recorrido para un determinado tren segun un horario ingresado.
     * Utiliza de forma auxiliar la funcion getStationWhereIsTrain
     * @param idTrencito Id del tren (int) a consultar
     * @param date Fecha/Tiempo (GregorianCalendar) a consultar el recorrido proximo
     * @return Lista de Estaciones (List&lt;Station&gt;)
     */
    public List<Station_212788287_EspinozaBarria> trainPath(int idTrencito, GregorianCalendar date){
        double idLinea=-1;
        Line_212788287_EspinozaBarria lineAux;
        List<Station_212788287_EspinozaBarria> listaEstaciones = new ArrayList<>();
        Train_212788287_EspinozaBarria train = trainsMap.get(idTrencito);

        //buscamos recorrido Adecuando para tren en el horario determinado
        List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDelTren = new ArrayList<>();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorr : recorridosDriverTrain){
            if(recorr.getTrain().equals(train)){ recorridosDelTren.add(recorr); }
        }
        //buscamos recorrido mas cercano al ingresado
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;
        long horaEnMiliSeg = date.getTimeInMillis();
        Long tiempoMasCercano = null;
        for(RecorridoDriverTrain_212788287_EspinozaBarria re : recorridosDelTren){
            if(re.getInicialDate().getTimeInMillis() <+ horaEnMiliSeg){
                if(tiempoMasCercano == null || re.getInicialDate().getTimeInMillis() > tiempoMasCercano){
                    tiempoMasCercano = re.getInicialDate().getTimeInMillis();
                    recorridoAux = re;
                }
            }
        }
        //buscamos la id de la linea segun los trenes asignados en asignacionesTL
        for(double idLi : asignacionesTL.keySet()){
            if(asignacionesTL.get(idLi).contains(train)){
                idLinea = idLi;
            }
        }
        lineAux = linesMap.get(idLinea);//buscamos la linea segun el id encontrado

        //obtenemos estacion mas cercana en el recorrido segun el horario
        Station_212788287_EspinozaBarria stationCercana = getStationWhereIsTrain(idTrencito,date);

        //obtenemos secciones futuras al recorrido den tren
        List<Section_212788287_EspinozaBarria> subSectionsRecorridas =
                lineAux.lineSubSectionsByNames(stationCercana.getName(), recorridoAux.getFinalStation().getName());

        if(subSectionsRecorridas == null){
            System.out.println("El tren ya termino su recorrido. No se crea lista de estaciones futuras.");
            return null;
        }

        //condicion caso sentido inverso
        if(!stationCercana.equals(subSectionsRecorridas.get(0).getStation1())){
            List<Section_212788287_EspinozaBarria> subSectionsInvertidas = new ArrayList<>();
            Section_212788287_EspinozaBarria sectAux = null;
            for(Section_212788287_EspinozaBarria seccionAc : subSectionsRecorridas){
                sectAux = new Section_212788287_EspinozaBarria(seccionAc.getStation2(),seccionAc.getStation1(),
                        seccionAc.getDistance(), seccionAc.getCost(),false);
                subSectionsInvertidas.add(0,sectAux);//progresivamente se construye la lista inversa
            }
            subSectionsRecorridas = subSectionsInvertidas;//se copia la lista invertida en la lista a calcular el tiempo
        }

        //crear lista de estaciones para retornar
        for(Section_212788287_EspinozaBarria seccionActFutura : subSectionsRecorridas){
            listaEstaciones.add(seccionActFutura.getStation2());//en cada section se agrega la estacion2 futura
        }

        System.out.println("\033[0;31m"+" --- Se creo exitosamente la lista de estaciones futuras del recorrido en el metro en trainPath ---"+"\033[0m");
        return listaEstaciones;
    }

    /**
     * Agrega estaciones al metro leyendo la informacion de un archivo de texto.
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addStationsByTXT(String archivo){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));//leer el archivo
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                String tipo = parts[2];
                int tiempo = Integer.parseInt(parts[3]);
                Station_212788287_EspinozaBarria station = new Station_212788287_EspinozaBarria(id, nombre, tipo, tiempo);
                addStation(station);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente las estaciones a la red de metro al leer el archivo ---"+"\033[0m");

    }

    /**
     * Agrega secciones al metro leyendo la informacion de un archivo de texto. Ademas verifica la existencia de los
     * elementos pertinentes, estaciones, en el metro para funcionar
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addSectionsByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int estacion1Id = Integer.parseInt(parts[1]);
                int estacion2Id = Integer.parseInt(parts[2]);
                double distancia = Double.parseDouble(parts[3]);
                double costo = Double.parseDouble(parts[4]);
                Station_212788287_EspinozaBarria estacion1 = stationsMap.get(estacion1Id);//buscamos las stations en el subway
                Station_212788287_EspinozaBarria estacion2 = stationsMap.get(estacion2Id);
                Section_212788287_EspinozaBarria section = new Section_212788287_EspinozaBarria(estacion1, estacion2, distancia, costo,true);
                addSection(id,section);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente las secciones a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega lineas al metro leyendo la informacion de un archivo de texto. Analiza si las estaciones y secciones
     * existen previamente en el metro. Solo agrega lineas validas
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addLinesByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double id = Double.parseDouble(parts[0]);
                String nombre = parts[1];
                String tipoRiel = parts[2];
                String[] idsSecciones = parts[3].split("-");
                Line_212788287_EspinozaBarria lineaMetro = new Line_212788287_EspinozaBarria(id,nombre,tipoRiel,new ArrayList<>());
                for(String idSeccion : idsSecciones){
                    //agregamos las sections a la linea creada actual
                    lineaMetro.lineAddSection(sectionsMap.get(Integer.parseInt(idSeccion)));//las sections ya deben estar en el subway
                }
                if(lineaMetro.isLine()) {
                    addLine(lineaMetro);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente las lineas a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega conductores al metro leyendo la informacion de un archivo de texto.
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addDriversByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                String fabricanteTrenes = parts[2];
                //COMPOSICION, creo un objeto de otra clase desde esta clase
                Driver_212788287_EspinozaBarria driverActual = new Driver_212788287_EspinozaBarria(id,nombre,fabricanteTrenes);
                addDriver(driverActual);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente los conductores a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega carros de pasajeros al metro leyendo la informacion de un archivo de texto.
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addPassengerCarsByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int capacidad = Integer.parseInt(parts[1]);
                String modelo = parts[2];
                String tmaker = parts[3];
                String tipo = parts[4];
                if(tipo.equals("t")){
                    TerminalPCar_212788287_EspinozaBarria carro = new TerminalPCar_212788287_EspinozaBarria(id,capacidad,modelo,tmaker);
                    addPassengerCar(carro);
                }else{
                    CentralPCar_212788287_EspinozaBarria carro = new CentralPCar_212788287_EspinozaBarria(id,capacidad,modelo,tmaker);
                    addPassengerCar(carro);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente los carros a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega trenes al metro leyendo la informacion de un archivo de texto. Analizando la existencia de los carros
     * en el metro.
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addTrainsByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String trainMak = parts[1];
                String tipoRiel = parts[2];
                double speed = Double.parseDouble(parts[3]);
                String[] idsCarros = parts[4].split("-");
                List<PassengerCar_212788287_EspinozaBarria> carrosTren = new ArrayList<>();
                for(String idCarro : idsCarros){//agregamos carros a una lista en orden
                    carrosTren.add(passengerCarsMap.get(Integer.parseInt(idCarro)));//buscamos los carros por ID en el subway
                }
                Train_212788287_EspinozaBarria tren = new Train_212788287_EspinozaBarria(id,trainMak,tipoRiel,speed,carrosTren);
                if(tren.isTrain()) {
                    addTrain(tren);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente los trenes a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega asignaciones Tren-Linea al metro leyendo la informacion de un archivo de texto. Analiza la existencia
     * de la linea y el|los tren|trenes en el metro
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addAsignacionesTrainLineByTXT(String archivo){
        try{
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double idLine = Integer.parseInt(parts[0]);
                String[] idsTrenes = parts[1].split("-");
                for(String idtren : idsTrenes){//agregamos carros a una lista en orden
                    assignTrainToLine(trainsMap.get(Integer.parseInt(idtren)),linesMap.get(idLine));//Buscamos trenes por ID en el subway
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente las asignaciones tren-linea a la red de metro al leer el archivo ---"+"\033[0m");
    }

    /**
     * Agrega recorridos al metro leyendo la informacion de un archivo de texto. Analiza la existencia de los elementos
     * pertinentes en el metro
     * La ubicacion del archivo debe ser en la carpeta raiz del proyecto, es decir, al mismo nivel de la carperta scr
     * @param archivo Nombre (String) del archivo con su extension .txt
     */
    public void addRecorridosByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int idTren = Integer.parseInt(parts[0]);
                int idDriver = Integer.parseInt(parts[1]);
                int anio = Integer.parseInt(parts[2]);
                int mes = Integer.parseInt(parts[3]);
                int dia = Integer.parseInt(parts[4]);
                int hora = Integer.parseInt(parts[5]);
                int min = Integer.parseInt(parts[6]);
                int idStation1 = Integer.parseInt(parts[7]);
                int idStation2 = Integer.parseInt(parts[8]);
                assignDriverToTrain(trainsMap.get(idTren),driversMap.get(idDriver),new GregorianCalendar(anio,mes,dia,hora,min),
                        stationsMap.get(idStation1),stationsMap.get(idStation2));//buscamos estaciones por ID en el subway
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\033[0;31m"+" --- Se agregaron exitosamente los recorridos a la red de metro al leer el archivo ---"+"\033[0m");
    }


}
