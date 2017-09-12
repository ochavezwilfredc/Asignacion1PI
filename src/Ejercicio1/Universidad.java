/*
 * Clase principal del programa de matricula
 */
package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @authores Olano Chávez, Wilfredo Cristóbal
 *
 *
 */
public class Universidad {

    private String nombre;
    private ArrayList<Estudiante> listado_estudiantes;
    private ArrayList<Asignatura> listado_asignaturas;

    //Constructor vacio de clase
    public Universidad() {
        listado_estudiantes = new ArrayList<>();
        listado_asignaturas = new ArrayList<>();

    }

    //Constructor parametrizado de clase
    public Universidad(String nombre) {
        this.nombre = nombre;
        listado_estudiantes = new ArrayList<>();
        listado_asignaturas = new ArrayList<>();

    }

    /*
    Método que nos permite registrar un nuevo estudiante en el arreglo de
    estudiantes
     */
    public void registrarEstudiante() {
        System.out.println("------- REGISTRO DE ESTUDIATES -------\n");
        String nombre, codigo, plan_estudios;
        Estudiante estudiante;
        System.out.println("Digite codigo:");
        codigo = Constantes.ENTRADA_SCANNER.nextLine();
        System.out.println("Digite nombre y apellido:");
        nombre = Constantes.ENTRADA_SCANNER.nextLine();
        System.out.println("Plan de estudios:");
        plan_estudios = Constantes.ENTRADA_SCANNER.nextLine();
        estudiante = new Estudiante(codigo, nombre, plan_estudios);
        this.listado_estudiantes.add(estudiante);
        System.out.println("El estudiante " + estudiante.getNom_apellido() + " registrado correctamente\n----------------------------------");
    }

    /*
    Método que nos permite registrar una nueva asignatura en el arreglo de
    asignaturas 
     */
    public void registrarAsignatura() {
        System.out.println("------- REGISTRO DE ASIGNATURAS -------");
        String nombre, codigo;
        int num_creditos;
        Asignatura asignatura;
        System.out.println("Digite codigo:");
        codigo = Constantes.ENTRADA_SCANNER.nextLine();
        System.out.println("Digite nombre:");
        nombre = Constantes.ENTRADA_SCANNER.nextLine();
        System.out.println("Cantidad de creditos:");
        num_creditos = Constantes.ENTRADA_SCANNER.nextInt();
        asignatura = new Asignatura(num_creditos, nombre, codigo);
        this.listado_asignaturas.add(asignatura);
        System.out.println("La asignatura " + asignatura.getNombre() + " registrado correctamente\n----------------------------------");

    }

    /*
        Método que permite listar y mostrar el contenido de las listas de aignaturas y estudiantes
     */
    public void listarEstudiantes_Materias() {
        if (listado_asignaturas.size() > 0 && listado_estudiantes.size() > 0) {
            System.out.println("\n----LISTADO DE ESTUDIANTES----");
            if (listado_estudiantes.size() > 0) {
                for (int i = 0; i < listado_estudiantes.size(); i++) {
                    System.out.println(listado_estudiantes.get(i).toString() + "");
                }
            } else {
                System.out.println("No existen estudiantes registrados!");
            }

            System.out.println("\n----LISTADO DE ASIGNATURAS----");
            if (listado_asignaturas.size() > 0) {
                for (int i = 0; i < listado_asignaturas.size(); i++) {
                    System.out.println(listado_asignaturas.get(i).toString() + "");
                }
            } else {
                System.out.println("No existen asignaturas registrados!");
            }

            System.out.println("\n");
        } else {
            System.out.println("----------------------------------------\nNo existe asignaturas o estudiantes registradas\n----------------------------------------\n");

        }
    }
    
    /*
        Método que nos permite búscar una asignatura por medio de su código
        devolviendo la posición del arreglo que consida con la asignatura 
    */
    private int buscarAsigantura(String codigo) {
        int i = 0;
        if (listado_asignaturas.size() > 0) {
            while (i <= listado_asignaturas.size()) {
                if (listado_asignaturas.get(i).getCondigo().equals(codigo)) {
                    return i;
                }
                i++;
            }
        } else {
            return -1;
        }

        return -1;
    }

    /*
        Método que nos permite búscar un estudiante por medio de su código
        devolviendo la un objeto estudiante que consida con código a buscar
    */
    public Estudiante buscarEstudiante() {
        int i = 0;
        System.out.println("Ingresar el codigo estudiante:");
        String codigo = Constantes.ENTRADA_SCANNER.nextLine();
        while (i <= listado_estudiantes.size()) {
            if (listado_estudiantes.get(i).getCodigo().equals(codigo)) {
                return listado_estudiantes.get(i);
            }
            i++;
        }

        return null;
    }
    
