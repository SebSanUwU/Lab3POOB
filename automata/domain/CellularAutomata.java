package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class CellularAutomata{
    static private int LENGTH=30;
    private Item[][] automata;
    
    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
    }

    public int  getLength(){
        return LENGTH;
    }

    public Item getItem(int r,int c){
        return automata[r][c];
    }

    public void setItem(int r, int c, Item e){
        automata[r][c]=e;
    }

    public void someItems(){
        new Cell(this, 5, 5);
    }
    
    public void someItems(int r, int c){
        new Cell(this, r, c);
    }
    
    public void someItemsSocial(int r, int c){
        new Sociable(this, r, c);
    }
    
    public void someItemsHeater(int r, int c){
        new Heater(this,r,c);
    }
    
    public void ticTac(){
        Item[][] automataCopy = new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automataCopy[r][c]=this.getItem(r,c);
            }
        }
        
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                if(automataCopy[r][c] != null){
                    System.out.println(r+","+c);
                    automataCopy[r][c].decide();
                    automataCopy[r][c].change();
                }
            }
        }
    }

}
