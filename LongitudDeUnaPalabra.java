import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class LongitudDeUnaPalabra {
        public static void main(String[] args) {
        try {
            // Solicita una palabra :)
            String palabra = JOptionPane.showInputDialog("Digite una palabra:");

            // ProcessBuilder permite crear y ejecutar procesos del sistema operativo desde Java.
            // Aquí se construye el comando para ejecutar el script de Elixir.
            // Esto ejecuta el script de Elixir y le pasa la palabra como un argumento.
            ProcessBuilder pb = new ProcessBuilder(
            "C:\\Program Files\\Elixir\\bin\\elixir.bat",
            "C:\\Users\\User\\OneDrive\\Documentos\\programacion 3 21-08-2025\\Tarea-3-ejercicios\\LongitudDeUnaPalabra.exs",
            palabra);
        

            // Redirige el flujo de error al flujo de salida estándar, así puedes leer ambos por el mismo canal
            pb.redirectErrorStream(true);

            // Se ejecuta el comando
            Process process = pb.start();

            // Crea un BufferedReader para leer la salida
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Lee la primera línea de la salida, que es la longitud de la palabra
            String resultado = reader.readLine();

            JOptionPane.showMessageDialog(null, "Cantidad de letras: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