    /*
        Método que nos permite registrar una matricula 
    */
    public void registrarMatricula() {
        if (listado_estudiantes.size() > 0 && listado_asignaturas.size() > 0) {
            System.out.println("-------REGISTRO DE NUEVA MATRICULA-------\n");
            Estudiante estudiante = buscarEstudiante();
            if (estudiante != null) {
                boolean ok = true;
                int pos;
                String codigo, opc;

                do {
                    System.out.println("Ingresar el codigo de la asignatura");
                    codigo = Constantes.ENTRADA_SCANNER.nextLine();
                    pos = buscarAsigantura(codigo);
                    if (pos != -1) {
                        //validamos que la asignatura no este registrada 
                        Asignatura asignatura = listado_asignaturas.get(pos);
                        if (!estudiante.lista_asignaturas_matriculadas.contains(asignatura)) {
                            estudiante.lista_asignaturas_matriculadas.add(asignatura);
                            System.out.println("----------------------------------------\n"
                                    + "Asiganatura " + asignatura.getNombre() + " matriculada correctamente\n"
                                    + "----------------------------------------\n");
                            if (estudiante.lista_asignaturas_matriculadas.size() < 2) {
                                System.out.println("1 .-Registrar otra materia\n"
                                        + "2 .-Salir");
                                opc = Constantes.ENTRADA_SCANNER.nextLine();

                                if ("2".equals(opc) && (estudiante.lista_asignaturas_matriculadas.size() > 1)) {
                                    ok = false;
                                } else {
                                    if ("1".equals(opc) && (estudiante.lista_asignaturas_matriculadas.size() > 6)) {
                                        ok = false;
                                    } else {
                                        System.out.println("Ud debe registrar como mínimo 2 maximo 7 materias");
                                    }
                                }
                            } else {
                                ok = false;
                            }

                        } else {
                            System.out.println("Ya se encuentra matriculado a " + asignatura.getNombre());
                        }

                    } else {
                        if (listado_asignaturas.size() < 0) {
                            System.out.println("No existe materias registradas");
                            ok = false;
                        }
                    }
                } while (ok);
            } else {
                if (listado_estudiantes.size() < 0) {
                    System.out.println("No estudiantes registrados");
                } else {
                    System.out.println("No se encuentra matriculado el estudiante");
                }
            }
        } else {
            System.out.println("----------------------------------------\nNo existe asignaturas o estudiantes registradas\n----------------------------------------\n");

        }

    }

    /*
        Método que nos permite listar los estudiante por el código de una asignatura 
        ingresado
    */
    public void listarEstudiantes_x_Asignatura() {
        if (listado_asignaturas.size() > 0) {
            System.out.println("-------LISTADO DE ESTUDIANTES POR ASIGNATURA -------\n");
            boolean ok = true;
            int pos;
            String codigo, opc;
            Estudiante estudiante;
            do {
                System.out.println("Ingresar el codigo de la asignatura");
                codigo = Constantes.ENTRADA_SCANNER.nextLine();
                pos = buscarAsigantura(codigo);
                if (pos != -1) {
                    Asignatura asignatura = listado_asignaturas.get(pos);
                    System.out.println("\n------------------------------\n");
                    for (int i = 0; i < listado_estudiantes.size(); i++) {
                        estudiante = listado_estudiantes.get(i);
                        if (estudiante.lista_asignaturas_matriculadas.contains(asignatura)) {
                            System.out.print(estudiante.toString() + "\n");
                        }
                    }
                    ok = false;

                } else {
                    if (listado_asignaturas.size() > 0) {
                        System.out.println("No existe la asignatura\n");
                    } else {
                        System.out.println("--------------------------------------\n"
                                + "No existe la asignaturas registradas"
                                + "\n--------------------------------------\n");
                        ok = false;
                    }

                }
            } while (ok);
        } else {
            System.out.println("----------------------------------------\nNo existe asignaturas registradas\n----------------------------------------\n");
        }
    }
    
    /*
        Método que nos permite listar los estudiante por la cantidad de creditos ingresada
    */
    public void listar_X_creditos() {
        if (listado_estudiantes.size() > 0) {
            System.out.println("-------LISTADO DE ESTUDIANTES POR CREDITOS -------\n");
            System.out.println("Digite el número de creditos:\n");
            int num_creditos = Constantes.ENTRADA_SCANNER.nextInt();
            Estudiante estudiante;
            System.out.println("\nEstudiantes con " + num_creditos + " creditos");
            for (int i = 0; i < listado_estudiantes.size(); i++) {
                estudiante = listado_estudiantes.get(i);
                int total_creditos = 0;
                for (int j = 0; j < estudiante.lista_asignaturas_matriculadas.size(); j++) {
                    total_creditos += estudiante.lista_asignaturas_matriculadas.get(j).getNum_creditos();
                }
                if (num_creditos == total_creditos) {
                    System.out.print(estudiante.toString() + "\n");
                } else {
                    System.out.println("----------------------------------------\n"
                            + "No existe considencias!!!\n"
                            + "--------------------------------------\n");
                }
            }
        } else {
            System.out.println("----------------------------------------\nNo existe estudiantes registrados\n----------------------------------------\n");
        }

    }

}
