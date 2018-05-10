/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Marine
 */
public class ExceptionMembreInexistant  extends Exception{
    
    public ExceptionMembreInexistant(){
        
    }
    
    public ExceptionMembreInexistant(String ErrorMessage) {
        super(ErrorMessage);
    }
}
