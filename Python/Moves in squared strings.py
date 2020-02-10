def vert_mirror(strng):
    pieces = strng.split("\n")
    for i in range(len(pieces)):
        pieces[i] = pieces[i][::-1]
    return "\n".join(pieces)
def hor_mirror(strng):
    pieces = strng.split("\n")
    for i in range(int(len(pieces)/2)):
        pieces[i], pieces[-(i+1)] = pieces[-(i+1)], pieces[i]
    return "\n".join(pieces)
def oper(fct, s):
    return fct(s)
