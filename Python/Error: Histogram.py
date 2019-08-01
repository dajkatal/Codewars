def hist(s):
    finalOutput = ''
    totalErrors = {'u': 0,
                   'w': 0,
                   'x': 0,
                   'z': 0}
    error = ['u', 'w', 'x', 'z']
    for char in s:

        for i in error:
            if char == i:
                totalErrors[i] += 1

    for i in error:
        if totalErrors[i] == 0:
            del (totalErrors[i])

    for i in totalErrors:
        if len(str(totalErrors[i])) == 1:
            spaceNum = '     '
        else:
            spaceNum = '    '
        val = totalErrors.get(i)
        finalOutput += str(i) + '  ' + str(val) + spaceNum + ('*' * val)
        if i != list(totalErrors.keys())[-1]:
            finalOutput += '\n'
    return finalOutput

print(hist('lgksjlgjoowuvdjlgjuyogeobbaurfcewngjsypugwootxxhzslehgkengowthgonrethgoWGKHEGONSOFYOWGNSRUOFHVKHOHGE9'))