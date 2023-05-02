package actividad02;
import java.util.Scanner;

public class Pregunta1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int edad;
        int contadorP= 0;
        int contadorN = 0;
        int mujeresMayores50 = 0;
        int mujeresMayores50Positivo = 0;
        double sumaEdadP = 0;
        double sumaEdadN = 0;
        int totalPruebas = 0;
        String genero;

        while (continuar){
            System.out.println("Ingrese los resultados de las pruebas (P/N). Ingrese X cuando termine la atención del día.");
            String resultado = sc.nextLine();
            if (resultado.equals("X")) {
                continuar = false;
                System.out.println("Salir dia de atención");
            }else {
                System.out.print("Edad: ");
                edad = sc.nextInt();
                sc.nextLine();
                System.out.print("Género (M/F): ");
                genero = sc.nextLine();

                if (resultado.equals("P")){
                    sumaEdadP += edad;
                    contadorP++;
                    if (genero.equals("F")){
                        mujeresMayores50++;
                        if (edad > 50){
                            mujeresMayores50Positivo++;
                        }
                    }
                }else if (resultado.equals("N")){
                    sumaEdadN += edad;
                    contadorN++;
                }
                totalPruebas++;

            }
        }
        promedioEdadPN(sumaEdadP, contadorP, sumaEdadN, contadorN);
        promedioMujeresMayor50(mujeresMayores50, mujeresMayores50Positivo);
        totalPruebasRealizas(contadorP, contadorN, totalPruebas);

    }

    private static void totalPruebasRealizas(int contadorP, int contadorN, int totalPruebas) {
        System.out.print("3. Porcentaje de pruebas realizadas\n");
        System.out.printf("Positivo (P) Realizados: %.2f%%\n", (double) contadorP/totalPruebas *100);
        System.out.printf("Negativo (N) Realizados: %.2f%%\n", (double) contadorN/totalPruebas *100);
    }

    private static void promedioMujeresMayor50(int mujeresMayores50, int mujeresMayores50Positivo) {
        System.out.print("2. Promedio de mujeres de 50 años que dieron Positivo: \n");
        if (mujeresMayores50 > 0){
            System.out.printf("Positivo (P): %.2f%%\n", ((double)mujeresMayores50Positivo / mujeresMayores50) * 100);
        }else{
            System.out.printf("Positivo (P): %.2f%%\n", ((double)mujeresMayores50Positivo / mujeresMayores50) * 100);
        }

    }

    private static void promedioEdadPN(double sumaEdadP, int contadorP, double sumaEdadN, int contadorN) {
        System.out.print("1. Promedio de edad\n");
        System.out.printf("Positivo (P): %.2f años\n", sumaEdadP/contadorP );
        System.out.printf("Positivo (N): %.2f años\n", sumaEdadN/contadorN);
    }

}
