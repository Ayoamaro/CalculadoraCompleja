# Calculadora Compleja

Implementar en JavaFX una calculadora de números complejos, que permita sumar, restar, multiplicar y dividir números de este tipo.

Se deberá crear un bean JavaFX de nombre "Complejo" con las propiedades "real" e "imaginario" de tipo "Double": "DoubleProperty".

El aspecto de la interfaz será el siguiente:

![](https://github.com/Ayoamaro/CalculadoraCompleja/blob/main/docs/images/calculadora_compleja.png?raw=true)

![](https://github.com/Ayoamaro/CalculadoraCompleja/blob/main/docs/images/calculadora_compleja(2).png?raw=true)

Las operaciones a realizar son las siguientes:

- Suma: ![](https://raw.githubusercontent.com/Ayoamaro/CalculadoraCompleja/5a6e04e4aee51aa4840be3cce744c7ca10c7b40c/docs/images/formula_suma.svg)
- Resta: ![](https://raw.githubusercontent.com/Ayoamaro/CalculadoraCompleja/5a6e04e4aee51aa4840be3cce744c7ca10c7b40c/docs/images/formula_resta.svg)
- Multiplicación: ![](https://raw.githubusercontent.com/Ayoamaro/CalculadoraCompleja/5a6e04e4aee51aa4840be3cce744c7ca10c7b40c/docs/images/formula_multiplicacion.svg)
- División: ![](https://raw.githubusercontent.com/Ayoamaro/CalculadoraCompleja/5a6e04e4aee51aa4840be3cce744c7ca10c7b40c/docs/images/formula_division.svg)

Donde "a" y "c" son las partes reales de primer y segundo operando respectivamente, y "b" y "d" sus partes imaginarias.

El funcionamiento será el siguiente:

1. Se selecciona la operación a realizar en la lista desplegable (+, -, * y /) [ComboBox]
2. Se introducen los valores de primer y segundo operando complejos.
3. Se pulsa el botón "=", apareciendo el resultado en los campos de la parte inferior.

MEJORA: Quitar el botón "=" y usar Bindings, de forma que cuando se seleccione una operación en la lista desplegable, se generan los bindings automáticamente.

![](https://github.com/Ayoamaro/CalculadoraCompleja/blob/main/docs/images/calculadora_compleja(3).png?raw=true)
