package TDAs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
//import java.util.Date;


/**
 * Subway es la abstraccion de una red de metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-15
 */
public class Subway_212788287_EspinozaBarria {

    //Atributos

    private List<Train_212788287_EspinozaBarria> trains = new ArrayList<>();
    private List<Line_212788287_EspinozaBarria> lines = new ArrayList<>();
    private List<Driver_212788287_EspinozaBarria> drivers = new ArrayList<>();
    private List<AsignacionTrainLine_212788287_EspinozaBarria> asignacionesTrainLine = new ArrayList<>();





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

    public void addStation(Station_212788287_EspinozaBarria st){
        if(!stationsMap.containsValue(st)){
            stationsMap.put(st.getId(),st);
            System.out.println(" --- Se agrego exitosamente la estacion al metro ---");
        }else{
            System.out.println("La estacion ingresada ya existe en el subway. No se agrego la estacion.");
        }
    }

    public void addSection(int idSec, Section_212788287_EspinozaBarria se){
        if(!sectionsMap.containsValue(se)){
            sectionsMap.put(idSec,se);
            System.out.println(" --- Se agrego exitosamente la seccion al metro ---");
        }else{
            System.out.println("La seccion ingresada ya existe en el subway. No se agrego la seccion.");
        }
    }

    public void addPassengerCar(PassengerCar_212788287_EspinozaBarria carro){
        if(!passengerCarsMap.containsValue(carro)){
            passengerCarsMap.put(carro.getId(),carro);
            System.out.println(" --- Se agrego exitosamente el carro de pasajeros al metro ---");
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
            trainsMap.put(train.getId(), train);
            System.out.println(" --- Se agrego exitosamente el tren al metro en addTrain ---");
        }else{
            System.out.println("El tren ingresado ya existe en el Subway. No se agrego el tren.");
        }
    }
    /*
    public void addTrain(Train_212788287_EspinozaBarria train) {
        if(!trains.contains(train) && train.isTrain()) {
            trains.add(train);
            System.out.println("\n --- Se agrego exitosamente el tren al metro en addTrain ---\n");
        }else{
            System.out.println("El tren ingresado ya existe en el Subway. No se agrego el tren.");
        }
    }*/

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
        System.out.println(" --- Se agrego exitosamente los trenes validos de la lista al metro en addTrain ---\n");
    }

    /*
    public void addTrain(List<Train_212788287_EspinozaBarria> listaTrenesIngresar){
        for(Train_212788287_EspinozaBarria trenActual : listaTrenesIngresar){
            addTrain(trenActual);
        }
        System.out.println(" --- Se agrego exitosamente los trenes validos de la lista al metro en addTrain ---\n");
    }
     */

    /**
     * Agrega una linea valida al Subway. En caso de linea ya existente en el subway, no se agrega y
     * se imprime en pantalla un mensaje indicando Line repetida.
     * Requerimiento Funcional 19
     * @param line Linea (Line) a agregar
     */
    public void addLine(Line_212788287_EspinozaBarria line){
        if(!(linesMap.containsValue(line)) && line.isLine()) {
            linesMap.put(line.getId(), line);
            System.out.println(" --- Se agrego exitosamente la linea al metro en addLine ---");
        }else{
            System.out.println("La linea ingresada ya existe en el Subway. No se agrego");
        }
    }

    /*
        public void addLine(Line_212788287_EspinozaBarria line){
        if(!(lines.contains(line)) && line.isLine()) {
            lines.add(line);
            System.out.println("\n --- Se agrego exitosamente la linea al metro en addLine ---\n");
        }else{
            System.out.println("La linea ingresada ya existe en el Subway. No se agrego");
        }
    }
     */

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
        System.out.println(" --- Se agrego exitosamente las lineas validas de la lista al metro en addTrain ---\n");
    }

    /*
        public void addLine(List<Line_212788287_EspinozaBarria> listaLinesIngresar){
        for(Line_212788287_EspinozaBarria lineActual : listaLinesIngresar){
            addLine(lineActual);
        }
        System.out.println(" --- Se agrego exitosamente las lineas validas de la lista al metro en addTrain ---\n");
    }
     */


    /**
     * Agrega un conductor a un subway. En caso de que ya exista en el subway, no se agrega y se
     * imprime por pantalla un mensaje indicando conductor repetido.
     * Requerimiento Funcional 20
     * @param driver Conductor (Driver) a ingresar
     */
    public void addDriver(Driver_212788287_EspinozaBarria driver){
        if(!driversMap.containsValue(driver)) {
            driversMap.put(driver.getId(), driver);
            System.out.println(" --- Se agrego exitosamente el conductor al metro en addLine ---");
        }else{
            System.out.println("El driver ingresado ya existe en el Subway");
        }
    }

    /*
    public void addDriver(Driver_212788287_EspinozaBarria driver){
        if(!drivers.contains(driver)) {
            drivers.add(driver);
            System.out.println("\n --- Se agrego exitosamente el conductor al metro en addLine ---\n");
        }else{
            System.out.println("El driver ingresado ya existe en el Subway");
        }
    }
     */

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
        System.out.println(" --- Se agrego exitosamente los conductores validos de la lista al metro en addTrain ---\n");
    }

    /**
     * Crea un string con toda la informacion existente en una red de metro.
     * Requerimiento Funciona 21
     * @return (String) con la informacion
     */
    @Override
    public String toString(){
        String str1 = "\n\n\t\tInformacion del SUBWAY\n" + "Nombre: " + getName() + "\nID: " + getId();
        //String datos trenes
        String str2 = "\nLista de estaciones:\n";
        for(Station_212788287_EspinozaBarria st : stationsMap.values()){
            str2 += "\t\t" + st.toString() + "\n";
        }

        str2 += "\nLista de secciones:\n";
        for(int sec : sectionsMap.keySet()){
            str2 += "\t\t {ID:"+sec+", Estacion1:"+sectionsMap.get(sec).getStation1().getName()+
                    ", \t\tEstacion2:"+sectionsMap.get(sec).getStation2().getName()+", Distancia(km)="+
                    sectionsMap.get(sec).getDistance()+", Costo:"+sectionsMap.get(sec).getCost()+ "}\n";
        }

        str2 += "\nLista de lineas:\n";
        for(Line_212788287_EspinozaBarria line : linesMap.values()){
            str2 +=  "\tLinea:\n"+line.toString() + "\n";
        }

        str2 = str2 +"\nLista de trenes:\n";
        for(Train_212788287_EspinozaBarria train : trainsMap.values()){
            str2 = str2 + train.toString() + "\n";
        }

        String str3 = "\nLista de conductores:\n";
        for(Driver_212788287_EspinozaBarria driver : driversMap.values()){
            str3 = str3 + "\t\t" + driver.toString() + "\n";
        }


        String str5 = "\nLista de asignaciones Trenes-Linea:\n";
        //for(AsignacionTrainLine_212788287_EspinozaBarria asig : asignacionesTrainLine){
        //    str5 = str5 + "\tAsignacionTrainLine:\n" + asig.toString() + "\n";
        //}

        for(double idsLineWithTrains : asignacionesTL.keySet()){
            str5 = str5 + "\tID Linea: " + idsLineWithTrains + ",      IDs Trenes:  [    ";
            for(Train_212788287_EspinozaBarria trenAsignado : asignacionesTL.get(idsLineWithTrains)){
                str5 = str5 + trenAsignado.getId() +"    ";
            }
            str5 = str5 + "]\n";
        }

        String str6 = "\nLista de recorridos Conductor-Tren:\n";
        for(RecorridoDriverTrain_212788287_EspinozaBarria reco :recorridosDriverTrain){
            str6 = str6 + "\t\t{" + reco.toString() + " }\n";
        }
        System.out.println("\n --- Se creo exitosamente el String con la informacion de subway en toString ---\n");
        return str1 + str2 + str3  + str5 + str6 + "\n";
    }



    /*
    public String toString(){
        String str1 = "\n\n\t\tInformacion del SUBWAY\n" + "Nombre: " + getName() + "\nID: " + getId();
        //String datos trenes
        String str2 = "\nLista de trenes:\n";
        for(Train_212788287_EspinozaBarria train : trains){
            str2 = str2 + train.toString() + "\n";
        }

        String str3 = "Lista de conductores:\n";
        for(Driver_212788287_EspinozaBarria driver : drivers){
            str3 = str3 + "\tConductor:\n\t" + driver.toString() + "\n\n";
        }

        String str4 = "Lista de lineas:\n";
        for(Line_212788287_EspinozaBarria line : lines){
            str4 = str4 + "\tLinea: \n" + line.toString() + "\n";
        }

        String str5 = "Lista de asignaciones Trenes-Linea:\n";
        //for(AsignacionTrainLine_212788287_EspinozaBarria asig : asignacionesTrainLine){
        //    str5 = str5 + "\tAsignacionTrainLine:\n" + asig.toString() + "\n";
        //}

        for(double idsLineWithTrains : asignacionesTL.keySet()){
            str5 = str5 + "\tID Linea: " + idsLineWithTrains + ",      IDs Trenes:  [    ";
            for(Train_212788287_EspinozaBarria trenAsignado : asignacionesTL.get(idsLineWithTrains)){
                str5 = str5 + trenAsignado.getId() +"    ";
            }
            str5 = str5 + "]\n";
        }

        String str6 = "\nLista de recorridos Conductor-Tren:\n";
        for(RecorridoDriverTrain_212788287_EspinozaBarria reco :recorridosDriverTrain){
            str6 = str6 + "\tRecorridoDriverTrain:\n" + reco.toString() + "\n";
        }
        System.out.println("\n --- Se creo exitosamente el String con la informacion de subway en toString ---\n");
        return str1 + str2 + str3 + str4 + str5 + str6 + "\n";
    }
     */



    /**
     * Asigna un tren a una linea especifica dentro de una red de metro. Crea instancias de la clase AsignacionTrainLine.
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
        //verificar que el tren no este asignado a una linea anteriormente
        //for(AsignacionTrainLine_212788287_EspinozaBarria asignacionActual : asignacionesTrainLine){
        //    if(asignacionActual.getTrains().contains(train)) {
        //        System.out.println("El tren ya esta asignado a una linea en el Subway. No se realizo la asignacion nueva");
        //        return;
        //    }
        //}
        //Verificar que el tren no este asignado a una linea anteriormente
        for(List<Train_212788287_EspinozaBarria> listaTrenesDeLinea : asignacionesTL.values()){
            if(listaTrenesDeLinea.contains(train)){
                System.out.println("El tren ya esta asignado a una linea en el Subway. No se realizo la asignacion nueva");
                return;
            }
        }

        //caso en que ya habian asignaciones en la linea determinada
        /*
        for(AsignacionTrainLine_212788287_EspinozaBarria asigActual : asignacionesTrainLine){
            if(asigActual.getIdLine() == line.getId()){
                List<Train_212788287_EspinozaBarria> trenesAux = asigActual.getTrains();
                trenesAux.add(train);
                asigActual.setTrains(trenesAux);
                System.out.println("\n --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n");
                return;
            }
        }*/
        //Caso en que ya habian asignaciones en la linea determinada
        for (double idsLineasDeAsignaciones : asignacionesTL.keySet()){
            if(line.getId() == idsLineasDeAsignaciones){//se encontro los trenes de la linea
                List<Train_212788287_EspinozaBarria> trenesAux = asignacionesTL.get(idsLineasDeAsignaciones);
                trenesAux.add(train);
                asignacionesTL.replace(idsLineasDeAsignaciones, trenesAux);
                System.out.println(" --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n");
                return;
            }
        }

        //caso en que sea la primera asignacion de tren de una linea
        //AsignacionTrainLine_212788287_EspinozaBarria asig =
        //        new AsignacionTrainLine_212788287_EspinozaBarria(line.getId(), new ArrayList<>(Arrays.asList(train)));
        //asignacionesTrainLine.add(asig);
        asignacionesTL.put(line.getId(), new ArrayList<>(Arrays.asList(train)));
        System.out.println(" --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n");
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
        recorridosDriverTrain.add(recorridoAux);
        System.out.println(" --- Se realizo la asignacion de recorrido Conductor-Tren correctamente al metro en assignDriverToTrain---\n");
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

        //buscamos el id de linea segun los trenes asignados en asignacionesTrainLine
        //for(AsignacionTrainLine_212788287_EspinozaBarria asignacionTL : asignacionesTrainLine){
        //    if(asignacionTL.getTrains().contains(trainsMap.get(idTrencito))){
        //        idLinea = asignacionTL.getIdLine();
        //    }
        //}
        for(double idLi : asignacionesTL.keySet()){
            if(asignacionesTL.get(idLi).contains(trainsMap.get(idTrencito))){
                idLinea = idLi;
            }
        }
        System.out.println(" --- Se encontro el tren correctamente en el metro en whereIsTrain ---\n");
        return "El tren se encuentra cerca de la Estacion  {" + estacionEncontrada +"}    de la linea ID:" + idLinea;
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
        //RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;
        Train_212788287_EspinozaBarria train = trainsMap.get(idTrencito);

        //notar que un tren puede tener multiples recorridos, por lo que se tiene que buscar el adecuado al horario preguntado
        //creamos sublista con todos los recorridos de un tren en especifico
        List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDelTren = new ArrayList<>();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorr : recorridosDriverTrain){
            if(recorr.getTrain().equals(train)){
                recorridosDelTren.add(recorr);
            }
        }
        //buscamos recorrido mas cercano al ingresado
        /*
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = recorridosDelTren.get(0);
        long diferenciaMenorActual = time.getTimeInMillis() - recorridoAux.getInicialDate().getTimeInMillis();
        System.out.println("dif menor1   "+ diferenciaMenorActual);
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorridoActual : recorridosDelTren){
            long diferenciaActual = time.getTimeInMillis() - recorridoActual.getInicialDate().getTimeInMillis();
            System.out.println("Dif actual  "+diferenciaActual);
            if( 0<diferenciaActual && diferenciaActual < diferenciaMenorActual){
                System.out.println("\n\t\t\t Caso     "+diferenciaActual+"  <   "+diferenciaMenorActual);
                diferenciaMenorActual = diferenciaActual;
                recorridoAux = recorridoActual;
            }
        }*/
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;
        long horaEnMiliSeg = time.getTimeInMillis();
        Long tiempoMasCercano = null;
        for(RecorridoDriverTrain_212788287_EspinozaBarria re : recorridosDelTren){
            if(re.getInicialDate().getTimeInMillis() < horaEnMiliSeg){
                if(tiempoMasCercano == null || re.getInicialDate().getTimeInMillis() > tiempoMasCercano){
                    tiempoMasCercano = re.getInicialDate().getTimeInMillis();
                    recorridoAux = re;
                }
            }
        }


        //System.out.println("Aca buscamos el recorrido cercanoo    "+recorridoAux);
        //buscamos el id de linea segun los trenes asignados en asignacionesTrainLine
        //for(AsignacionTrainLine_212788287_EspinozaBarria asignacionTL : asignacionesTrainLine){
        //    if(asignacionTL.getTrains().contains(train)){
        //        idLinea = asignacionTL.getIdLine();
        //    }
        //}
        //buscamos la linea segun el id encontrado anteriormente
        //for(int u=0; u<lines.size(); u++){
        //    if(lines.get(u).getId() == idLinea){
        //        lineAux = lines.get(u);
        //    }
        //}

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
            Section_212788287_EspinozaBarria sectAux = null;
            for(Section_212788287_EspinozaBarria seccionAc : subSectionsRecorridas){
                sectAux = new Section_212788287_EspinozaBarria(seccionAc.getStation2(),seccionAc.getStation1(),
                        seccionAc.getDistance(), seccionAc.getCost());
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
        long diferenciaActual;
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
            if(re.getInicialDate().getTimeInMillis() < horaEnMiliSeg){
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
        //System.out.println("n1: " + stationCercana.getName() + " yy    " + recorridoAux.getFinalStation().getName());
        //System.out.println(subSectionsRecorridas);
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
                        seccionAc.getDistance(), seccionAc.getCost());
                subSectionsInvertidas.add(0,sectAux);//progresivamente se construye la lista inversa
            }
            subSectionsRecorridas = subSectionsInvertidas;//se copia la lista invertida en la lista a calcular el tiempo
        }

        //crear lista de estaciones para retornar
        for(Section_212788287_EspinozaBarria seccionActFutura : subSectionsRecorridas){
            listaEstaciones.add(seccionActFutura.getStation2());//en cada section se agrega la estacion2 futura
        }

        System.out.println(" --- Se creo exitosamente la lista de estaciones futuras del recorrido en el metro en trainPath ---\n");
        return listaEstaciones;
    }




    public void addStationsByTXT(String archivo){
        try {
            //leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                String tipo = parts[2];
                int tiempo = Integer.parseInt(parts[3]);

                Station_212788287_EspinozaBarria station = new Station_212788287_EspinozaBarria(id, nombre, tipo, tiempo);
                //stationsMap.put(id, station);
                addStation(station);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente las estaciones a la red de metro al leer el archivo ---\n");

    }

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
                Section_212788287_EspinozaBarria section = new Section_212788287_EspinozaBarria(estacion1, estacion2, distancia, costo);
                //sectionsMap.put(id, section);
                addSection(id,section);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente las secciones a la red de metro al leer el archivo ---\n");
    }


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
                    //linesMap.put(id,lineaMetro);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente las lineas a la red de metro al leer el archivo ---\n");
    }


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
                Driver_212788287_EspinozaBarria driverActual = new Driver_212788287_EspinozaBarria(id,nombre,fabricanteTrenes);
                addDriver(driverActual);
                //driversMap.put(id, driverActual);

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente los conductores a la red de metro al leer el archivo ---\n");
    }


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
                    //passengerCarsMap.put(id,carro);
                    addPassengerCar(carro);
                }else{
                    CentralPCar_212788287_EspinozaBarria carro = new CentralPCar_212788287_EspinozaBarria(id,capacidad,modelo,tmaker);
                    //passengerCarsMap.put(id,carro);
                    addPassengerCar(carro);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente los carros a la red de metro al leer el archivo ---\n");
    }


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
                    //trainsMap.put(id,tren);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" --- Se agregaron exitosamente los trenes a la red de metro al leer el archivo ---\n");
    }

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
        System.out.println(" --- Se agregaron exitosamente las asignaciones tren-linea a la red de metro al leer el archivo ---\n");
    }


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
        System.out.println(" --- Se agregaron exitosamente los recorridos a la red de metro al leer el archivo ---\n");
    }


}
