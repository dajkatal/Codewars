def DNA_strand(dna):
    new = ''
    for _ in range(len(dna)):
        val = dna[_]
        new += 'T' if val == 'A' else 'A' if val == 'T' else 'C' if val == 'G' else 'G'
    return new