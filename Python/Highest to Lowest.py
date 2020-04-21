def high_and_low(numbers):
    return "{} {}".format(max(map(int, numbers.split(" "))), min(map(int, numbers.split(" "))))
