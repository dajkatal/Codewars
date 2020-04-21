def find_outlier(integers):
    parity = [integer % 2 for integer in integers]
    return integers[parity.index(0)] if sum(parity) > 1 else integers[parity.index(1)]