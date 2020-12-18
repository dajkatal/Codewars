def who_is_next(names, r):
    repetitions = 1
    n = len(names)
    while r > n:
        r -= n
        n *= 2
        repetitions *= 2
    idx = 0
    while r > repetitions:
        r -= repetitions
        idx += 1
    return names[idx]
