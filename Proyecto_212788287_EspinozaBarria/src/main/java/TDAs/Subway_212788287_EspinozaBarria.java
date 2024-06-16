package TDAs;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Subway es la abstraccion de una red de metro
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-16
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

    /**
     * Crea un string con toda la informacion existente en una red de metro.
     * Requerimiento Funciona 21
     * @return (String) con la informacion
     */
    @Override
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
        for(AsignacionTrainLine_212788287_EspinozaBarria asig : asignacionesTrainLine){
            str5 = str5 + "\tAsignacionTrainLine:\n" + asig.toString() + "\n";
        }

        String str6 = "\nLista de recorridos Conductor-Tren:\n";
        for(RecorridoDriverTrain_212788287_EspinozaBarria reco :recorridosDriverTrain){
            str6 = str6 + "\tRecorridoDriverTrain:\n" + reco.toString() + "\n";
        }
        System.out.println("\n --- Se creo exitosamente el String con la informacion de subway en toString ---\n");
        return str1 + str2 + str3 + str4 + str5 + str6 + "\n";
    }

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
        }else if(!trains.contains(train)) {//verificar existencia del tren en el subway
            System.out.println("El tren no existe en el Subway. No se realizo la asignacion");
            return;
        }else if(!lines.contains(line)) {//verificar existencia de la linea en el subway
            System.out.println("La linea no existe en el Subway. No se realizo la asignacion");
            return;
        }else if(!train.getTypeRail().equals(line.getTypeRail())) {//verificar compatibilidad de tipo de riel
            System.out.println("Incompatibilidad de tipos de riel. No se realizo la asignacion");
            return;
        }
        //verificar que el tren no este asignado a una linea anteriormente
        for(AsignacionTrainLine_212788287_EspinozaBarria asignacionActual : asignacionesTrainLine){
            if(asignacionActual.getTrains().contains(train)) {
                System.out.println("El tren ya esta asignado a una linea en el Subway. No se realizo la asignacion nueva");
                return;
            }
        }

        //caso en que ya habian asignaciones en la linea determinada
        for(AsignacionTrainLine_212788287_EspinozaBarria asigActual : asignacionesTrainLine){
            if(asigActual.getIdLine() == line.getId()){
                List<Train_212788287_EspinozaBarria> trenesAux = asigActual.getTrains();
                trenesAux.add(train);
                asigActual.setTrains(trenesAux);
                System.out.println("\n --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n");
                return;
            }
        }
        //caso en que sea la primera asignacion de tren de una linea
        AsignacionTrainLine_212788287_EspinozaBarria asig =
                new AsignacionTrainLine_212788287_EspinozaBarria(line.getId(), new ArrayList<>(Arrays.asList(train)));
        asignacionesTrainLine.add(asig);
        System.out.println("\n --- Se realizo la asignacion Tren-Linea correctamente al metro en assignTrainToLine---\n");
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
        recorridosDriverTrain.add(recorridoAux);
        System.out.println("\n --- Se realizo la asignacion de recorrido Conductor-Tren correctamente al metro en assignDriverToTrain---\n");
    }

    /**
     * Determina la informacion en String sobre la estacion mas cercana a un tren determinado en un recorrido segun un
     * horario ingresado. La busqueda de la estacion la realiza la funcion externa getStationWhereIsTrain, la
     * considera recorridos en ambos sentidos para las estaciones
     * Requerimiento Funcional 24
     * @param train Tren (Train) a consultar donde esta
     * @param time Fecha/Tiempo (GregorianCalendar) a consultar donde esta el tren
     * @return Informacion (String) de la estacion y la linea donde se encuentra el tren
     */
    public String whereIsTrain(Train_212788287_EspinozaBarria train, GregorianCalendar time) {
        int idLinea =0;
        Station_212788287_EspinozaBarria estacionEncontrada = getStationWhereIsTrain(train,time);

        //buscamos el id de linea segun los trenes asignados en asignacionesTrainLine
        for(AsignacionTrainLine_212788287_EspinozaBarria asignacionTL : asignacionesTrainLine){
            if(asignacionTL.getTrains().contains(train)){
                idLinea = asignacionTL.getIdLine();
            }
        }
        System.out.println("\n --- Se encontro el tren correctamente en el metro en whereIsTrain ---\n");
        return "El tren se encuentra cerda de la Estacion  {" + estacionEncontrada +"}    de la linea ID:" + idLinea;
    }

    /**
     * Busca la Estacion mas cercana a un tren a un recorrido determinado segun un horario ingresado. Considera
     * caso de recorrido normal de las sections y el caso de recorrido inverso
     * @param train Tren (Train) a consultar donde esta
     * @param time Fecha/Tiempo (GregorianCalendar) a consultar donde esta el tren
     * @return Estacion (Station) mas cercana al tren el horario ingresado
     */
    public Station_212788287_EspinozaBarria getStationWhereIsTrain(Train_212788287_EspinozaBarria train, GregorianCalendar time){
        int a=0, idLinea=-1;
        int sumaParcialSegundos, segundosRecorridoSection = 0, segundosStation2Section = 0;
        Line_212788287_EspinozaBarria lineAux = null;
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;

        //notar que un tren puede tener multiples recorridos, por lo que se tiene que buscar el adecuado al horario preguntado
        //creamos lista con todos los recorridos de un tren en especifico
        List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDelTren = new ArrayList<>();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorr : recorridosDriverTrain){
            if(recorr.getTrain().equals(train)){
                recorridosDelTren.add(recorr);
            }
        }
        //buscamos recorrido mas cercano al ingresado
        recorridoAux = recorridosDelTren.get(0);
        long diferenciaMenorActual = time.getTimeInMillis() - recorridoAux.getInicialDate().getTimeInMillis();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorridoActual : recorridosDelTren){
            long diferenciaActual = time.getTimeInMillis() - recorridoActual.getInicialDate().getTimeInMillis();
            if(diferenciaActual < diferenciaMenorActual){
                diferenciaMenorActual = diferenciaActual;
                recorridoAux = recorridoActual;
            }
        }

        //buscamos el id de linea segun los trenes asignados en asignacionesTrainLine
        for(AsignacionTrainLine_212788287_EspinozaBarria asignacionTL : asignacionesTrainLine){
            if(asignacionTL.getTrains().contains(train)){
                idLinea = asignacionTL.getIdLine();
            }
        }
        //buscamos la linea segun el id encontrado anteriormente
        for(int u=0; u<lines.size(); u++){
            if(lines.get(u).getId() == idLinea){
                lineAux = lines.get(u);
            }
        }
        //obtenemos secciones que efectivamente pertenecen al recorrido estipulado
        List<Section_212788287_EspinozaBarria> subSectionsRecorridas =
                lineAux.lineSubSectionsByNames(recorridoAux.getInicialStation().getName(),
                        recorridoAux.getFinalStation().getName());

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
     * @param train Tren (Train) a consultar
     * @param date Fecha/Tiempo (GregorianCalendar) a consultar el recorrido proximo
     * @return Lista de Estaciones (List&lt;Station&gt;)
     */
    public List<Station_212788287_EspinozaBarria> trainPath(Train_212788287_EspinozaBarria train, GregorianCalendar date){
        int idLinea=-1;
        Line_212788287_EspinozaBarria lineAux = null;
        RecorridoDriverTrain_212788287_EspinozaBarria recorridoAux = null;
        List<Station_212788287_EspinozaBarria> listaEstaciones = new ArrayList<>();

        //buscamos recorrido Adecuando para tren en el horario determinado
        List<RecorridoDriverTrain_212788287_EspinozaBarria> recorridosDelTren = new ArrayList<>();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorr : recorridosDriverTrain){
            if(recorr.getTrain().equals(train)){ recorridosDelTren.add(recorr); }
        }
        //buscamos recorrido mas cercano al ingresado
        recorridoAux = recorridosDelTren.get(0);
        long diferenciaMenorActual = date.getTimeInMillis() - recorridoAux.getInicialDate().getTimeInMillis();
        for(RecorridoDriverTrain_212788287_EspinozaBarria recorridoActual : recorridosDelTren){
            long diferenciaActual = date.getTimeInMillis() - recorridoActual.getInicialDate().getTimeInMillis();
            if(diferenciaActual < diferenciaMenorActual){
                diferenciaMenorActual = diferenciaActual;
                recorridoAux = recorridoActual;
            }
        }

        //buscamos el id de linea segun los trenes asignados en asignacionesTrainLine
        for(AsignacionTrainLine_212788287_EspinozaBarria asignacionTL : asignacionesTrainLine){
            if(asignacionTL.getTrains().contains(train)){
                idLinea = asignacionTL.getIdLine();
            }
        }
        //buscamos la linea segun el id encontrado anteriormente
        for(int u=0; u<lines.size(); u++){
            if(lines.get(u).getId() == idLinea){
                lineAux = lines.get(u);
            }
        }

        //obtenemos estacion mas cercana en el recorrido segun el horario
        Station_212788287_EspinozaBarria stationCercana = getStationWhereIsTrain(train,date);

        //obtenemos secciones futuras al recorrido den tren
        List<Section_212788287_EspinozaBarria> subSectionsRecorridas =
                lineAux.lineSubSectionsByNames(stationCercana.getName(), recorridoAux.getFinalStation().getName());

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

        System.out.println("\n --- Se creo exitosamente la lista de estaciones futuras del recorrido en el metro en trainPath ---\n");
        return listaEstaciones;
    }






}
