package Ajedrez;
import java.util.Scanner;
public class Ajedrez {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        MovimientoAlfil movimientoAlfil = new MovimientoAlfil();

	        try {
	            System.out.println("Ingrese la posición de partida (fila columna): ");
	            int filaInicio = scanner.nextInt();
	            int columnaInicio = scanner.nextInt();

	            System.out.println("Ingrese la posición de destino (fila columna): ");
	            int filaDestino = scanner.nextInt();
	            int columnaDestino = scanner.nextInt();

	            movimientoAlfil.validarMovimiento(filaInicio, columnaInicio, filaDestino, columnaDestino);
	            System.out.println("Movimiento válido para el alfil.");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	}
class MovimientoAlfil {
    public void validarMovimiento(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino) {
        validarPosicion(filaInicio, columnaInicio);
        validarPosicion(filaDestino, columnaDestino);

        if (esMovimientoValido(filaInicio, columnaInicio, filaDestino, columnaDestino)) {
            throw new IllegalArgumentException("Movimiento incorrecto para el alfil.");
        }
    }

    private void validarPosicion(int fila, int columna) {
        if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
            throw new IllegalArgumentException("Posición fuera de los límites del tablero.");
        }
    }

    private boolean esMovimientoValido(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino) {
        int filaDiferencia = Math.abs(filaInicio - filaDestino);
        int columnaDiferencia = Math.abs(columnaInicio - columnaDestino);

        return filaDiferencia == columnaDiferencia;
    }
}
