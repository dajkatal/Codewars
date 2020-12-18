def encrypt_this(text):
    if len(text) == 0:
        return text
    words = text.split(" ")
    for _ in range(len(words)):
        if len(words[_]) == 1:
            words[_] = str(ord(words[_][0]))
        elif len(words[_]) == 2:
            words[_] = str(ord(words[_][0])) + words[_][1]
        elif len(words[_]) == 3:
            words[_] = str(ord(words[_][0])) + words[_][2] + words[_][1]
        else:
            words[_] = str(ord(words[_][0])) + words[_][-1] + words[_][2:-1] + words[_][1]
    return " ".join(words)
