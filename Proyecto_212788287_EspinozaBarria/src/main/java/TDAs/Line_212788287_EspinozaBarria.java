package TDAs;

import java.util.ArrayList;
import java.util.List;

/**
 * Line es una abstraccion de una linea de estaciones de un sistema de metro.
 * @author Isaac Espinoza
 * @version 2.0 en Java 11
 * @since 2024-06-13
 */
public class Line_212788287_EspinozaBarria {

    //Atributos
    private double id;
    private String name;
    private String typeRail;
    private List<Section_212788287_EspinozaBarria> sections;



    //Constructor
    /**
     * Constructor de un objeto Line.
     * Requerimiento Funcional 3
     * @param id Identificador (double) de una Line
     * @param name Nombre (String) de una Line
     * @param typeRail Tipo de riel (String) de una Line
     * @param sections Lista de secciones (List&lt;Section&gt;) de una Line
     */
    public Line_212788287_EspinozaBarria(double id, String name, String typeRail, List<Section_212788287_EspinozaBarria> sections) {
        this.id = id;
        this.name = name;
        this.typeRail = typeRail;
        this.sections = sections;
        System.out.println(" --- Se creo exitosamente el objeto Line ---");
    }



    //Metodos
    //getters y setters
    public double getId() {
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

    public String getTypeRail() {
        return typeRail;
    }
    public void setTypeRail(String typeRail) {
        this.typeRail = typeRail;
    }

    public List<Section_212788287_EspinozaBarria> getSections() {
        return sections;
    }
    public void setSections(List<Section_212788287_EspinozaBarria> sections) {
        this.sections = sections;
    }




    //otros metodos
    /**
     * Determina el largo en Km de una Line de metro.
     * Requerimiento Funcional 4
     * @return Largo (double) en Km de una Line
     */
    public double lineLength(){
        double distanciaTotal = 0;
        for(Section_212788287_EspinozaBarria seccionAct : sections){
            distanciaTotal = distanciaTotal + seccionAct.getDistance();
        }
        System.out.println(" --- Se calculo exitosamente la distancia total de la linea en lineLength ---\n");
        return distanciaTotal;
    }

    /**
     * Obtiene una subLista de Sections entre dos Stations especificas segun sus nombres.
     * La funcion considera todos los casos sin importar el orden de las Stations dentro de sections
     * @param nameSt1 Nombre de la Station1 (String)
     * @param nameSt2 Nombre de la Station2 (String)
     * @return SubLista de Sections (List&lt;Section&gt;)
     */
    public List<Section_212788287_EspinozaBarria> lineSubSectionsByNames(String nameSt1, String nameSt2){
        if(nameSt1.equals(nameSt2)){
            return null;
        }
        List<Section_212788287_EspinozaBarria> seccionesEntreStations =  new ArrayList<>();
        boolean estacionInicialEncontrada = false;
        for(Section_212788287_EspinozaBarria seccionAct : sections){
            //caso base en que las estaciones sean contiguas
            if(seccionAct.getStation1().getName().equals(nameSt1) && seccionAct.getStation2().getName().equals(nameSt2) ||
                    seccionAct.getStation1().getName().equals(nameSt2) && seccionAct.getStation2().getName().equals(nameSt1)){
                seccionesEntreStations.add(seccionAct);
                break; //se para la iteracion porque no hay estaciones entre ambas estaciones

                //caso de encontrar la primera coincidencia de nombres de st1 o st2
            } else if(seccionAct.getStation1().getName().equals(nameSt1) ||
                    seccionAct.getStation1().getName().equals(nameSt2)){
                estacionInicialEncontrada = true;
                seccionesEntreStations.add(seccionAct);

                //caso de que la bandera sea true, y se busca la segunda estacion
            } else if(estacionInicialEncontrada){ //ya se encontro la primera estacion
                if(seccionAct.getStation2().getName().equals(nameSt1) ||
                        seccionAct.getStation2().getName().equals(nameSt2)){
                    seccionesEntreStations.add(seccionAct);
                    break;

                }else{//si no se encuentra la estacion, se agrega la section a la lista
                    seccionesEntreStations.add(seccionAct); //mientras no se encuentre la estacion segunda, se agregan al list
                }
            }
        }
        return seccionesEntreStations;
    }

    /**
     * Determina el largo en Km de una un sub tramo entre dos Stations especificadas por nombre.
     * La funcion considera todos los casos sin importar que Station aparece primero en Sections.
     * Requerimiento Funcional 5
     * @param nameSt1 Nombre de la Station1 (String)
     * @param nameSt2 Nombre de la Station2 (String)
     * @return Largo (double) en Km entre las dos Stations
     */
    public double lineSectionLength(String nameSt1, String nameSt2){
        List<Section_212788287_EspinozaBarria> subSections = lineSubSectionsByNames(nameSt1, nameSt2);
        double distancia = 0;
        for(Section_212788287_EspinozaBarria seccion : subSections){
            distancia = distancia + seccion.getDistance();
        }
        System.out.println(" --- Se calculo exitosamente la distancia entre estaciones de la linea en lineSectionLength ---");
        return distancia;
    }

    /**
     * Determina el costo total de recorrer una Line.
     * Requerimiento Funcional 6
     * @return costo (double) de Line
     */
    public double lineCost(){
        double costoTotal = 0;
        for(Section_212788287_EspinozaBarria seccion : sections){
            costoTotal = costoTotal + seccion.getCost();
        }
        System.out.println(" --- Se calculo exitosamente el costo total de la linea en lineCost ---");
        return costoTotal;
    }

    /**
     * Determina el costo de un sub tramo entre dos Stations especificadas por nombre.
     * Requerimiento Funcional 7
     * @param nameSt1 Nombre de la Station1 (String)
     * @param nameSt2 Nombre de la Station2 (String)
     * @return Costo (double) del sub Tramo entre Stations
     */
    public double lineSectionCost(String nameSt1, String nameSt2){
        List<Section_212788287_EspinozaBarria> subSections = lineSubSectionsByNames(nameSt1, nameSt2);
        double costo = 0;
        for(Section_212788287_EspinozaBarria seccion : subSections){
            costo = costo + seccion.getCost();
        }
        System.out.println(" --- Se calculo exitosamente el costo entre estaciones de la linea en lineSectionCost ---");
        return costo;
    }

    /**
     * Agrega un elemento Section a la sections (Lista de Section) del objeto. Considera compatibilidad
     * de Section, por lo que si se intenta agregar una Section imcompatible, es decir, una Section que no
     * continua a la existente en sections, la funcion no realiza nada.
     * Requerimiento Funcional 8
     * @param seccion Elemento Section a agregar
     */
    public void lineAddSection(Section_212788287_EspinozaBarria seccion){
        if(sections.isEmpty()){
            sections.add(seccion);
            System.out.println(" --- Se agrego exitosamente la seccion a la linea en lineAddSection ---");
        }else if(sections.get(sections.size()-1).getStation2().equals(seccion.getStation1())){
            sections.add(seccion);
            System.out.println(" --- Se agrego exitosamente la seccion a la linea en lineAddSection ---");
        }else{
            System.out.println("La seccion ingresada no esta conectada con la seccion anterior. No se agrego la section a la line");
        }
    }

    /**
     * Verifica si una Line es efectivamente una Line valida. Analiza si es linea directa o linea circular, verifica
     * que todas las Stations esten conectadas y que tenga una estructura valida, es decir, que no existan Stations
     * terminales en el centro y los extremos sean tipo terminal, o terminal y mantencion.
     * Requerimiento Funcional 9
     * @return Resultado booleano
     */
    public boolean isLine(){
        System.out.println(" --- Se verifico exitosamente si la line es valida en isLine ---");
        return isDirectLine() || isCircularLine();
    }

    /**
     * Verifica que una Line cumpla con los criterior de Line directa, considerando que todas las Sections esten conectadas
     * y que sean validos las estructuras de las Stations
     * @return Resultado booleano
     */
    public boolean isDirectLine(){
        //verifica stations conectadas y stations terminales validas, ademas de que las centrales sean validas, tipo r  c
        return allSectionsConected() && hasSectionsWithTerminalStations() && verificarSectionsWithValidTypeStation();
    }

    /**
     * Verifica que una Line cumpla con que sea un linea cicular, verifica que todas las Sections esten conectadas y
     * tanto la primera como la ultima Station de sections sean el mismo objeto.
     * @return Resultado booleano
     */
    public boolean isCircularLine(){
        //resultado de la compraracion entre la st1 del primer elemento y la st2 del ultimo elemento
        boolean b =  sections.get(0).getStation1().equals(sections.get(sections.size()-1).getStation2());
        return allSectionsConected() && b;
    }

    /**
     * Verifica que todas las sections de la Line esten correctamente conectadas.
     * @return Resultado booleano
     */
    public boolean allSectionsConected(){
        //aunque al agregar sections con addSection verifica que las estaciones esten contiguas, si se modifican las sections.
        //mediante un setter o el constructor, no se verifica si estas estan conectadas. Por eso, es necesario este metodo
        Station_212788287_EspinozaBarria stationAnterior;
        for(int i = 1; i < sections.size(); i++){
            stationAnterior = sections.get(i-1).getStation2(); //la station2 anterior de la lista sections
            if(!(sections.get(i).getStation1().equals(stationAnterior))){
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica que las Stations extremas de las sections de una Line sean validas, es decir, que sean tipo
     * terminal, o que sean terminal y la siguiente mantencion
     * @return Resultado booleano
     */
    public boolean hasSectionsWithTerminalStations(){
        //consideramos todos los casos para estaciones terminales, dado que tienen o no estaciones de mantencion
        //en el caso de terminar en estaciones m, la estacion anterior debe ser del tipo t
        return verificarInicioSectionsTerminalStation() && verificarFinalSectionsTerminalStation();
    }

    /**
     * Verifica que el inicio de sections de una Line sea valido considerando los tipos de Station terminal, o terminal y mantencion
     * Considerando caso terminal o combinacion, o caso mantencion y el siguiente es terminal o combinacion
     * @return Resultado booleano
     */
    public boolean verificarInicioSectionsTerminalStation(){
        if((sections.get(0).getStation1().getType().equals("t") || sections.get(0).getStation1().getType().equals("c"))
                && !(sections.get(0).getStation2().getType().equals("t"))){
            return true;
        } else if(sections.get(0).getStation1().getType().equals("m") &&
                (sections.get(0).getStation2().getType().equals("t") || sections.get(0).getStation2().getType().equals("c"))){
            return true;
        } else {//caso en que sean de otro tipo ,o que no sea del tipo t ,o no sea tipo m-t
            return false;
        }
    }

    /**
     * Verifica que el final de sections de una Line sea valido considerando los tipos de Station terminal, o terminal y mantencion.
     * Considerando caso terminal o combinacion, o caso mantencion y el siguiente es terminal o combinacion
     * @return Resultado booleano
     */
    public boolean verificarFinalSectionsTerminalStation(){
        if((sections.get(sections.size()-1).getStation2().getType().equals("t") ||
                sections.get(sections.size()-1).getStation2().getType().equals("c")) //estacion final es termi o combi
                && !(sections.get(sections.size()-1).getStation1().getType().equals("t"))){
            return true;
        } else if(sections.get(sections.size()-1).getStation2().getType().equals("m") &&
                (sections.get(sections.size()-1).getStation1().getType().equals("t")
                        || sections.get(sections.size()-1).getStation1().getType().equals("c")) ){
            return true;
        } else{//caso en que sean de otro tipo ,o que no sea del tipo t ,o no sea tipo m-t
            return false;
        }
    }

    /**
     * Verifica que todas las Stations no extremas de sections sean validas, es decir, que sean regular o combinacion
     * @return Resultado booleano
     */
    public boolean verificarSectionsWithValidTypeStation(){
        for(int i = 2; i < sections.size()-1; i++){ //analizamos solo las sections centrales, sin la primera, la segunda ni la ultima
            if(sections.get(i).getStation1().getType().equals("t") || sections.get(i).getStation1().getType().equals("m")){
                return false;//caso en que en las station del centro de sections hay alguna tipo t o m
            }
        }
        //verificacion caso de que la estacion antepenuntima al inicio o final sea valida, puede ser t, r, c. No tipo m
        if(sections.get(0).getStation2().getType().equals("m") || sections.get(sections.size()-1).getStation1().getType().equals("m")){
            return false;
        }
        return true;//Es true solo en el caso que las anteriores a la ultima station sean distintas de m, y que las centrales sean r ,o c.
    }



    @Override
    public String toString() {
        String str = "\t\tID: " + id + " " + name + ", Tipo de Riel: "+ typeRail +"\n\t\tSecciones:\n";
        for(Section_212788287_EspinozaBarria seccion : sections){
            str += "\t\t\t"+seccion.toString() ;
        }
        return str;
    }

}