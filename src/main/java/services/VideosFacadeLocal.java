/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Videos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhon Deibys Torres
 */
@Local
public interface VideosFacadeLocal {

    void create(Videos videos);

    void edit(Videos videos);

    void remove(Videos videos);

    Videos find(Object id);

    List<Videos> findAll();

    List<Videos> findRange(int[] range);

    int count();
    
}
