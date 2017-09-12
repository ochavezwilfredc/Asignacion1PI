/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;


/**
 *
 * @author invitado
 */
public class Estudiante {
    private String nombre, codigo, semestre, plan;
    private float[] lista_notas = new float[5];

    public Estudiante() {
    }

    public Estudiante(String nombre, String codigo, String semestre, String plan) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.plan = plan;
        this.inicializar();
    }
    
    /*Método para inicializar el arreglo de las notas de cada estudiante*/
    private void inicializar(){
        for (int i = 0; i < lista_notas.length; i++) {
            lista_notas[i]=0;
        }
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public float[] getLista_notas() {
        return lista_notas;
    }

    public void setLista_notas(float[] lista_notas) {
        this.lista_notas = lista_notas;
    }
    
    /*
        Método para calcular el promedio de notas de cada alumno
    */
    public float getPromedio(){
        float prom=0;
        for (int i = 0; i < lista_notas.length; i++) {
            prom+=lista_notas[i];
        }
        return prom/lista_notas.length;
    }

    @Override
    public String toString() {
        return nombre +"-"+ codigo +"-"+  semestre +"-"+  plan +"-"+ "promedio:"+getPromedio()+"\n";
    }
    
    
    
}
