/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import org.nfunk.jep.JEP;

/**
 *
 * @author villa
 */
public class Secante {

    double x0, x1, xr;
    private final String xrf = "xb - ((fxb * (xa - xb))/(fxa - fxb))";
    private final String error = "((xr-x1)/xr)*100";
    private String funcion;
    JEP jep = new JEP();
    double tolenrancia = 0.05;

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters"> 
    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }
    // </editor-fold>

    public boolean evaluarFx() {
        if (evaluar(x0, funcion) < 0 && evaluar(x1, funcion) > 0) {
            return true;
        }

        return false;
    }

    public double evaluar(double valor, String fx) {
        if (funcion.contains("e")) {
            jep.addVariable("e", Math.E);
        }

        jep.addVariable("x", valor);
        jep.parseExpression(fx);
        return jep.getValue();
    }

    public double evaluar(double xi, double fxi, double xo, double fxo, String fx) {
        jep.addVariable("xb", xi);
        jep.addVariable("xa", xo);
        jep.addVariable("fxb", fxi);
        jep.addVariable("fxa", fxo);
        jep.parseExpression(fx);
        return jep.getValue();
    }

    public double evaluar(double xb, double xa, String fx) {
        jep.addVariable("xr", xb);
        jep.addVariable("x1", xa);
        jep.parseExpression(fx);
        return jep.getValue();
    }

    public void n() {
        double fxa, fxb, errorx;

        if (!evaluarFx()) {
            funcion = "(" + funcion + ")*-1";
        }

        do {
            fxa = evaluar(x0, funcion);
            fxb = evaluar(x1, funcion);
            xr = evaluar(x1, fxb, x0, fxa, xrf);
                errorx = evaluar(xr, x1, this.error);
            System.out.println(xr+" -- "+errorx);
            x0 = x1;
            x1 = xr;
        } while (Math.abs(errorx) > tolenrancia);

    }
}