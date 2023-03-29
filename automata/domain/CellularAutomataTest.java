package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * Write a description of class CellularAutomataTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CellularAutomataTest
{
   @Test
   public void shouldTicTac(){
       CellularAutomata auto = new CellularAutomata();
       Cell indiana = new Cell(auto,1,1);
       Cell ceroCeroSiete = new Cell(auto,2,2);
       doTicTac(auto,3);
       assertTrue(indiana.isAlive());
       assertTrue(ceroCeroSiete.isAlive());
   }
   
   @Test
   public void shouldSociableDo(){
       CellularAutomata auto = new CellularAutomata();
       Sociable agamenon = new Sociable(auto,1,2);
       Sociable venus = new Sociable(auto,2,2);
       doTicTac(auto,3);
       assertTrue(agamenon.isAlive());
       assertTrue(venus.isAlive());
       doTicTac(auto,8);
       assertTrue(auto.getItem(1,3).isAlive());
       assertTrue(auto.getItem(1,1).isAlive());
       assertTrue(auto.getItem(2,1).isAlive());
       assertTrue(auto.getItem(2,2).isAlive());
       doTicTac(auto,70);
       assertFalse(agamenon.isAlive());
   }
   
   @Test
   public void shouldHeaterDo(){
       CellularAutomata auto = new CellularAutomata();
       Heater suroeste = new Heater(auto,28,1);
       Heater noreste = new Heater(auto,1,28);
       doTicTac(auto,5);
       assertEquals(suroeste.getColor(),Color.orange);
       assertTrue(suroeste.isAlive());
       assertTrue(noreste.isAlive());
       doTicTac(auto,10);
       assertEquals(suroeste.getColor(),Color.gray);
       assertFalse(suroeste.isAlive());
       assertFalse(noreste.isAlive());
   }
   
   @Test 
   public void shouldSensibleDo(){
       CellularAutomata auto = new CellularAutomata();
       Sensible Camilo = new Sensible(auto,1,2);
       Sensible Juan = new Sensible(auto,1,3);
       Sensible Profesor = new Sensible(auto,4,6);
       Sensible Profesora = new Sensible(auto,5,6);
   }
   
   public void doTicTac(CellularAutomata au,int times){
       for(int i =0;i<times;i++){
           au.ticTac();
       }
   }
}
