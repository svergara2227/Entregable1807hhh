import javax.swing.*;
import java.util.HashMap;

public class RestauranteMenu {
    public static void main(String[] args) {
        int codMenuPpal = 0;
        int totalPlatos = 0;
        int totalPlatosTipicos = 0;
        int totalPlatosCarta = 0;
        int totalPlatosInternacionales = 0;
        double totalPagar = 0.0;
        String userName = JOptionPane.showInputDialog("Ingrese su nombre:");

        HashMap<Integer, String> platosTipicos = new HashMap<>();
        HashMap<Integer, Double> preciosTipicos = new HashMap<>();
        platosTipicos.put(1, "Bandeja Paisa");
        platosTipicos.put(2, "Sancocho");
        preciosTipicos.put(1, 10.0);
        preciosTipicos.put(2, 8.0);

        HashMap<Integer, String> platosCarta = new HashMap<>();
        HashMap<Integer, Double> preciosCarta = new HashMap<>();
        platosCarta.put(1, "Steak");
        platosCarta.put(2, "Lobster");
        preciosCarta.put(1, 20.0);
        preciosCarta.put(2, 25.0);

        HashMap<Integer, String> platosInternacionales = new HashMap<>();
        HashMap<Integer, Double> preciosInternacionales = new HashMap<>();
        platosInternacionales.put(1, "Sushi");
        platosInternacionales.put(2, "Paella");
        preciosInternacionales.put(1, 15.0);
        preciosInternacionales.put(2, 18.0);

        do {
            String menu = "MENU RESTAURANTE\n\n";
            menu += "1. Platos Tipicos\n";
            menu += "2. Platos a la Carta\n";
            menu += "3. Platos Internacionales\n";
            menu += "4. Salir\n\n";
            menu += "Por favor seleccione una opción \n";
            codMenuPpal = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (codMenuPpal) {
                case 1:
                    totalPagar += mostrarPlatos(platosTipicos, preciosTipicos, "Platos Tipicos");
                    totalPlatosTipicos += 1;
                    break;
                case 2:
                    totalPagar += mostrarPlatos(platosCarta, preciosCarta, "Platos a la Carta");
                    totalPlatosCarta += 1;
                    break;
                case 3:
                    totalPagar += mostrarPlatos(platosInternacionales, preciosInternacionales, "Platos Internacionales");
                    totalPlatosInternacionales += 1;
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por visitar nuestro restaurante!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
            }
            totalPlatos = totalPlatosTipicos + totalPlatosCarta + totalPlatosInternacionales;
        } while (codMenuPpal != 4);

        JOptionPane.showMessageDialog(null, "Usuario: " + userName
                + "\nTotal de platos procesados: " + totalPlatos
                + "\nPlatos Tipicos: " + totalPlatosTipicos
                + "\nPlatos a la Carta: " + totalPlatosCarta
                + "\nPlatos Internacionales: " + totalPlatosInternacionales
                + "\nTotal a pagar: $" + totalPagar);
    }

    public static double mostrarPlatos(HashMap<Integer, String> platos, HashMap<Integer, Double> precios, String titulo) {
        StringBuilder menu = new StringBuilder(titulo + "\n\n");
        for (Integer key : platos.keySet()) {
            menu.append(key).append(". ").append(platos.get(key)).append(" - $").append(precios.get(key)).append("\n");
        }
        menu.append("\nPor favor seleccione una opción \n");
        int seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu.toString()));
        if (platos.containsKey(seleccion)) {
            JOptionPane.showMessageDialog(null, "Ha seleccionado: " + platos.get(seleccion));
            return precios.get(seleccion);
        } else {
            JOptionPane.showMessageDialog(null, "Selección no válida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
    }
}
