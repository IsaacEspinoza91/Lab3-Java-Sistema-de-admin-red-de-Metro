import TDAs.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Subway_212788287_EspinozaBarria sw = new Subway_212788287_EspinozaBarria(1,"METRO ISKAITO");
        sw.addStationsByTXT("stations.txt");
        sw.addSectionsByTXT("sections.txt");
        sw.addLinesByTXT("lines.txt");
        sw.addDriversByTXT("drivers.txt");
        sw.addPassengerCarsByTXT("passengerCars.txt");
        sw.addTrainsByTXT("trains.txt");
        sw.addAsignacionesTrainLineByTXT("asignacionesTrainLine.txt");
        sw.addRecorridosByTXT("recorridos.txt");


        System.out.println(sw);

        System.out.println(sw.whereIsTrain(2, new GregorianCalendar(2024,6,20,21,50)));
        System.out.println(sw.trainPath(2,new GregorianCalendar(2024,6,20,21,50)));
    }




}