import TDAs.Section_212788287_EspinozaBarria;
import TDAs.Station_212788287_EspinozaBarria;

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
        Station_212788287_EspinozaBarria st1 = new Station_212788287_EspinozaBarria(1, "USACH", "t", 3);
        Station_212788287_EspinozaBarria st2 = new Station_212788287_EspinozaBarria(2,"Estacion Central","r",20);
        Station_212788287_EspinozaBarria st3 = new Station_212788287_EspinozaBarria(3,"ULA","c",100);
        Station_212788287_EspinozaBarria st4 = new Station_212788287_EspinozaBarria(4,"Republica","c",10);
        Station_212788287_EspinozaBarria st5 = new Station_212788287_EspinozaBarria(5,"Los Heroes","t",300);

        Section_212788287_EspinozaBarria s1 = new Section_212788287_EspinozaBarria(st1,st2,30,8);
        Section_212788287_EspinozaBarria s2 = new Section_212788287_EspinozaBarria(st2,st3,50,49);
        Section_212788287_EspinozaBarria s3 = new Section_212788287_EspinozaBarria(st3,st4,40,343);



    }
}