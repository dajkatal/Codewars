def fizz_buzz_custom(string_one = 'Fizz', string_two = 'Buzz', num_one = 3, num_two = 5):
    i = num_one
    x = num_two
    array = [_ for _ in range(1, 101)]
    for _ in range(100):
        if array[_] % x == 0 and array[_] % i == 0:
            array[_] = f'{string_one}{string_two}'
        elif array[_] % x == 0:
            array[_] = f'{string_two}'
        elif array[_] % i == 0:
            array[_] = f'{string_one}'
    return array
