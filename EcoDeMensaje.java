import java.io.BufferedReader;
import java.io.InputStreamReader;

//El programa envia un mensaje a un script de elixir y recibe el mismo mensaje como respuesta en mayusculas
public class EcoDeMensaje {
    public static void main(String[] args) {
        try {
            // String fija
            String mensaje = "Hola mundo, soy Juan";

            // Ejecuta el script de Elixir
            ProcessBuilder pb = new ProcessBuilder(
            "C:\\Program Files\\Elixir\\bin\\elixir.bat",
            "C:\\Users\\User\\OneDrive\\Documentos\\programacion 3 21-08-2025\\Tarea-3-ejercicios\\EcoDeMensaje.exs",
            mensaje);  
            pb.redirectErrorStream(true);
            Process process = pb.start();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
            }
            String respuesta = output.toString().trim();

            System.out.println("Respuesta de Elixir: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}