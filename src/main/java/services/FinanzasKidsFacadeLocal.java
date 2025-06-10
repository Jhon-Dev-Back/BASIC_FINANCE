/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.FinanzasKids;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface FinanzasKidsFacadeLocal {

    void create(FinanzasKids finanzasKids);

    void edit(FinanzasKids finanzasKids);

    void remove(FinanzasKids finanzasKids);

    FinanzasKids find(Object id);

    List<FinanzasKids> findAll();

    List<FinanzasKids> findRange(int[] range);

    int count();
    
}
