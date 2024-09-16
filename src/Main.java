import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Sabor sabor = seleccionarSabor(scanner);
            Tamaño tamaño = seleccionarTamaño(scanner);

            mostrarResultado(sabor, tamaño);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para seleccionar el sabor
    private static Sabor seleccionarSabor(Scanner scanner) {
        System.out.println("Bienvenido a la máquina de helados!");
        System.out.println("Seleccione un sabor de helado:");
        System.out.println("1. Vainilla");
        System.out.println("2. Chocolate");
        System.out.println("3. Fresa");
        System.out.print("Ingrese el número correspondiente al sabor: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                return Sabor.VAINILLA;
            case 2:
                return Sabor.CHOCOLATE;
            case 3:
                return Sabor.FRESA;
            default:
                throw new IllegalArgumentException("Selección no válida de sabor.");
        }
    }

    // Método para seleccionar el tamaño
    private static Tamaño seleccionarTamaño(Scanner scanner) {
        System.out.println("Seleccione un tamaño de helado:");
        System.out.println("1. Pequeño ($2)");
        System.out.println("2. Mediano ($3)");
        System.out.println("3. Grande ($4)");
        System.out.print("Ingrese el número correspondiente al tamaño: ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                return Tamaño.PEQUEÑO;
            case 2:
                return Tamaño.MEDIANO;
            case 3:
                return Tamaño.GRANDE;
            default:
                throw new IllegalArgumentException("Selección no válida de tamaño.");
        }
    }

    // Método para mostrar el resultado
    private static void mostrarResultado(Sabor sabor, Tamaño tamaño) {
        System.out.println("Usted ha seleccionado un helado de " + sabor + " de tamaño " + tamaño + ".");
        System.out.println("El precio total es: $" + tamaño.getPrecio());
    }

    // Enum para los sabores
    enum Sabor {
        VAINILLA, CHOCOLATE, FRESA
    }

    // Enum para los tamaños
    enum Tamaño {
        PEQUEÑO(2), MEDIANO(3), GRANDE(4);

        private final int precio;

        Tamaño(int precio) {
            this.precio = precio;
        }

        public int getPrecio() {
            return this.precio;
        }
    }
}
