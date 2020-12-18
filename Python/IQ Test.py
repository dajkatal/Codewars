def iq_test(n):
    numbers = list(map(int, n.split(" ")))
    even = 0
    odd = 0
    last_even = 0
    last_odd = 0
    for i in range(len(numbers)):
        _ = numbers[i]
        if _%2:
            last_odd = i
            odd += 1
        else:
            last_even = i
            even += 1
    if even == 1:
        return last_even + 1
    return last_odd + 1

print(iq_test("5 3 2"))