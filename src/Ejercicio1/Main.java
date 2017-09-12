package Ejercicio1;

/**
 *
 * @authores 
 * Olano Chávez, Wilfredo Cristóbal
 * 
 */
public class Main {

    /**
     * @param args Clase principal del sistema tiene como función 
     * ejecutar el menú principal con los respectivos metodos de las
     * clases.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Universidad universidad = new Universidad("Univalle");
        boolean ok = true;
        String opc, op;
        //Menú principal del sistema
        do {
            System.out.println("\n1 .-Registrar estudiantes\n"
                    + "2 .-Registrar asignaturas\n"
                    + "3 .-Listar estudiantes y asignaturas inscritas\n"
                    + "4 .-Realizar Matricula \n"
                    + "5 .-Listar estudiantes por materia \n"
                    + "6 .-listar los estudiantes por creditos especificos\n"
                    + "7 .-Salir\n"
                    + "Seleccione una opción: ");

            opc = Constantes.ENTRADA_SCANNER.nextLine(); //Invocamos un método sobre un objeto Scanner

            switch (opc) {
                case "1":
                    universidad.registrarEstudiante();
                    break;
                case "2":
                    universidad.registrarAsignatura();
                    break;
                case "3":
                    universidad.listarEstudiantes_Materias();
                    break;
                case "4":
                    universidad.registrarMatricula();
                    break;
                case "5":
                    universidad.listarEstudiantes_x_Asignatura();
                    break;
                case "6":
                    universidad.listar_X_creditos();
                    break;
                case "7":
                    System.exit(0); //Método para finalizar la ejecución
                    break;

            }
            
           System.out.println("1 .-Volver al menú principal\n"
                             + "2 .-Salir");
            op = Constantes.ENTRADA_SCANNER.nextLine();
            if ("2".equals(op)) {
                ok = false;
            }

        } while (ok);

    }

}
