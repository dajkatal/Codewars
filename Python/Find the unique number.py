def find_uniq(arr):
    num = arr[0]
    if len(arr) > 2:
        print(arr)
        for char in arr:
            if char != num:
                if arr.index(char) == 1:
                    return num
                else:
                    return char
    else:
        return arr[0]

