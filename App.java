import java.util.Scanner;

public class App {
    static class OpticsCalculator {
        public static double hitungJarakBayangan(double fokus, double jarakBenda) {
            if (fokus == 0 || jarakBenda == 0) {
                throw new IllegalArgumentException("Fokus dan jarak benda tidak boleh 0.");
            }
            double inversF = 1.0 / fokus;
            double inversS = 1.0 / jarakBenda;
            double inversSPrim = inversF - inversS;
            if (inversSPrim == 0) {
                throw new IllegalArgumentException("Perhitungan menghasilkan pembagian nol.");
            }
            return 1.0 / inversSPrim;
        }
    }
    static class InputHelper {
        public static double getDoubleInput(Scanner scanner) {
            while (true) {
                try {
                    return Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.print("Masukkan angka desimal yang valid: ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== KALKULATOR OPTIK – Lensa Tipis ===");
        System.out.println("Rumus: 1/f = 1/s + 1/s'");
        System.out.println("* Fokus positif untuk lensa/cermin cembung");
        System.out.println("* Gunakan satuan meter (m)");

        System.out.print("Masukkan panjang fokus (f): ");
        double fokus = InputHelper.getDoubleInput(scanner);

        System.out.print("Masukkan jarak benda (s): ");
        double jarakBenda = InputHelper.getDoubleInput(scanner);

        try {
            double jarakBayangan = OpticsCalculator.hitungJarakBayangan(fokus, jarakBenda);
            System.out.printf("Jarak bayangan (s') = %.2f meter%n", jarakBayangan);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
