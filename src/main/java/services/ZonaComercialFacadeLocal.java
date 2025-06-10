/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.ZonaComercial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface ZonaComercialFacadeLocal {

    void create(ZonaComercial zonaComercial);

    void edit(ZonaComercial zonaComercial);

    void remove(ZonaComercial zonaComercial);

    ZonaComercial find(Object id);

    List<ZonaComercial> findAll();

    List<ZonaComercial> findRange(int[] range);

    int count();
    
}
