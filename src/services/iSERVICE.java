/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author nmedia
 */
public interface iSERVICE <T>{
    void addOne(T t) ;
    void updateOne(T t);
    void deleteOne(int id);
    List<T> selectAll();
    
}
