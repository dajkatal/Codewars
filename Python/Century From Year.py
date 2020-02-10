def century(year):
    return 1+int('0' + repr(year)[:-2]) if int(repr(year)[-2:]) > 00 else int('0' + repr(year)[:-2])


