/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.FinanzasPersonales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface FinanzasPersonalesFacadeLocal {

    void create(FinanzasPersonales finanzasPersonales);

    void edit(FinanzasPersonales finanzasPersonales);

    void remove(FinanzasPersonales finanzasPersonales);

    FinanzasPersonales find(Object id);

    List<FinanzasPersonales> findAll();

    List<FinanzasPersonales> findRange(int[] range);

    int count();
    
}
