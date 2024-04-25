import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        while(true) {
            System.out.println("***********************************" +
                    "\n*       CONVERSOR DE MONEDAS      *"+
                    "\n*            BIENVENIDO           *"+
                    "\n* PARA COMENZAR ESCOJA UNA OPCION *"+
                    "\n***********************************"+
                    "\n1 Consultar monedas soportadas."+
                    "\n2 Convertir moneda a otra."+
                    "\n3 Salir.");
            var opcion = lectura.nextLine();

            if (opcion.equalsIgnoreCase("3")) {
                break;
            } else if(opcion.equalsIgnoreCase("2")){
                try{
                    System.out.println("escoja la moneda que quiere convertir (ej: USD,COP,ARS,BOB,BRL,CLP):");
                    var base = lectura.nextLine().toUpperCase();
                    System.out.println("escoja la moneda a la que desea convertir (ej: USD,COP,ARS,BOB,BRL,CLP):");
                    var objetivo = lectura.nextLine().toUpperCase();
                    System.out.println("indique la cantidad a convertir (solo números):");
                    var cantidad = Double.valueOf(lectura.nextLine());
                    Conversion conversion = consulta.conversion(base,objetivo,cantidad);
                    System.out.println(cantidad+" "+base+" son equivalentes a: "+conversion.conversion_result()+" "+objetivo+"\ntasa de conversion de:"+ conversion.conversion_rate());
                    System.out.println("ingrese cualquier tecla para continuar");
                    var salida = lectura.nextLine();
                }
                catch (NumberFormatException e) {
                    System.out.println("la cantidad ingresada no es númerica");
                    System.out.println("ingrese cualquier tecla para continuar");
                    var salida = lectura.nextLine();
                }
            } else if(opcion.equalsIgnoreCase("1")) {
                Moneda monedas = consulta.buscaMonedas();
                Iterator iter = monedas.supported_codes().iterator();
                while (iter.hasNext())
                    System.out.println(iter.next());
                System.out.println("ingrese cualquier tecla para continuar");
                var salida = lectura.nextLine();
            } else{
                System.out.println("Opción no validad. ingrese cualquier tecla para continuar");
                var salida = lectura.nextLine();
            }

        }
    }
}