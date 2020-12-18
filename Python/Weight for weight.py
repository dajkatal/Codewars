def order_weight(strng):
    weights = strng.split(" ")
    new_w = []
    for w in weights:
        sm = 0
        for c in w:
            sm+=int(c)
        new_w.append(sm)
    one, two = zip(*sorted(zip(new_w, weights)))
    return ' '.join(two)
print(order_weight("103 123 4444 99 2000"))