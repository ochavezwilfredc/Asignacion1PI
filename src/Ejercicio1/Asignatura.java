/*
 * Clase Asignatura tiene como finalidad modelar o mapear al 
   objeto asignatura con sus respectivos atributos y métodos
 */
package Ejercicio1;

/**
 *
 * @author invitado
 */
public class Asignatura {
    private int  num_creditos;
    private String nombre, condigo;

    public Asignatura() {
    }

    public Asignatura(int num_creditos, String nombre, String condigo) {
        this.num_creditos = num_creditos;
        this.nombre = nombre;
        this.condigo = condigo;
    }

    public int getNum_creditos() {
        return num_creditos;
    }

    public void setNum_creditos(int num_creditos) {
        this.num_creditos = num_creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondigo() {
        return condigo;
    }

    public void setCondigo(String condigo) {
        this.condigo = condigo;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "\n   creditos=" + num_creditos + "\n   nombre=" + nombre + "\n   condigo=" + condigo +"\n"+ '}';
    }

   
    
    
    
    
}
