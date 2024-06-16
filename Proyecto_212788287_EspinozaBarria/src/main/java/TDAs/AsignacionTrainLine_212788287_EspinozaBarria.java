package TDAs;

import java.util.ArrayList;
import java.util.List;

/**
 * AsignacionesTrainLine es una clase que representa a un objeto que relaciona la ID de un Line con sus trenes
 * @author isaac
 * @version 1.0 Java 11
 * @since 2024-06-16
 */
public class AsignacionTrainLine_212788287_EspinozaBarria {

    //Atributos
    private int idLine;
    private List<Train_212788287_EspinozaBarria> trains;



    //Constructor
    /**
     * Constructor de un objeto AsignacionesTrainLine
     * @param idLine Identificador (int) de una Line
     * @param trains Trenes asociados a la Line (List&lt;Train&gt;)
     */
    public AsignacionTrainLine_212788287_EspinozaBarria(int idLine, List<Train_212788287_EspinozaBarria> trains) {
        this.idLine = idLine;
        this.trains = trains;
    }


    //Metodos
    //getters y setters
    public int getIdLine() {
        return idLine;
    }
    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public List<Train_212788287_EspinozaBarria> getTrains() {
        return trains;
    }
    public void setTrains(List<Train_212788287_EspinozaBarria> trains) {
        this.trains = trains;
    }



    //Otros metodos
    @Override
    public String toString() {
        String str = "\tID Linea: " + idLine + ",      IDs Trenes:  [  ";
        for(Train_212788287_EspinozaBarria train : trains){
            str = str + train.getId() + "  ";
        }
        return str + "]";
    }
}
