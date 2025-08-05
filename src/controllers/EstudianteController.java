package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.Estudiante;

public class EstudianteController {

  public Set<Estudiante> ordenarPorPromedio (List<Estudiante> estudiantes){
    Set<Estudiante> ordenador = new TreeSet<>(new Comparator<Estudiante>() {

      @Override
      public int compare(Estudiante e1, Estudiante e2) {
        if (e1.getCedula().equals(e2.getCedula())) 
          return 0;

        int cmp = Integer.compare(e1.getPromedio(), e2.getPromedio());
        if (cmp != 0) 
        return cmp;

        cmp = e1.getNombre().compareTo(e2.getNombre());
        if (cmp != 0)
        return cmp; 

        return e1.getCedula().compareTo(e2.getCedula());
      } 
    });
    ordenador.addAll(estudiantes);
    return ordenador;  
  }

  public Map<String ,List<Estudiante>> clasificarPorPorcentaje(Set<Estudiante> ordenados){
    Map<String, List<Estudiante>> mapa = new LinkedHashMap<>();
    for(String cat : Arrays.asList("A", "B" , "C" , "D" , "E")){
      mapa.put(cat, new LinkedList<>());
    }
    for(Estudiante e : ordenados){
      int p = e.getPorcentajesUnicos();
      String categoria;
      if (p >= 90) categoria = "A";
      else if (p >= 70) categoria = "B";
      else if (p >= 50) categoria = "C";
      else if (p >= 30) categoria = "D";
      else categoria = "E";
        
      mapa.get(categoria).add(e);
        
    }        
     return mapa; 
  }
  public List<Estudiante> obtenerEstudianteDestacados (List<Estudiante> lista){
    List<Estudiante> destacados = new ArrayList<>();
    for(Estudiante e : lista){
      if (e.getPromedio() > 7) {
        destacados.add(e); 
      }
    }
    destacados.sort(Comparator.comparing(Estudiante :: getNombre));
    return destacados;
  }
  public Estudiante buscarPorNombre(List<Estudiante> lista , String nombre){
    int izquierda = 0;
    int derecha = lista.size() - 1;

    while (izquierda <= derecha) {
      int medio = (izquierda + derecha) / 2 ;
      Estudiante actual = lista.get(medio);
      int cmp = actual.getNombre().compareTo(nombre);

      if (cmp == 0)
      return actual;

      else if (cmp < 0)
      izquierda = medio + 1;

      else derecha = medio-1;
     
    }
    return null;
  }
}
