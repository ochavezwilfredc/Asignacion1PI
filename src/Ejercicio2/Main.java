/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author invitado
 */
public class Main {

    public static void main(String[] args) {
        boolean ok = true;
        Registro registro = new Registro();
        do {
            String opc = JOptionPane.showInputDialog("Digite una opción\n"
                    + " 1.Registrar estudiante\n"
                    + " 2.Listar Estudiante\n"
                    + " 3.Buscar Estudiante\n"
                    + " 4.Estimulo Academico\n"
                    + " 5.Bajo Rendimiento\n"
                    + " 6.Salir\n"
            );

            switch (opc) {
                case "1":
                    registro.registrarEstudiate();
                    break;
                case "2":
                    registro.listar();
                    break;
                case "3":
                    registro.buscarEstudiante();
                    break;
                case "4":
                    registro.listarEstimulos();
                    break;
                case "5":

                    break;
                case "6":
                    System.exit(0);
                    break;
            }

        } while (ok);
    }
}
