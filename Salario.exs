# Script que calcula el salario neto de un empleado considerando horas extra.
# Autor: Juan Esteban Piñeros Maldonado
# Fecha: 26/08/2025
# Licencia: GNU GPL V3

defmodule Salario do
  @moduledoc """
  Calcula el salario neto de un empleado.
  Si trabaja más de 160 horas, las horas extra se pagan al 125% del valor normal.
  """

  @doc """
  Metodo que calcula el salario total.
    - Si hay horas extra (>160), las calcula y suma al salario base.
    - Recibe las horas trabajadas y el valor por hora.
    - Retorna el salario total.
  """
  def calcular_salario(horas, valor_hora) do
    horas_extra = if horas > 160, do: horas - 160, else: 0
    ((horas-horas_extra) * valor_hora) + calcular_salario_extra(horas_extra, valor_hora)
  end

  @doc """
  metodo que calcula el valor de las horas extra.
    - Se pagan al 125% del valor normal.
    - Recibe las horas extra y el valor por hora.
    - Retorna el valor total de las horas extra.
  """
  def calcular_salario_extra(horas_extra, valor_hora) do
    horas_extra * (valor_hora * 1.25)
  end
end

case System.argv() do
  [arg1, arg2] ->
    horas = String.trim(arg1) |> String.to_integer()
    valor_hora = String.trim(arg2) |> String.to_integer()
    IO.puts(Float.round(Salario.calcular_salario(horas, valor_hora), 2))
  _ ->
    IO.puts("Debe ingresar las horas trabajadas y el valor por hora como argumentos")
end
