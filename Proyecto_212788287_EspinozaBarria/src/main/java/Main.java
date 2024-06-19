import TDAs.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Subway_212788287_EspinozaBarria sw = new Subway_212788287_EspinozaBarria(1,"Metro de Santigo");
        //sw.addStationsByTXT("stations.txt");
        //sw.addSectionsByTXT("sections.txt");
        //sw.addLinesByTXT("lines.txt");
        //sw.addDriversByTXT("drivers.txt");
        //sw.addPassengerCarsByTXT("passengerCars.txt");
        //sw.addTrainsByTXT("trains.txt");
        //sw.addAsignacionesTrainLineByTXT("asignacionesTrainLine.txt");
        //sw.addRecorridosByTXT("recorridos.txt");

        //System.out.println(sw);
        //System.out.println(sw.whereIsTrain(2, new GregorianCalendar(2024,6,20,21,40)));
        //System.out.println(sw.trainPath(2,new GregorianCalendar(2024,6,20,21,40)));





        Scanner inTeclado = new Scanner(System.in);
        final int SALIDA_MENU_PRINCIPAL = 4; //constante inmutable

        int opcion, opcionSubMenu1, opcionSubMenu2, opcionSubMenu3;
        double seleccionIDLinea;
        do{
            printMenuPrincipal();
            opcion = inTeclado.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Voy acargar info");




                    do{
                        printMenuOpcion1();
                        opcionSubMenu1 = inTeclado.nextInt();

                        switch(opcionSubMenu1){
                            case 1:
                                sw.addStationsByTXT("stations.txt");
                                sw.addSectionsByTXT("sections.txt");
                                sw.addLinesByTXT("lines.txt");
                                sw.addPassengerCarsByTXT("passengerCars.txt");
                                sw.addTrainsByTXT("trains.txt");
                                sw.addDriversByTXT("drivers.txt");
                                sw.addAsignacionesTrainLineByTXT("asignacionesTrainLine.txt");
                                sw.addRecorridosByTXT("recorridos.txt");
                                break;
                            case 2:
                                sw.addStationsByTXT("stations.txt");
                                break;
                            case 3:
                                sw.addSectionsByTXT("sections.txt");
                                break;
                            case 4:
                                sw.addLinesByTXT("lines.txt");
                                break;
                            case 5:
                                sw.addPassengerCarsByTXT("passengerCars.txt");
                                break;
                            case 6:
                                sw.addTrainsByTXT("trains.txt");
                                break;
                            case 7:
                                sw.addDriversByTXT("drivers.txt");
                                break;
                            case 8:
                                sw.addAsignacionesTrainLineByTXT("asignacionesTrainLine.txt");
                                break;
                            case 9:
                                sw.addRecorridosByTXT("recorridos.txt");
                                break;
                            case 10:
                                System.out.println("Volviendo al Menu Principal");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }

                    }while(opcionSubMenu1 != 10);
                    break;




                case 2:
                    System.out.println("Estoy visualizando la cosa");


                    do{
                        printMenuOpcion2();
                        opcionSubMenu2 = inTeclado.nextInt();

                        switch(opcionSubMenu2){
                            case 1:
                                System.out.println(sw);
                                break;
                            case 2:
                                System.out.println(sw.getStationsMap());
                                break;
                            case 3:
                                System.out.println(sw.getSectionsMap());
                                break;
                            case 4:
                                System.out.println(sw.getLinesMap());
                                break;
                            case 5:
                                System.out.println(sw.getPassengerCarsMap());
                                break;
                            case 6:
                                System.out.println(sw.getTrainsMap());
                                break;
                            case 7:
                                System.out.println(sw.getDriversMap());
                                break;
                            case 8:
                                System.out.println(sw.getAsignacionesTL());
                                break;
                            case 9:
                                System.out.println(sw.getRecorridosDriverTrain());
                                break;
                            case 10:
                                System.out.println("Volviendo al Menu Principal");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }



                    }while(opcionSubMenu2 != 10);





                    break;
                case 3:
                    System.out.println("Interacturo con el subway");

                    do{
                        printMenuOpcion3();
                        opcionSubMenu3 = inTeclado.nextInt();
                        switch(opcionSubMenu3){
                            case 1:
                                System.out.println("Por favor, ingrese la id de la linea requerida: ");
                                seleccionIDLinea = inTeclado.nextDouble();
                                System.out.println("\n\nLa linea: " + seleccionIDLinea + "tiene un largo de: " +
                                        sw.getLinesMap().get(seleccionIDLinea).lineLength() + "Km\n\n");
                                break;

                            case 2:
                                break;


                            case 3:
                                System.out.println("Por favor, ingrese la id de la linea requerida: ");
                                seleccionIDLinea = inTeclado.nextDouble();
                                System.out.println("\n\nLa linea: " + seleccionIDLinea + "tiene un costo total de: " +
                                        sw.getLinesMap().get(seleccionIDLinea).lineCost() + "\n\n");
                                break;

                            case 12:
                                System.out.println("Volviendo al Menu Principal");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }

                    }while(opcionSubMenu3 != 12);


                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opcion "+opcion+" no existe. Por favor, vuelve a intentarlo.");

            }



        }while(opcion != SALIDA_MENU_PRINCIPAL);

    }


    private static void printMenuPrincipal() {
        System.out.println("### Sistema Metro - Inicio ###\n");
        System.out.println("Opciones de creacion de la red de metro y simulacion de ejecucion}n\n");
        System.out.println("\t1.  Cargar informacion del sistema de metro");
        System.out.println("\t2.  Visualizacion del sistema de metro");
        System.out.println("\t3.  Interactuar con el sistema de metro");
        System.out.println("\t4.  Salir del programa");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }

    private static void printMenuOpcion1() {
        System.out.println("### Sistema Metro - Cargar informacion del sistema de metro ###\n");
        System.out.println("Definiciones estructurales de su sistema subido desde archivos\n\n");
        System.out.println("\t1.  Creacion automatica del sistema de metro. Carga todos los archivos txt.");
        System.out.println("\t       En caso de no seleccionar esta opcion, se debera carga manualmente las estaciones, las secciones, las lineas,");
        System.out.println("\t       los carros, los trenes, los conductores, las asignaciones y los recorridos, EN ESTE MISMO ORDEN");
        System.out.println("\t2.  Creacion de las estaciones del sistema de metro (cargar archivo stations.txt)");
        System.out.println("\t3.  Creacion de las secciones del sistema de metro (cargar archivo sections.txt)");
        System.out.println("\t4.  Creacion de las lineas del sistema de metro (cargar archivo lines.txt)");
        System.out.println("\t5.  Creacion de los carros de pasajeros del sistema de metro  (cargar archivo passengerCars.txt)");
        System.out.println("\t6.  Creacion de los trenes del sistema de metro (cargar archivo trains.txt)");
        System.out.println("\t7.  Creacion de los conductores del sistema de metro (cargar archivo drivers.txt)");
        System.out.println("\t8.  Creacion de las asignaciones Tren-Linea del sistema de metro (cargar archivo asignacionesTrainLine.txt)");
        System.out.println("\t9.  Creacion de recorridos del sistema de metro (cargar archivo recorridos.txt)");
        System.out.println("\t10. Volver al Menu Principal\n");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }



    private static void printMenuOpcion2() {
        System.out.println("### Sistema Metro - Visualización del estado actual del sistema de metros  ###\n");
        System.out.println("Definiciones estructurales de su sistema subido desde archivos\n\n");
        System.out.println("\t1.  Desplegar en pantalla el estado actual de todo el sistema de metro");
        System.out.println("\t2.  Desplegar en pantalla solo las estaciones del sistema de metro");
        System.out.println("\t3.  Desplegar en pantalla solo las secciones del sistema de metro");
        System.out.println("\t4.  Desplegar en pantalla solo las lineas del sistema de metro");
        System.out.println("\t5.  Desplegar en pantalla solo los carros del sistema de metro");
        System.out.println("\t6.  Desplegar en pantalla solo los trenes del sistema de metro");
        System.out.println("\t7.  Desplegar en pantalla solo los conductores del sistema de metro");
        System.out.println("\t8.  Desplegar en pantalla solo las asignaciones Tren-Linea del sistema de metro");
        System.out.println("\t9.  Desplegar en pantalla solo los recorridos del sistema de metro");
        System.out.println("\t10. Volver al Menu Principal\n");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }


    private static void printMenuOpcion3() {
        System.out.println("### Sistema Metro - Interactuar con el sistema de metros ###\n");
        System.out.println("A traves de las siguientes opciones usted puede interactuar con la red de metros cargada previamente por todos los archivos de texto.\n\n");
        System.out.println("\t1.  lineLength: obtener el largo total de una linea.");
        System.out.println("\t2.  lineSectionLength: determinar el tracto entre una estacion origen y final.");
        System.out.println("\t3.  lineCost: determinar el costo total de recorrer una linea.");
        System.out.println("\t4.  lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
        System.out.println("\t5.  isLine: verificar si una linea cumple con las restricciones especificadas.");
        System.out.println("\t6.  Train - addCar: añade un carro de pasajeros a un tren en la posicion establecida.");
        System.out.println("\t7.  Train - removeCar: remueve un carro de pasajeros de un tren en la posicion establecida.");
        System.out.println("\t8.  Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
        System.out.println("\t9.  Train - fetchCapacity: entrega la capacidad maxima de pasajeros de un tren.");
        System.out.println("\t10. Subway - whereIsTrain: determina la ubicacion de un tren a partir de una hora indicada del dia.");
        System.out.println("\t11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
        System.out.println("\t12. Volver al Menu Principal\n");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }





}