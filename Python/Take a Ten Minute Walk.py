def is_valid_walk(walk):
    up, left = 0, 0
    for val in walk:
        up = up + 1 if val == 'n' else (up - 1 if val == 's' else up)
        left = left + 1 if val == 'w' else (left - 1 if val == 'e' else left)
    return len(walk) == 10 and up == 0 and left == 0