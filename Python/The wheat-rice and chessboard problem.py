def squares_needed(grains):
    i = 0
    past = 0
    if grains == 0:
        return 0
    while True:
        if 2**i + past >= grains:
            return (i+1)
        past += 2**i
        i += 1

