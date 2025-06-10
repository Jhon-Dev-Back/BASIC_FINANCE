/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Encabezado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface EncabezadoFacadeLocal {

    void create(Encabezado encabezado);

    void edit(Encabezado encabezado);

    void remove(Encabezado encabezado);

    Encabezado find(Object id);

    List<Encabezado> findAll();

    List<Encabezado> findRange(int[] range);

    int count();
    
}
