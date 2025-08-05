package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Estudiante {
  private String nombre;
  private String cedula;
  private List<Double> calificaciones;
  private int porcentajesUnicos;

  public Estudiante(String nombre, String cedula, List<Double> calificaciones, int porcentajesUnicos) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.calificaciones = calificaciones;
    this.porcentajesUnicos = porcentajesUnicos;
  }

  public int getPromedio(){
    double suma = 0;
    for(Double nota : calificaciones){
      suma += nota;
    }
    return (int) (suma/calificaciones.size());

  }
  public int calcularPorcentajesUnicos() {
    String limpio = nombre.toLowerCase().replaceAll(" " , " ");
    Set<Character> unicos = new HashSet<>();
    for(char c : limpio.toCharArray()){
      unicos.add(c);
    }
    return (int) ((unicos.size() * 100.0) / limpio.length());  
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public List<Double> getCalificaciones() {
    return calificaciones;
  }

  public void setCalificaciones(List<Double> calificaciones) {
    this.calificaciones = calificaciones;
  }

  public int getPorcentajesUnicos() {
    return porcentajesUnicos;
  }

  public void setPorcentajesUnicos(int porcentajesUnicos) {
    this.porcentajesUnicos = porcentajesUnicos;
  }
   @Override
  public String toString() {
    return nombre + "-" + cedula +  "- Porcentaje: " + porcentajesUnicos + "Promedios" + getPromedio();
  }

  @Override
  public int hashCode() {
    return cedula.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass()) 
    return false;   
    Estudiante other = (Estudiante) obj;
    return this.cedula.equals(other.cedula);
    
  }
}
