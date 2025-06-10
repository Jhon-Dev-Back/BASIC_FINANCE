/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Transacciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface TransaccionesFacadeLocal {

    void create(Transacciones transacciones);

    void edit(Transacciones transacciones);

    void remove(Transacciones transacciones);

    Transacciones find(Object id);

    List<Transacciones> findAll();

    List<Transacciones> findRange(int[] range);

    int count();
    
}
