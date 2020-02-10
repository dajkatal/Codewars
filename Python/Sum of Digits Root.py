def digital_root(n):
    n = str(n)
    output = 0
    for number in n:
        output += int(number)
    if output < 10:
        return output
    else:
        return digital_root(output)


