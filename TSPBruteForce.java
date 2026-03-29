import java.util.*;
//Roniarta Sibarani - 245150200111036
public class TSPBruteForce {
    static int jarakMinimum = Integer.MAX_VALUE;
    static List<Integer> ruteTerbaik = new ArrayList<>();

    public static void main(String[] args) {
        int[][] distances = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int n = distances.length;
        List<Integer> kota = new ArrayList<>();
        for (int i = 1; i < n; i++) kota.add(i);

        permute(kota, 0, distances);

        System.out.println("Rute Terbaik: [0, " + ruteTerbaik.toString().replaceAll("[\\[\\]]", "") + ", 0]");
        System.out.println("Jarak Minimum: " + jarakMinimum);
    }
    static void permute(List<Integer> p, int k, int[][] distances) {
        for (int i = k; i < p.size(); i++) {
            Collections.swap(p, i, k);
            permute(p, k + 1, distances);
            Collections.swap(p, k, i);
        }
        if (k == p.size()) {
            hitungJarak(p, distances);
        }
    }

    static void hitungJarak(List<Integer> p, int[][] distances) {
        int jarakSekarang = 0;
        int kotaSebelumnya = 0; 

        for (int kotaTujuan : p) {
            jarakSekarang += distances[kotaSebelumnya][kotaTujuan];
            kotaSebelumnya = kotaTujuan;
        }
        jarakSekarang += distances[kotaSebelumnya][0];

        if (jarakSekarang < jarakMinimum) {
            jarakMinimum = jarakSekarang;
            ruteTerbaik = new ArrayList<>(p);
        }
    }
}
