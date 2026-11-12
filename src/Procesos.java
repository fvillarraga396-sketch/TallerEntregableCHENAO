import javax.swing.*;
import java.util.ArrayList;

public class Procesos {

    ArrayList<String> listaProfesores;
    ArrayList<String> listaEstudiante;
    ArrayList<ArrayList<String>> listaGeneralEstudainte;
    int opc=0;

    public Procesos(){

            listaProfesores=new ArrayList<>();
            listaGeneralEstudainte=new ArrayList<>();

        }

        public void lista(){

            String mensaje="";

            do {

                mensaje = " <<<<<< INGRESE LA OPCION LA CUAl DESEA REALIZAR >>>>>> \n";
                mensaje += "1. registrar profesores \n";
                mensaje += "2. registrar estudiantes \n";
                mensaje += "3. consultar profesores y estudiantes \n";
                mensaje += "4. consultar profesor por el nombre \n";
                mensaje += "5. consultar la cantidad de estudiantes por el nombre del profesor \n";
                mensaje += "6. consultar la existencia de un estudiante \n";
                mensaje += "7. Salire del programa\n\n";
                mensaje += "Ingrese la opcion la cual desea";

                opc = Integer.parseInt(JOptionPane.showInputDialog(mensaje));

                switch (opc) {
                    case 1:
                        registrarProfesores();
                        break;
                    case 2:
                        if (listaProfesores.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¡Primero debe registrar profesores!");
                        } else {
                            registrarEstudiantes();
                        }
                        break;
                    case 3:
                        if (listaProfesores.isEmpty() || listaGeneralEstudainte.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¡Primero debe registrar profesores y estudiantes!");
                        } else {
                            consultarListasProfesoresYEstudiantes();
                        }
                        break;
                    case 4:
                        if (listaProfesores.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¡Primero debe registrar profesores!");
                        } else {
                            consultaProfesoresPorNombre();
                        }
                        break;
                    case 5:
                        if (listaProfesores.isEmpty() || listaGeneralEstudainte.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¡Primero debe registrar profesores y estudiantes!");
                        } else {
                            consultaCantidadEstudiantesPorProfesoresa();
                        }
                        break;
                    case 6:
                        if (listaGeneralEstudainte.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¡Primero debe registrar estudiantes!");
                        } else {
                            consultarEstudiantes();
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null," se sale del programa ");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " Opcion invalida se sale");

                }

            }while (opc !=7);

        }

        public void iniciar(){

            lista();

        }

        public void registrarProfesores(){

            System.out.println("<<<< Registro de profesores >>>>");

            int cantidad=Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la cantidad de profesores "));

            for (int i=0; i < cantidad; i++) {

                String nombreProfesores;

                nombreProfesores = JOptionPane.showInputDialog(" Ingrese el nombre del profesor " + (i + 1));

                if (listaProfesores.contains(nombreProfesores)){
                    JOptionPane.showMessageDialog(null," el nombre del profesor ya esta ingresado ingrese otro por favor ");

                    i--;

                }else {

                    listaProfesores.add(nombreProfesores);

                }
            }

            System.out.println(listaProfesores);

        }

        public void registrarEstudiantes(){

            System.out.println("<<<< Registro de estudiantes >>>>>");

            for (int i=0; i<listaProfesores.size();i++){

                JOptionPane.showMessageDialog
                        (null," Ingrese la lista de estudiantes para el profesor " + listaProfesores.get(i));

                int cantEstu=Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la cantidad de los estudiantes "));

                listaEstudiante=new ArrayList<>();

                for (int j=0; j< cantEstu ;j++){

                    String nombreEstu=JOptionPane.showInputDialog(" Ingrese el nombre del estudiante " + (j+1));

                    if (listaEstudiante.contains(nombreEstu)){

                        JOptionPane.showMessageDialog(null," el nombre del estudiante ya esta ingresado ingrese otro por favor");

                        j--;

                    }else {

                        listaEstudiante.add(nombreEstu);

                    }

                }

                listaGeneralEstudainte.add(listaEstudiante);

            }
        }

        public void consultarListasProfesoresYEstudiantes(){

            System.out.println("<<<<< Lista Profesores: Estudiantes >>>>");

            ArrayList<String> temporal;

            for (int i=0;i<listaGeneralEstudainte.size();i++){

                temporal=listaGeneralEstudainte.get(i);

                System.out.print("Profesor : " + listaProfesores.get(i)+" = ");

                System.out.println("[");

                for (int j=0; j<temporal.size();j++){

                    System.out.print(temporal.get(j)+"|" + " ");

                }

            }

            System.out.println("]\n");

        }

        public void consultaProfesoresPorNombre(){

            System.out.println("<<<< Consulta de profesores >>>>");

            String nombre = JOptionPane.showInputDialog(" Ingrese el nombre del profesores para buscar ");

            if (listaProfesores.contains(nombre)){

                int posicion=listaProfesores.indexOf(nombre);

                ArrayList<String>listaEstudiantesTemporal=listaGeneralEstudainte.get(posicion);

                System.out.print("Profesores : " + nombre + " = ");

                System.out.println("[");

                for (int j=0; j<listaEstudiantesTemporal.size();j++){
                    System.out.println(listaEstudiantesTemporal.get(j));

                }

                System.out.println("] \n ");

            }else {

                JOptionPane.showMessageDialog(null, " No se encuentra el profesor " + nombre);

            }

        }

        public void consultaCantidadEstudiantesPorProfesoresa(){

            System.out.println("\n<<<< Consulta cantidad de estudiantes por profesores >>>>\n ");

            String nombre=JOptionPane.showInputDialog(" Ingrese el nombre del profesores que desea buscar " + " Cantidad de estudiantes ");

            if (listaProfesores.contains(nombre)) {

                int posicion=listaProfesores.indexOf(nombre);
                ArrayList<String> lisEstuTemporal=listaGeneralEstudainte.get(posicion);

                System.out.println(" La cantidad de estudiantes del profesor " + nombre + " es " + lisEstuTemporal.size());

            }else{
                System.out.println( " NO se encuentra al profesor " + nombre + "\n");
            }

        }

        public void consultarEstudiantes(){

            System.out.println("\n<<<<< Consulta de estudiantes >>>> \n ");

            ArrayList<String> lisTemporal;

            String nombre=JOptionPane.showInputDialog(" Ingrese el nombre del estudiante al cual buscar ");

            for (int i =0; i< listaGeneralEstudainte.size(); i++){

                lisTemporal=listaGeneralEstudainte.get(i);

                if (lisTemporal.contains(nombre)){

                    for (int j=0; j<lisTemporal.size(); j++){

                        if (lisTemporal.get(j).equalsIgnoreCase(nombre)){

                            System.out.println(" Encuentra el nombre: " + nombre + " pertenece al " + " grupo de " + listaProfesores.get(i));

                        }else {

                            System.out.println(" No se encuentra en nombre en el grupo de " + listaProfesores.get(i));

                        }
                    }

                }
            }

        }
    }

