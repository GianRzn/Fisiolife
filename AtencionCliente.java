package fisioLife;
import java.util.Scanner;

public class AtencionCliente {
    private static Scanner sc = new Scanner(System.in);
    private static boolean esPrimeraConsulta = true;
    private static boolean opcion1 = true;
    private static boolean respuesta1 = true;
    private static String[] nombresApellidos = new String[100];
    private static String[] fechaNacimientos = new String[100];
    private static String[] dnis = new String[100];
    private static int[] edades = new int[100];
    private static double[] alturas = new double[100];
    private static double[] pesos = new double[100];
    private static String[] diagnosticos = new String[100];
    private static String[] nombreDoctoras = new String[100];
    private static int[] numeroSecciones = new int[100];
    private static double[] costos = new double[100];
    private static String[] pacientes = new String[100];
    private static String[] evaluaciones = new String[100];
    private static double[] montos = new double[100];
    private static String[] documentosIdentidad = new String[100];
    private static int indiceActual = 0;
    private static int indiceConsulta = 0;

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("             F i s i o - L i f e             ");
        System.out.println("=============================================");
        boolean seguirAtendiendo = true;
        while (seguirAtendiendo) {
            boolean primeraConsulta = preguntarSiEsPrimeraConsulta();
            if (primeraConsulta){
                System.out.println("=============================================");
                System.out.println("Pase a consulta de revisón.");
                System.out.println("=============================================");
                System.out.print("¿Inicia tratamiento? (SI/NO): ");
                String respuesta = sc.nextLine().toLowerCase();
                if (respuesta.equals("si")){
                    registrarHistoriaFisioterapia();
                    respuesta1 = iniciaTratamiento();
                    if (respuesta1){
                        seguirAtendiendo = preguntarSiAtenderOtroPaciente();
                    }
                } else {
                    seguirAtendiendo = preguntarSiAtenderOtroPaciente();
                }
            }else {
                datosDeAtencion();
                generaBoleta();

                System.exit(0);
            }
           // seguirAtendiendo = preguntarSiAtenderOtroPaciente();
        }

    }

    private static void generaBoleta() {
        System.out.println("=============================================");
        System.out.println("Generando Boleta .... ");
        System.out.println("=============================================");
        System.out.print("Ingrese el DNI del paciente para la generación Boleta: ");
        String dniABuscar = sc.nextLine();
        for (int i = 0; i < indiceConsulta; i++) {
            if (documentosIdentidad[i].equals(dniABuscar)) {
                System.out.println("=============================================");
                System.out.println("Boleta  N°402" + (i + 1));
                System.out.println(" - Paciente: " + pacientes[i]);
                System.out.println(" - Diagnostico: " + evaluaciones[i]);
                System.out.println(" - Total a Pagar: " + montos[i]);
                System.out.println("=============================================");
                System.out.println("Gracias por su visita ");
            }
        }
    }
//datos de atencion
    private static void datosDeAtencion() {
        System.out.println("=============================================");
        System.out.println("Ingrese datos de atención del paciente");
        System.out.println("=============================================");
        System.out.print(" - DNI: ");
        String documentoIdentidad = sc.nextLine();
        System.out.print(" - Nombre y Apellido: ");
        String paciente = sc.nextLine();
        System.out.print(" - Diagnostico: ");
        String evaluacion = sc.nextLine();
        System.out.print(" - Costo de sesión: ");
        double monto = sc.nextDouble();
        sc.nextLine();

        pacientes[indiceConsulta] = paciente;
        evaluaciones[indiceConsulta] = evaluacion;
        montos[indiceConsulta] = monto;
        documentosIdentidad[indiceConsulta] = documentoIdentidad;

        indiceConsulta++;
    }
// iniciar tratamiento y agredando mas detalles
    private static boolean iniciaTratamiento() {
        System.out.print("¿Inicia seccion de terapia? (SI/NO): ");
        String respuesta = sc.nextLine().toLowerCase();
        if (respuesta.equals("si")){
            System.out.print("Generando Boleta .... ");
            System.out.print("Ingrese el DNI del paciente para la generación Boleta: ");
            String dniABuscar = sc.nextLine();
            for (int i = 0; i < indiceActual; i++) {
                if (dnis[i].equals(dniABuscar)) {
                    System.out.println("=============================================");
                    System.out.println("Boleta  N°403" + (i + 1));
                    System.out.println(" - Paciente: " + nombresApellidos[i]);
                    System.out.println(" - Diagnostico: " + diagnosticos[i]);
                    System.out.println(" - Total a Pagar: " + costos[i]);
                    System.out.println("=============================================");
                }
            }
            opcion1 = true;
        }else if (respuesta.equals("no")){
            opcion1 = false;
        }
        return opcion1;
    }

    private static boolean preguntarSiAtenderOtroPaciente() {
        System.out.print("¿Va a atender a otro paciente? (SI/NO): ");
        String respuesta = sc.nextLine().toLowerCase();
        while (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("Respuesta inválida. Intente de nuevo.");
            System.out.print("¿Va a atender a otro paciente? (SI/NO): ");
            respuesta = sc.nextLine().toLowerCase();
        }
        return respuesta.equals("si");
    }

    public static boolean preguntarSiEsPrimeraConsulta() {
        System.out.print("¿Es su primera consulta? (SI/NO): ");
        String respuesta = sc.nextLine().toLowerCase();
        while (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("Respuesta inválida. Intente de nuevo.");
            System.out.print("¿Es su primera consulta? (SI/NO): ");
            respuesta = sc.nextLine().toLowerCase();
        }
        return respuesta.equals("si");
    }

    public static void registrarHistoriaFisioterapia() {
        System.out.println("=============================================");
        System.out.println("Registro de Historia Clinica:");
        System.out.print(" - DNI: ");
        String dni = sc.nextLine();
        System.out.print(" - Nombre y Apellido: ");
        String nombreApellido = sc.nextLine();
        System.out.print(" - Fecha Nacimiento: ");
        String fechaNacimiento = sc.nextLine();
        System.out.print(" - Edad: ");
        int edad = sc.nextInt();
        System.out.print(" - Estatura: ");
        double estatura = sc.nextDouble();
        System.out.print(" - Peso: ");
        double peso = sc.nextDouble();
        System.out.print(" - Numero Sesiones: ");
        int numeroSeccion = sc.nextInt();
        sc.nextLine();
        System.out.print(" - Diagnostico: ");
        String resultado = sc.nextLine();
        System.out.print(" - Nombre de la Doctora que atendio: ");
        String nombreDoctora = sc.nextLine();
        System.out.print(" - Costo de sesión: ");
        double costo = sc.nextDouble();
        sc.nextLine();

        dnis[indiceActual] = dni;
        nombresApellidos[indiceActual] = nombreApellido;
        fechaNacimientos[indiceActual] = fechaNacimiento;
        edades[indiceActual] = edad;
        alturas[indiceActual] = estatura;
        pesos[indiceActual] = peso;
        diagnosticos[indiceActual] = resultado;
        nombreDoctoras[indiceActual] = nombreDoctora;
        numeroSecciones[indiceActual] = numeroSeccion;
        costos[indiceActual] = costo;

        indiceActual++;
        System.out.println("=============================================");
        System.out.println("Historia registrada exitosamente!");
        System.out.println("=============================================");
    }
}
