def get_pins(observed):
    adjacent = {'1': '124', '2': '2135', '3': '326', '4': '4157', '5': '52468', '6': '6359', '7': '748', '8': '85790',
                '9': '986', '0': '08'}
    final = []
    observe = []
    tempAppend = ''
    finalOutput = []
    for integer in observed:
        final.append(adjacent[integer])
    for values in final:
        observe.append(list(values))

    def run(data):
        def run4two(data):
            iterKeep = 0
            for lst in data:
                while iterKeep < len(data):
                    for char in lst:
                        keepGoing = True
                        tempAppend = char
                        nextData = data.index(lst) + 1
                        iterData = nextData
                        if nextData == len(data):
                            nextData = 0
                            iterData = 0
                        while iterData < len(data):
                            for character in data[nextData]:
                                nextData = data.index(lst) + 2
                                if nextData == len(data):
                                    nextData = 0
                                elif nextData == len(data) + 1:
                                    nextData = 1
                                tempAppend += character
                                index = 0
                                finalOutput.append(tempAppend)
                                tempAppend = char
                                iterData += 1
                                index += 1
                    iterKeep += 1
            return finalOutput
        def run4more():
            negativeSomething = 2
            output = run4two(data[-2:])
            global currentOutput
            currentOutput = []
            global endOutput
            endOutput = []

            def runOnCall():
                global currentOutput
                global endOutput
                for value in data[:-negativeSomething][-1]:
                    for i in range(len(output)):
                        currentOutput.append(value + output[i])

                    endOutput += currentOutput[:]
                    currentOutput = []
                return endOutput

            runOnCall()
            while negativeSomething + 1 < len(observed):
                output = endOutput
                endOutput = []
                negativeSomething += 1
                runOnCall()
            return endOutput

        return set(run4two(data)) if len(data) == 2 else set(run4more())





    return list(adjacent[observed]) if len(observed) == 1 else run(observe)


print(get_pins('8584'))