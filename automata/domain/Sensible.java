package domain;
import java.awt.Color;

/**
 * Write a description of class Sensible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sensible extends Cell
{
    // instance variables - replace the example below with your own
    private int x;
    

    public Sensible(CellularAutomata ac,int row, int column){
        super(ac,row,column);
        color = Color.blue;
        ac.getVecinos(row,column);
    }
    
    
    public void decide() {
        CellularAutomata au=this.getAutomata();
        int row = getRow();
        int column = getColumn();
        if(isAlive()){
            if(vecinosMuertos() > 0){
                nextState=Agent.DEAD;
            }
            if(getAge()>=50){
                nextState=Agent.DEAD;
            }
            if(au.getVecinos(row,column)[4].isAlive()&& 
            (au.getItem(row + 1, column) instanceof Sociable) 
            && ((getAge() + 1)%5 == 0) &&
            au.getItem(row + 1,column + 1) == null){
                au.someItems(row + 1, column + 1);
            }
        }
    }
    
    public int vecinosMuertos(){
        CellularAutomata au=this.getAutomata();
        int vecinosMuertos = 0;
        for(int i = 0; i < 8;i++){
            try{
                if(!au.getVecinos(getRow(), getColumn())[i].isAlive() && au.getVecinos(getRow(), getColumn())[i] instanceof Cell) vecinosMuertos++;
            }catch(NullPointerException e){
                vecinosMuertos = vecinosMuertos;
            }
        }
        return vecinosMuertos;
    }
    
    
}
