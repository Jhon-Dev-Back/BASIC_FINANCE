/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.ComprobantePago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface ComprobantePagoFacadeLocal {

    void create(ComprobantePago comprobantePago);

    void edit(ComprobantePago comprobantePago);

    void remove(ComprobantePago comprobantePago);

    ComprobantePago find(Object id);

    List<ComprobantePago> findAll();

    List<ComprobantePago> findRange(int[] range);

    int count();
    
}
