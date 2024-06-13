package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Line_212788287_EspinozaBarria {

    //Atributos
    private int id;
    private String name;
    private String typeRail;
    private List<Section_212788287_EspinozaBarria> sections;



    //Constructores
    public Line_212788287_EspinozaBarria() {}
    public Line_212788287_EspinozaBarria(int id, String name, String typeRail, List<Section_212788287_EspinozaBarria> sections) {
        this.id = id;
        this.name = name;
        this.typeRail = typeRail;
        this.sections = sections;
    }



    //Metodos
    //getters, setters y funcion de pertenecia
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
    public double lineLength(){
        double distanciaTotal = 0;
        for(Section_212788287_EspinozaBarria seccionAct : sections){
            System.out.println(seccionAct);
            distanciaTotal = distanciaTotal + seccionAct.getDistance();
        }
        return distanciaTotal;
    }


    public List<Section_212788287_EspinozaBarria> lineSubSectionsByNames(String nameSt1, String nameSt2){
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


    public double lineSectionLength(String nameSt1, String nameSt2){
        List<Section_212788287_EspinozaBarria> subSections = lineSubSectionsByNames(nameSt1, nameSt2);
        double distancia = 0;
        for(Section_212788287_EspinozaBarria seccion : subSections){
            distancia = distancia + seccion.getDistance();
        }
        return distancia;
    }


    public double lineCost(){
        double costoTotal = 0;
        for(Section_212788287_EspinozaBarria seccion : sections){
            costoTotal = costoTotal + seccion.getCost();
        }
        return costoTotal;
    }


    public double lineSectionCost(String nameSt1, String nameSt2){
        List<Section_212788287_EspinozaBarria> subSections = lineSubSectionsByNames(nameSt1, nameSt2);
        double costo = 0;
        for(Section_212788287_EspinozaBarria seccion : subSections){
            costo = costo + seccion.getCost();
        }
        return costo;
    }


    public void lineAddSection(Section_212788287_EspinozaBarria seccion){
        if(sections.isEmpty()){
            sections.add(seccion);
        }else if(sections.get(sections.size()-1).getStation2().equals(seccion.getStation1())){
            sections.add(seccion);
        }else{
            System.out.println("La seccion ingresada no esta conectada con la seccion anterior. No se agrego la section a la line");
        }
    }

    public boolean isLine(){
        return isRegularLine() || isCircularLine();
    }

    public boolean isRegularLine(){
        //verifica stations conectadas y stations terminales validas, ademas de que las centrales sean validas, tipo r  c
        return allSectionsConected() && hasSectionsWithTerminalStations() && verificarSectionsWithValidTypeStation();
    }

    public boolean isCircularLine(){
        //resultado de la compraracion entre la st1 del primer elemento y la st2 del ultimo elemento
        boolean b =  sections.get(0).getStation1().equals(sections.get(sections.size()-1).getStation2());
        return allSectionsConected() && b;
    }

    public boolean allSectionsConected(){
        //aunque al agregar sections con addSection verifica que las estaciones esten contiguas, si se modifican las sections.
        //mediante un setter o el constructor, no se verifica si estas estan conectadas. Por eso, es necesario este metodo
        List<Section_212788287_EspinozaBarria> secciones = sections;
        Station_212788287_EspinozaBarria stationAnterior;
        for(int i = 1; i < secciones.size(); i++){
            stationAnterior = secciones.get(i-1).getStation2(); //la station2 anterior de la lista sections
            if(!(secciones.get(i).getStation1().equals(stationAnterior))){
                return false;
            }
        }
        return true;
    }

    public boolean hasSectionsWithTerminalStations(){
        //consideramos todos los casos para estaciones terminales, dado que tienen o no estaciones de mantencion
        //en el caso de terminar en estaciones m, la estacion anterior debe ser del tipo t
        return verificarInicioSectionsTerminalStation() && verificarFinalSectionsTerminalStation();
    }

    public boolean verificarInicioSectionsTerminalStation(){
        if(sections.get(0).getStation1().getType().equals("t") && !(sections.get(0).getStation2().getType().equals("t"))){
            return true;
        } else if(sections.get(0).getStation1().getType().equals("m") && sections.get(0).getStation2().getType().equals("t")){
            return true;
        } else {//caso en que sean de otro tipo ,o que no sea del tipo t ,o no sea tipo m-t
            return false;
        }
    }

    public boolean verificarFinalSectionsTerminalStation(){
        if(sections.get(sections.size()-1).getStation2().getType().equals("t") &&
                !(sections.get(sections.size()-1).getStation1().getType().equals("t"))){
            return true;
        } else if(sections.get(sections.size()-1).getStation2().getType().equals("m") &&
                sections.get(sections.size()-1).getStation1().getType().equals("t")) {
            return true;
        } else{//caso en que sean de otro tipo ,o que no sea del tipo t ,o no sea tipo m-t
            return false;
        }
    }

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


}