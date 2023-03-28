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

    public void someItems(int r, int c){
        new Cell(this, r, c);
    }
    
    public void someItemsSocial(int r, int c){
        new Sociable(this, r, c);
    }
    
    public void someSensibleItems(int r, int c){
        new Sensible(this, r, c);
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
                    //System.out.println(r+","+c);
                    automataCopy[r][c].decide();
                    automataCopy[r][c].change();
                }
            }
        }
    }
    /**
     * Metodo que identifica los vecinos del item.
     * @param, row fila del item.
     * @param column, columna del item
     * @return arreglo de Item
     */
    public Item[] getVecinos(int row, int column){
        Item[] vecinos = new Item[8];
        //Se mira vecino al norte
        try{
            vecinos[0] = getItem(row - 1,column);
        }catch(IndexOutOfBoundsException v){
            vecinos[0] = null;
        }
        //Se mira el vecino al noreste
        try{
            vecinos[1] = getItem(row-1,column + 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[1] = null;
        }
        //Se mira vecino al este
        try{
            vecinos[2] = getItem(row,column + 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[2] = null;
        }
        //Se mira el vecino al sureste
        try{
            vecinos[3] = getItem(row+1,column + 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[3] = null;
        }
        //Se mira vecino al sur
        try{
            vecinos[4] = getItem(row + 1,column);
        }catch(IndexOutOfBoundsException v){
            vecinos[4] = null;
        }
        //Se mira el vecino al suroeste
        try{
            vecinos[5] = getItem(row+1,column - 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[5] = null;
        }
        //Se mira vecino al oeste
        try{
            vecinos[6] = getItem(row,column - 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[6] = null;
        }
        //Se mira el vecino al noroeste
        try{
            vecinos[7] = getItem(row-1,column - 1);
        }catch(IndexOutOfBoundsException v){
            vecinos[7] = null;
        }
        return vecinos;
    }

}
