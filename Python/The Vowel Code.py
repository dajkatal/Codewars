e = {
    'a':1,
    'e':2,
    'i':3,
    'o':4,
    'u':5
}
d = {
    1:'a',
    2:'e',
    3:'i',
    4:'o',
    5:'u'
}

def encode(st):
    new = ''
    for val in st:
        if val.lower() in e.keys():
            new += str(e[val])
        else:
            new += val
    return new

def decode(st):
    new = ''
    for val in st:
        if val.isdigit():
            val = int(val)
        if val in d.keys():
            new += d[val]
        else:
            new += val
    return new