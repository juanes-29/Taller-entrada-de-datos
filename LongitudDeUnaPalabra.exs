# Script que recibe una palabra como argumento y muestra su longitud.
# Autor: Juan Esteban Piñeros Maldonado
# Fecha: 26/08/2025
# Licencia: GNU GPL V3

# Obtiene la primera palabra de los argumentos de línea de comandos
case System.argv() do
  [palabra | _] -> IO.puts String.length(palabra)
  _ -> IO.puts "Debe ingresar una palabra como argumento"
end
