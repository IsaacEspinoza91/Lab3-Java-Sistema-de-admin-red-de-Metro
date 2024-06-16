import TDAs.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {


        //Datos de prueba L1
        Station_212788287_EspinozaBarria st0 = new Station_212788287_EspinozaBarria(0, "San Pablo", "t", 90);
        Station_212788287_EspinozaBarria st1 = new Station_212788287_EspinozaBarria(1, "Neptuno", "r", 45);
        Station_212788287_EspinozaBarria st2 = new Station_212788287_EspinozaBarria(2, "Pajaritos", "c", 45);
        Station_212788287_EspinozaBarria st3 = new Station_212788287_EspinozaBarria(3, "Las Rejas", "r", 45);
        Station_212788287_EspinozaBarria st4 = new Station_212788287_EspinozaBarria(4, "Ecuador", "r", 60);
        Station_212788287_EspinozaBarria st5 = new Station_212788287_EspinozaBarria(5, "San Alberto Hurtado", "r", 40);
        Station_212788287_EspinozaBarria st6 = new Station_212788287_EspinozaBarria(6, "USACH", "c", 40);
        Station_212788287_EspinozaBarria st7 = new Station_212788287_EspinozaBarria(7, "Estacion Central", "c", 50);
        Station_212788287_EspinozaBarria st8 = new Station_212788287_EspinozaBarria(8, "Union Latinoamericana", "r", 30);
        Station_212788287_EspinozaBarria st9 = new Station_212788287_EspinozaBarria(9, "Republica", "r", 40);
        Station_212788287_EspinozaBarria st10 = new Station_212788287_EspinozaBarria(10, "Los Heroes", "c", 60);
        Station_212788287_EspinozaBarria st11 = new Station_212788287_EspinozaBarria(11, "La Moneda", "r", 40);
        Station_212788287_EspinozaBarria st12 = new Station_212788287_EspinozaBarria(12, "Universidad de Chile", "c", 90);
        Station_212788287_EspinozaBarria st13 = new Station_212788287_EspinozaBarria(13, "Santa Lucia", "r", 40);
        Station_212788287_EspinozaBarria st14 = new Station_212788287_EspinozaBarria(14, "Universidad Catolica", "c", 60);
        Station_212788287_EspinozaBarria st15 = new Station_212788287_EspinozaBarria(15, "Baquedano", "r", 40);
        Station_212788287_EspinozaBarria st16 = new Station_212788287_EspinozaBarria(16, "Salvador", "r", 30);
        Station_212788287_EspinozaBarria st17 = new Station_212788287_EspinozaBarria(17, "Manuel Montt", "r", 30);
        Station_212788287_EspinozaBarria st18 = new Station_212788287_EspinozaBarria(18, "Pedro de Valdivia", "r", 30);
        Station_212788287_EspinozaBarria st19 = new Station_212788287_EspinozaBarria(19, "Los Leones", "c", 60);
        Station_212788287_EspinozaBarria st20 = new Station_212788287_EspinozaBarria(20, "Tobalada", "r", 45);
        Station_212788287_EspinozaBarria st21 = new Station_212788287_EspinozaBarria(21, "El Golf", "r", 30);
        Station_212788287_EspinozaBarria st22 = new Station_212788287_EspinozaBarria(22, "Alcantara", "r", 30);
        Station_212788287_EspinozaBarria st23 = new Station_212788287_EspinozaBarria(23, "Escuela Militar", "r", 30);
        Station_212788287_EspinozaBarria st24 = new Station_212788287_EspinozaBarria(24, "Manquehue", "r", 30);
        Station_212788287_EspinozaBarria st25 = new Station_212788287_EspinozaBarria(25, "Hernando de Magallanes", "r", 30);
        Station_212788287_EspinozaBarria st26 = new Station_212788287_EspinozaBarria(26, "Los Dominicos", "t", 90);
        Station_212788287_EspinozaBarria st27 = new Station_212788287_EspinozaBarria(27, "Cochera", "m", 3600);


        // Definición de las secciones
        Section_212788287_EspinozaBarria s1 = new Section_212788287_EspinozaBarria(st0, st1, 2.5, 55);
        Section_212788287_EspinozaBarria s2 = new Section_212788287_EspinozaBarria(st1, st2, 1.5, 30);
        Section_212788287_EspinozaBarria s3 = new Section_212788287_EspinozaBarria(st2, st3, 3, 45);
        Section_212788287_EspinozaBarria s4 = new Section_212788287_EspinozaBarria(st3, st4, 2, 40);
        Section_212788287_EspinozaBarria s5 = new Section_212788287_EspinozaBarria(st4, st5, 2.5, 50);
        Section_212788287_EspinozaBarria s6 = new Section_212788287_EspinozaBarria(st5, st6, 1, 20);
        Section_212788287_EspinozaBarria s7 = new Section_212788287_EspinozaBarria(st6, st7, 1.5, 25);
        Section_212788287_EspinozaBarria s8 = new Section_212788287_EspinozaBarria(st7, st8, 2, 30);
        Section_212788287_EspinozaBarria s9 = new Section_212788287_EspinozaBarria(st8, st9, 2.3, 20);
        Section_212788287_EspinozaBarria s10 = new Section_212788287_EspinozaBarria(st9, st10, 3.5, 25);
        Section_212788287_EspinozaBarria s11 = new Section_212788287_EspinozaBarria(st10, st11, 1, 20);
        Section_212788287_EspinozaBarria s12 = new Section_212788287_EspinozaBarria(st11, st12, 1.5, 25);
        Section_212788287_EspinozaBarria s13 = new Section_212788287_EspinozaBarria(st12, st13, 1.8, 20);
        Section_212788287_EspinozaBarria s14 = new Section_212788287_EspinozaBarria(st13, st14, 1.5, 25);
        Section_212788287_EspinozaBarria s15 = new Section_212788287_EspinozaBarria(st14, st15, 2, 30);
        Section_212788287_EspinozaBarria s16 = new Section_212788287_EspinozaBarria(st15, st16, 2.5, 20);
        Section_212788287_EspinozaBarria s17 = new Section_212788287_EspinozaBarria(st16, st17, 1.5, 25);
        Section_212788287_EspinozaBarria s18 = new Section_212788287_EspinozaBarria(st17, st18, 1, 20);
        Section_212788287_EspinozaBarria s19 = new Section_212788287_EspinozaBarria(st18, st19, 1.3, 25);
        Section_212788287_EspinozaBarria s20 = new Section_212788287_EspinozaBarria(st19, st20, 2, 30);
        Section_212788287_EspinozaBarria s21 = new Section_212788287_EspinozaBarria(st20, st21, 3, 20);
        Section_212788287_EspinozaBarria s22 = new Section_212788287_EspinozaBarria(st21, st22, 1.5, 25);
        Section_212788287_EspinozaBarria s23 = new Section_212788287_EspinozaBarria(st22, st23, 2.7, 30);
        Section_212788287_EspinozaBarria s24 = new Section_212788287_EspinozaBarria(st23, st24, 1, 20);
        Section_212788287_EspinozaBarria s25 = new Section_212788287_EspinozaBarria(st24, st25, 1.5, 25);
        Section_212788287_EspinozaBarria s26 = new Section_212788287_EspinozaBarria(st25, st26, 2, 30);
        Section_212788287_EspinozaBarria s27 = new Section_212788287_EspinozaBarria(st26, st27, 5, 0);

        //Linea 1
        List<Section_212788287_EspinozaBarria> seccionesL1 = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6,
                s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25));
        Line_212788287_EspinozaBarria l1 = new Line_212788287_EspinozaBarria(1,"Linea 1","100 R.E.",seccionesL1);
        l1.lineAddSection(s26);
        l1.lineAddSection(s27);
        if(l1.isLine()){
            System.out.println("L1 valida");
        }
        System.out.println("L1 largo total:" + l1.isLine() +"km");
        System.out.printf("L1 largo entre USACH y Los Heroes", l1.lineSectionLength("USACH","Los Heroes"));
        System.out.printf("L1 costo entre Los Heroes y Usach", l1.lineSectionLength("Los Heroes","USACH"));
        System.out.println("L1 Costo total: " + l1.lineCost());
        System.out.printf("L1 costo entre Los Heroes y Usach", l1.lineSectionCost("Los Heroes","USACH"));

        //creacion carros
        //para Tren 1
        CentralPCar_212788287_EspinozaBarria pc0 = new CentralPCar_212788287_EspinozaBarria(0,90,"NS-74","CAF");
        TerminalPCar_212788287_EspinozaBarria pc1 = new TerminalPCar_212788287_EspinozaBarria(1,100,"NS-74","CAF");
        TerminalPCar_212788287_EspinozaBarria pc2 = new TerminalPCar_212788287_EspinozaBarria(2,150,"NS-74","CAF");
        CentralPCar_212788287_EspinozaBarria pc3 = new CentralPCar_212788287_EspinozaBarria(3,90,"NS-74","CAF");

        //Para Tren 2
        CentralPCar_212788287_EspinozaBarria pc4 = new CentralPCar_212788287_EspinozaBarria(4,100,"AS-2016","CAF");
        CentralPCar_212788287_EspinozaBarria pc5 = new CentralPCar_212788287_EspinozaBarria(5,100,"AS-2016","CAF");
        CentralPCar_212788287_EspinozaBarria pc6 = new CentralPCar_212788287_EspinozaBarria(6,100,"AS-2016","CAF");
        TerminalPCar_212788287_EspinozaBarria pc7 = new TerminalPCar_212788287_EspinozaBarria(7,110,"AS-2016","CAF");
        TerminalPCar_212788287_EspinozaBarria pc8 = new TerminalPCar_212788287_EspinozaBarria(8,110,"AS-2016","CAF");

        //Para Tren 3
        CentralPCar_212788287_EspinozaBarria pc9 = new CentralPCar_212788287_EspinozaBarria(9,80,"NS-74","ALSTOM");
        TerminalPCar_212788287_EspinozaBarria pc10 = new TerminalPCar_212788287_EspinozaBarria(10,120,"NS-74","ALSTOM");
        CentralPCar_212788287_EspinozaBarria pc11 = new CentralPCar_212788287_EspinozaBarria(11,80,"NS-74","ALSTOM");
        CentralPCar_212788287_EspinozaBarria pc12 = new CentralPCar_212788287_EspinozaBarria(12,80,"NS-74","ALSTOM");
        TerminalPCar_212788287_EspinozaBarria pc13 = new TerminalPCar_212788287_EspinozaBarria(13,120,"NS-74","ALSTOM");

        //Crear trenes
        Train_212788287_EspinozaBarria t1 = new Train_212788287_EspinozaBarria(1,"CAF","UIC 60 ASCE",70,
                new ArrayList<>(Arrays.asList(pc1, pc0, pc3, pc2)));
        Train_212788287_EspinozaBarria t2 = new Train_212788287_EspinozaBarria(2,"CAF","100 R.E.",70,
                new ArrayList<>(Arrays.asList(pc7, pc4, pc5, pc6, pc8)));
        Train_212788287_EspinozaBarria t3 = new Train_212788287_EspinozaBarria(3,"ALSTOM","UIC 60 ASCE",50,new ArrayList<>());
        t3.addCar(pc9,0);
        t3.addCar(pc10,0);
        t3.addCar(pc11,2);
        t3.addCar(pc12,2);
        t3.addCar(pc13,4);
        t3.removeCar(3);

        if(t1.isTrain()){
            System.out.println("T1 valido");
        }
        if(t2.isTrain()){
            System.out.println("T2 valido");
        }
        if(t3.isTrain()){
            System.out.println("T3 valido");
        }
        System.out.println("T1 capacidad: "+t1.fetchCapacity());

        //Conductores
        Driver_212788287_EspinozaBarria d0 = new Driver_212788287_EspinozaBarria(0,"IsakitoEspinoza","CAF");
        Driver_212788287_EspinozaBarria d1 = new Driver_212788287_EspinozaBarria(1,"Jorge Gonzalez","ALSTOM");
        Driver_212788287_EspinozaBarria d2 = new Driver_212788287_EspinozaBarria(2,"Rodrigo Vasquez Altoyoyo","CAF");
        Driver_212788287_EspinozaBarria d3 = new Driver_212788287_EspinozaBarria(3,"Cristobal Briceno","ALSTOM");
        Driver_212788287_EspinozaBarria d4 = new Driver_212788287_EspinozaBarria(4,"Gustavo Cerati","ALSTOM");
        Driver_212788287_EspinozaBarria d5 = new Driver_212788287_EspinozaBarria(5, "Marcelo Barticciotoo","CAF");
        Driver_212788287_EspinozaBarria d6 = new Driver_212788287_EspinozaBarria(6,"Fito Paez","CAF");


        Subway_212788287_EspinozaBarria sw0 = new Subway_212788287_EspinozaBarria(0,"Metro de Santiago");
        sw0.addTrain(t1);
        sw0.addTrain(new ArrayList<>(Arrays.asList(t2,t3)));
        sw0.addLine(l1);
        sw0.addDriver(d0);
        sw0.addDriver(d1);
        sw0.addDriver(d2);
        sw0.addDriver(new ArrayList<>(Arrays.asList(d3,d4,d5,d6)));

        //Asignacion tren linea
        sw0.assignTrainToLine(t2,l1);

        //Asignacion recorrido driver
        sw0.assignDriverToTrain(t2,d2,new GregorianCalendar(2024,6,20,12,0),st0,st4);
        sw0.assignDriverToTrain(t2,d2,new GregorianCalendar(2024,6,20,9,30),st20,st15);
        sw0.assignDriverToTrain(t2,d2,new GregorianCalendar(2024,6,20,19,0),st0,st19);
        String encontrada = sw0.whereIsTrain(t2, new GregorianCalendar(2024,6,20,19,34));
        System.out.println(encontrada);
        System.out.println(sw0);


        System.out.println(sw0.trainPath(t2,new GregorianCalendar(2024,6,20,19,34)));














    }
}