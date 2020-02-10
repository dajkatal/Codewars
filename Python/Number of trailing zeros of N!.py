import math
def zeros(n):
    trailing = 0
    while True:
        if (n/5) >= 1:
            trailing += n//5
            n /= 5
        else:
            break
    return int(trailing)

