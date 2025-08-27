import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Salario {
    public static void main(String[] args) {
        try {
            // Solicitar datos al usuario
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            String horas = JOptionPane.showInputDialog("Ingrese las horas trabajadas:");
            String valor_hora = JOptionPane.showInputDialog("Ingrese el valor de su trabajo por hora:");

            // Ejecuta el script de Elixir con los argumentos
            ProcessBuilder pb = new ProcessBuilder(
                "C:\\Program Files\\Elixir\\bin\\elixir.bat",
                "C:\\Users\\User\\OneDrive\\Documentos\\programacion 3 21-08-2025\\Tarea-3-ejercicios\\Salario.exs",
                horas.trim(),
                valor_hora.trim()
            );
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Lee todas las líneas de la salida y guarda la última (el resultado)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String salarioNeto = "";
            String line;
            while ((line = reader.readLine()) != null) {
                salarioNeto = line;
            }

            JOptionPane.showMessageDialog(null, "El Salario Neto de " + nombre + " es: " + salarioNeto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
