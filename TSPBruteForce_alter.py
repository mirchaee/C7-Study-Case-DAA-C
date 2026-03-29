import itertools

def tsp_brute_force(distances):
    n = len(distances)
    kota = list(range(1, n))
    jarak_minimum = float('inf')
    rute_terbaik = []
    for p in itertools.permutations(kota):
        jarak_sekarang = 0
        kota_sebelumnya = 0
        for kota_tujuan in p:
            jarak_sekarang += distances[kota_sebelumnya][kota_tujuan]
            kota_sebelumnya = kota_tujuan
        jarak_sekarang += distances[kota_sebelumnya][0]

        if jarak_sekarang < jarak_minimum:
            jarak_minimum = jarak_sekarang
            rute_terbaik = p
    return rute_terbaik, jarak_minimum
distances = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]
rute, jarak = tsp_brute_force(distances)
print(f"Rute Terbaik: [0, {', '.join(map(str, rute))}, 0]")
print(f"Jarak Minimum: {jarak}")
