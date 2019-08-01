def count_smileys(arr):
    correct = 0

    def repeated(charac, end):
        if charac[0] == ':' or charac[0] == ';':
            if charac[end] == ')' or charac[end] == 'D':
                return 1
        return 0

    for char in arr:
        if len(char) == 3:
            if char[1] == '-' or char[1] == '~':
                correct += repeated(char, 2)
        if len(char) == 2:
            correct += repeated(char, 1)

    return correct


print(count_smileys([':D', ':~)', ';~D', ':)', ':>)']))

