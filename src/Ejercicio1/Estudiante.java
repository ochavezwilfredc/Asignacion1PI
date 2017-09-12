/* Clase estudiante tiene como finalidad modelar o mapear al 
   objeto estudiate con sus respectivos atributos y métodos
 * 
 */
package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @authores
 *      Olano Chávez, Wilfredo Cristóbal
 */
public class Estudiante {
    private String codigo,nom_apellido, plan_estudios;
    
    //Arreglo de las asignaturas matriculadas por cada alumno
    public ArrayList<Asignatura> lista_asignaturas_matriculadas = new ArrayList<>();
    
    //Constructor vacio 
    public Estudiante() {}

    //Constructor con parametros 
    public Estudiante(String codigo, String nom_apellido, String plan_estudios) {
        this.codigo = codigo;
        this.nom_apellido = nom_apellido;
        this.plan_estudios = plan_estudios;
    }

    //Métodos get y set del objeto estudiante 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNom_apellido() {
        return nom_apellido;
    }

    public void setNom_apellido(String nom_apellido) {
        this.nom_apellido = nom_apellido;
    }

    public String getPlan_estudios() {
        return plan_estudios;
    }

    public void setPlan_estudios(String plan_estudios) {
        this.plan_estudios = plan_estudios;
    }
    
    /*Sobrescribimos  el método toString de la clase padre para 
        listar listar los valores de los atributos*/
    @Override
    public String toString() {
        return "Estudiante{" + "\n   codigo=" + codigo + "\n   nombre=" + nom_apellido + "\n   plan de estudios=" + plan_estudios+"\n" + '}';
    }
    
    
    
}
