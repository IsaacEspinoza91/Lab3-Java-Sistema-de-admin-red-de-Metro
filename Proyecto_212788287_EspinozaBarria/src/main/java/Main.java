import TDAs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println("Prueba de ejecucion gradlew en la terminal");

        /*
        Station_212788287_EspinozaBarria st1 = null;
        try {
            st1 = new Station_212788287_EspinozaBarria(1, "USACH", "t", -3);
            //System.out.println(st1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Station: "+ e.getMessage());;
        }*/
        Station_212788287_EspinozaBarria st1 = new Station_212788287_EspinozaBarria(1, "USACH", "t", 10);
        Station_212788287_EspinozaBarria st2 = new Station_212788287_EspinozaBarria(2,"Estacion Central","r",230);
        Station_212788287_EspinozaBarria st3 = new Station_212788287_EspinozaBarria(3,"ULA","c",100);
        Station_212788287_EspinozaBarria st4 = new Station_212788287_EspinozaBarria(4,"Republica","c",99);
        Station_212788287_EspinozaBarria st5 = new Station_212788287_EspinozaBarria(5,"Los Heroes","t",300);

        Section_212788287_EspinozaBarria s1 = new Section_212788287_EspinozaBarria(st1,st2,6,8);
        Section_212788287_EspinozaBarria s2 = new Section_212788287_EspinozaBarria(st2,st3,5,49);
        Section_212788287_EspinozaBarria s3 = new Section_212788287_EspinozaBarria(st3,st4,2,343);
        Section_212788287_EspinozaBarria s4 = new Section_212788287_EspinozaBarria(st4,st5,4,45);
        //List<Section_212788287_EspinozaBarria> seccionesL1 = new ArrayList<>(Arrays.asList(s1,s2,s3,s4));
        List<Section_212788287_EspinozaBarria> seccionesL1 = new ArrayList<>();



        Line_212788287_EspinozaBarria l1 = new Line_212788287_EspinozaBarria(1,"Linea1","TipoA",seccionesL1);
        l1.lineAddSection(s1);
        l1.lineAddSection(s2);
        l1.lineAddSection(s3);
        l1.lineAddSection(s4);

        var alo = l1.lineLength();
        System.out.println("LA DISTANCIA ES: " +alo);
        List<Section_212788287_EspinozaBarria> subSec = l1.lineSubSectionsByNames("Republica","Estacion Central");
        System.out.println(subSec);
        var subDistancia = l1.lineSectionLength("Republica","Estacion Central");
        System.out.println("\n\tLa subdistancia es  " + subDistancia);
        var costoLinea = l1.lineCost();
        System.out.println("\n\tCosto de Linea: " + costoLinea);

        if (l1.isLine()){
            System.out.println("verdasddd");
        }else {
            System.out.println("mfsdnafkdfs");
        }




    }
}