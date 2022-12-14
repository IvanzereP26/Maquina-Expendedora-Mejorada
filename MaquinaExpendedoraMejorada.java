public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El numero de billetes que se han vendido
    private int numeroBilletesVendidos;
    // Si tiene premio o no
    private boolean billetePremiado;
    // Numero maximo de billetes
    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(boolean premios, int maxBilletes) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Le?n";
        estacionDestino = "Sevilla";
        billetePremiado = premios;
        maximoBilletes = maxBilletes;
    }
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premios, int maxBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetePremiado = premios;
        maximoBilletes = maxBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos != maximoBilletes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else {
            System.out.println("Lo sentimos, se han vendido todos los billetes...");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDelDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroBilletesVendidos != maximoBilletes){
            if (cantidadDelDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println(); 
                numeroBilletesVendidos += 1;
                if (numeroBilletesVendidos % 4 == 0){
                    if (billetePremiado == true){
                        double descuento = precioBillete * 0.25;
                        System.out.println("??Este billete tiene un premio de "+ descuento + "? de descuento!!");
                    }
                }
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //
            }       
            else {
                System.out.println("Necesitas introducir " + (cantidadDelDineroQueFalta) + " euros mas!");
            }
        }
        else {
            System.out.println ("No quedan billetes a la venta en la maquina, lo siento");
        }
    }
    
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("Se han vendido la cantidad de " + numeroBilletesVendidos + " billetes.");
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    public int vaciarDineroDeLaMaquina () {
        int dineroAcumulado = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0){
            totalDineroAcumulado = 0;
        }
        else{
            dineroAcumulado = -1;
            System.out.println("Hay una operacion en curso, no se puede retirar el dinero en estos momentos");
        }
        return dineroAcumulado;
    }
}
