/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Convenios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface ConveniosFacadeLocal {

    void create(Convenios convenios);

    void edit(Convenios convenios);

    void remove(Convenios convenios);

    Convenios find(Object id);

    List<Convenios> findAll();

    List<Convenios> findRange(int[] range);

    int count();
    
}
