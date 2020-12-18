def namelist(names):
    if len(names) == 1:
        return names[0]['name']
    output = ''
    for _ in range(len(names)):
        name = names[_]['name']
        if _ == len(names)-1:
            output += f' & {name}'
        else:
            output += f', {name}'
    return output[2:]