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
                System.out.println("escoja la moneda:");
                var base = lectura.nextLine();
                System.out.println("escoja la moneda:");
                var objetivo = lectura.nextLine();
                System.out.println("cantidad:");
                var cantidad = Double.valueOf(lectura.nextLine());
                Conversion conversion = consulta.conversion(base,objetivo,cantidad);
                System.out.println(conversion);}
            else if(opcion.equalsIgnoreCase("1")) {
                Moneda monedas = consulta.buscaMonedas();
                System.out.println(monedas);
            }else{
                System.out.println("Opción no validad");
            }

        }

        //Moneda monedas = consulta.buscaMonedas();
        //System.out.println(monedas);


    }
}
