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


        TerminalPCar_212788287_EspinozaBarria t1 = new TerminalPCar_212788287_EspinozaBarria(1,30,"MODELO1","Fender");
        CentralPCar_212788287_EspinozaBarria  t2 = new CentralPCar_212788287_EspinozaBarria(2,40,"MODELO1","Fender");
        CentralPCar_212788287_EspinozaBarria  t3 = new CentralPCar_212788287_EspinozaBarria(3,50,"MODELO1","Fender");
        TerminalPCar_212788287_EspinozaBarria t4 = new TerminalPCar_212788287_EspinozaBarria(4,9,"MODELO1","Fender");

        List<PassengerCar_212788287_EspinozaBarria> carros = new ArrayList<>(Arrays.asList(t1,t2,t3,t4));

        Train_212788287_EspinozaBarria tren1 = new Train_212788287_EspinozaBarria(1,"Fender","TipoA",90,carros);
        Train_212788287_EspinozaBarria tren2 = new Train_212788287_EspinozaBarria(2,"Fender","TipoB",200,carros);
        tren2.removeCar(1);
        if(tren1.isTrain()){
            System.out.println("Tren valido");
        }else{
            System.out.println("Tren IN       no valido");
        }

        Driver_212788287_EspinozaBarria dri1 = new Driver_212788287_EspinozaBarria(1,"PedroPiedra","Fender");
        Driver_212788287_EspinozaBarria dri2 = new Driver_212788287_EspinozaBarria(2,"David Bisbale","Fender");

        Subway_212788287_EspinozaBarria sw1 = new Subway_212788287_EspinozaBarria(1,"Metro Isaac");
        sw1.addLine(l1);
        sw1.addTrain(tren1);
        sw1.addTrain(tren2);
        sw1.addDriver(dri1);
        sw1.addDriver(dri2);


        Date fecha = new Date(2024,4,4,23,48);




    }
}