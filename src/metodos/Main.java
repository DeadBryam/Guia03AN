/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


/**
 *
 * @author doratt
 */
public class Main {
    
    public static void main(String[] args) {
        
        Muller m =new Muller();
        m.setFuncion("e^-x-x");
        m.setX0(0);
        m.setX1(0.5);
        m.setX2(1);
        m.calcularRaiz();
    }
    
    
}
