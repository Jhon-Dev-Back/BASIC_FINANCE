/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.PautaPublicitaria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface PautaPublicitariaFacadeLocal {

    void create(PautaPublicitaria pautaPublicitaria);

    void edit(PautaPublicitaria pautaPublicitaria);

    void remove(PautaPublicitaria pautaPublicitaria);

    PautaPublicitaria find(Object id);

    List<PautaPublicitaria> findAll();

    List<PautaPublicitaria> findRange(int[] range);

    int count();
    
}
