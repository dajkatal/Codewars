def find_missing_number(numbers):
    if len(numbers) == 0:
        return 0
    n = max(numbers)
    a = (n)*(n+1)//2
    t = sum(numbers)
    return a-t if a-t != 0 else max(numbers) + 1