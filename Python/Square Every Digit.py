def square_digits(num):
    numbers = list(str(num))
    for i in range(len(numbers)):
        numbers[i] = str(int(numbers[i]) * int(numbers[i]))
    return int(''.join(numbers))

