import math
def iter_pi(epsilon):
    epsilon /= 4
    pi = 0
    true_pi = math.pi/4
    positive = True
    val = 1
    iteration = 0
    while abs(pi - true_pi) > epsilon:
        print(true_pi, pi, val, epsilon)
        iteration += 1
        pi = pi + 1/val if positive else pi - 1/val
        positive = False if positive else True
        val += 2
    return [iteration, round(pi*4, 10)]

print(iter_pi(0.1))