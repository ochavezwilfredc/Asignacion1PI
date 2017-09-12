/*
 * Clase encaragda de manejar los estimulos de los alumnos
 */
package Ejercicio2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author invitado
 */
public class Registro {

    public ArrayList<Estudiante> listado_estudiantes ;
    public ArrayList<Estudiante> listado_estimulos;

    public Registro() {
        listado_estudiantes = new ArrayList<>();
        listado_estimulos = new ArrayList<>();
    }

    /*
    método de ordenamiento tipo burbuja de del arreglo de estimulo
    fuente http://www.lawebdelprogramador.com/foros/Java/1462149-Arreglos-Ordenar-Numeros-de-mayor-a-menos-y-viceversa.html
    nos basamos en dicho de no tratar de reimbentar la rueda.
    
    for(int i = 0; i < num.length; i++){
			for(j=i+1; j < num.length; j++){
				if(num[i] < num[j]){
					aux = num[i];
					num[i] = num[j];
					num[j] = aux;
				}
			}
		}
     */
    private void ordenar_estimulos() {
        Estudiante estudiante;
        for (int i = 0; i < listado_estimulos.size(); i++) {
            for (int j = i+1; j < listado_estimulos.size(); j++) {
                if ((listado_estimulos.get(j).getPromedio()) < (listado_estimulos.get(j).getPromedio())) {
                    estudiante = listado_estimulos.get(i);
                    listado_estimulos.set(i, listado_estimulos.get(j));
                    listado_estimulos.set(j, estudiante);
                }
            }
        }
    }

    /*
        Método que devuelve un objeto de tipo Float que corresponde a la nota ingresada 
        valindando que este en el rango de 0.0 - 5.0
     */
    private Float getNota(int i) {
        boolean ok = true;
        do {
            String nota = JOptionPane.showInputDialog("Nota " + (i + 1));
            float n = Float.valueOf(nota);
            if (n >= 0.0 && n <= 5.0) {
                return Float.valueOf(nota);
            } else {
                JOptionPane.showMessageDialog(null, "Nota invalida", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (ok);
        return null;
    }

    /*
        Método que se encarga de registrar un estudiante con sus respectivas notas
     */
    void registrarEstudiate() {
        String nombre = JOptionPane.showInputDialog("Nombre");
        String codigo = JOptionPane.showInputDialog("Código");
        String semestre = JOptionPane.showInputDialog("Semestre");
        String plan = JOptionPane.showInputDialog("Plan");
        boolean ok = true;
        Estudiante estudiante = new Estudiante(nombre, codigo, semestre, plan);
        float[] lista = estudiante.getLista_notas();

        for (int i = 0; i < 5; i++) {
            lista[i] = getNota(i);
        }
        estudiante.setLista_notas(lista);

        this.listado_estudiantes.add(estudiante);
        if (estudiante.getPromedio() >= 3.8) {
            this.listado_estimulos.add(estudiante);
            this.ordenar_estimulos();
        }

        JOptionPane.showMessageDialog(null, "Estudiante " + estudiante.getNombre() + " registrado correctamente!");
        System.out.println(estudiante.toString());

    }

    /*Método que lista los estudiantes con su respectivo promedio
     */
    void listar() {
        String listado = "";
        for (Estudiante estudiante : listado_estudiantes) {
            listado = listado + (estudiante.getNombre() + "           " + estudiante.getPromedio() + "\n");
        }
        JOptionPane.showMessageDialog(null, listado);
    }

    /*
        Método que nos permite búscar un estudiante por medio de su código
        devolviendo la un objeto estudiante que consida con código a buscar
     */
    private Estudiante buscar() {
        int i = 0;
        String codigo = JOptionPane.showInputDialog("Digite Código: ");
        while (i <= listado_estudiantes.size()) {
            if (listado_estudiantes.get(i).getCodigo().equals(codigo)) {
                return listado_estudiantes.get(i);
            }
            i++;
        }

        return null;
    }

    void buscarEstudiante() {
        if (this.listado_estudiantes.size() > 0) {
            Estudiante e = buscar();
            if (e != null) {
                JOptionPane.showMessageDialog(null, e.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No existe el estudiante");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe estudiantes registrados!");
        }
    }

    void listarEstimulos() {
 
        if (this.listado_estimulos.size() > 0) {
            String s = "";
            int i = 1;
            for (Estudiante e : listado_estimulos) {
                s = s + e.toString();
                if (i==5) {
                    break;
                }
                i++;
            }
            JOptionPane.showMessageDialog(null, s);
            System.out.println(s);

        } else {
            JOptionPane.showMessageDialog(null, "No existe estudiantes registrados!");
        }
    }

}
