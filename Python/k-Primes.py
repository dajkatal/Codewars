import math
def primeFactors(n):
    primes = 0
    while n % 2 == 0:
        primes += 1
        n = n / 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n < i:
            break
        while n % i == 0:
            primes += 1
            n = n / i
    if n > 2:
        primes += 1
    return primes

def count_Kprimes(k, start, nd):
    return [num for num in range(start if start > 0 else 1, nd+1) if primeFactors(num) == k]

def puzzle(s):
    number = 0
    prime3 = count_Kprimes(1, 2, s)
    prime5 = count_Kprimes(3, 2, s)
    prime7 = count_Kprimes(7, 2, s)
    for tres in range(len(prime3)):
        for cinco in range(len(prime5)):
            for siete in range(len(prime7)):
                if prime3[tres] + prime5[cinco] + prime7[siete] == s: number += 1
    return number

#print(count_Kprimes(2, 0, 100))
print(puzzle(0))


