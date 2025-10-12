/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deposito;

/**
 *
 * @author Aroa Ramos
 * @version v1
 * @since 02/04/2025
 */
public class CCuenta {
    
    // A T R I B U T O S
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    
    //C O N S T R U C T O R E S
    /**
     * Constructor vacío
     */
    public CCuenta() {
    }

    /**
     * Constructor que inicializa los atributos de la clase
     * @param nombre Nombre del titular de la cuenta
     * @param cuenta Cuenta del titular
     * @param saldo Saldo de la cuenta del titular
     * @param tipoInteres Tipo de interés que tiene la cuenta
     */
    public CCuenta(String nombre, String cuenta, double saldo, double tipoInteres) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }
    
    /**
     * Devuelve el saldo de la cuenta
     * @return saldo
     */
    public double estado(){
        return saldo;
    }
    
    /**
     * Permite ingresar una cantidad mayor que 0
     * @param cantidad Cantidad a ingresar
     * @throws Exception Lanza excepción genérica
     */
    public void ingresar(double cantidad) throws Exception{
        if(cantidad < 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo =+ cantidad;    
    }
    
    /**
     * Permite retirar una cantidad mayor que 0 y menor que el saldo actual
     * @param cantidad Cantidad a ingresar
     * @throws Exception Lanza excepción genérica
     */
    public void retirar(double cantidad) throws Exception{
        
        if(cantidad <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        
        if(estado() < cantidad)
            throw new Exception ("No hay suficiente saldo");
        saldo =- cantidad;
        
    }
    
    
    
}
