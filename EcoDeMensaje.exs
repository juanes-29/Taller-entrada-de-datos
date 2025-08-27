defmodule EcoDeMensajeScript do
  @moduledoc """
  Un script que imprime en mayúsculas el mensaje recibido.
  ## Autor: Juan Esteban Piñeros Maldonado
  ## Fecha: 26/08/2025
  ## Licencia: GNU GPL V3
  """

  @doc """
  Función principal que:
    - Obtiene los argumentos de la línea de comandos.
    - Une los argumentos en un solo string.
    - Imprime el mensaje en mayúsculas que es lo que pide el problema.
  """
  def main do
    mensaje = System.argv()
    |> Enum.join(" ")
    IO.puts String.upcase(mensaje)
  end
end

EcoDeMensajeScript.main()
