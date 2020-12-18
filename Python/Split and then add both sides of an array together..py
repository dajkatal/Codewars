import math
def split_and_add(numbers, n):
    for _ in range(n):
        midpoint = len(numbers)/2
        if midpoint != int(midpoint):
            midpoint = math.floor(midpoint)
        else:
            midpoint = int(midpoint)
        left = numbers[:midpoint]
        right = numbers[midpoint:]
        if len(right) > len(left):
            left.insert(0, 0)
        new = []
        for i in range(len(left)):
            new.append(left[i] + right[i])
        numbers = new

    return numbers

print(split_and_add([1, 2, 3, 4, 5], 3))