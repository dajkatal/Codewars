import math

def get_divisors(x):
    vals = []
    for i in range(1,math.ceil(math.sqrt(x))):
        if x%i == 0:
            vals.append(i**2)
            t = x//i
            if t != i:
                vals.append(t**2)
    return sum(vals)

def list_squared(m, n):
    output = [[1,1]] if m == 1 else []
    for i in range(m, n+1):
        if i == 1:
            continue
        o = get_divisors(i)
        o_sqrt = math.sqrt(o)
        if o_sqrt == int(o_sqrt):
            output.append([i, o])
    return output
