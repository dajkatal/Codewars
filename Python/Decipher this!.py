def decipher_this(string):
    words = string.split(" ")
    for _ in range(len(words)):
        number = ''
        index = 0
        for i in words[_]:
            if i.isdigit():
                index += 1
                number += i
            else:
                break
        if len(number) == len(words[_]):
            words[_] = chr(int(number))
            continue
        number = int(number)
        words[_] = words[_][index:]
        if len(words[_]) == 1:
            words[_] = chr(number) + words[_][0]
        elif len(words[_]) == 2:
            words[_] = chr(number) + words[_][1] + words[_][0]
        else:
            words[_] = chr(number) + words[_][-1] + words[_][1:-1] + words[_][0]
    return " ".join(words)
