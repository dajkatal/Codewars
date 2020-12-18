def tickets(people):
    t = 0
    f = 0
    h = 0
    for customer in people:
        if customer == 25:
            t+=1
        elif customer == 50:
            if t != 0:
                t -= 1
                f += 1
            else:
                return 'NO'
        elif customer == 100:
            if f >= 1 and t >= 1:
                f -= 1
                t -= 1
                h += 1
            elif t >= 3:
                t -= 3
                h += 1
            else:
                return 'NO'
    return 'YES'

print(tickets([25, 25, 25, 25, 50, 100, 50]))