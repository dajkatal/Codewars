import math
def is_prime(num):
    if num <=1:
        return False
    if num == 2:
        return True
    n = 2
    while n <= math.ceil(math.sqrt(num)):
        if num % n == 0:
            return False
        n += 1
    return True
