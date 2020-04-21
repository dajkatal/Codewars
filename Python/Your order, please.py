def order(sentence):
    dct = {}
    for word in sentence.split(" "):
        num = 0
        for char in word:
            if char.isnumeric():
                num = char
                break
        dct[num] = word
    strng = ''
    for num in sorted(list(dct.keys())):
        strng += ' {}'.format(dct[num])
    return strng[1:]