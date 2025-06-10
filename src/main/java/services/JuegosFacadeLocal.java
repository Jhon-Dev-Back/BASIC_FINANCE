/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Juegos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface JuegosFacadeLocal {

    void create(Juegos juegos);

    void edit(Juegos juegos);

    void remove(Juegos juegos);

    Juegos find(Object id);

    List<Juegos> findAll();

    List<Juegos> findRange(int[] range);

    int count();
    
}
