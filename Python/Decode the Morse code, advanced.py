def decodeBits(bits):
    bits = str(bits)
    firstZeros = 0
    lastZeros = 0
    for i in range(len(bits)):
        if bits[i] == "0":
            firstZeros += 1
        else:
            break
    for i in reversed(range(0, len(bits))):
        if bits[i] == "0":
            lastZeros += 1
        else:
            break
    bits = bits[firstZeros:len(bits)-lastZeros]
    binary = ["1", "111", "0", "000", "0000000", ""]
    morse = [".", "-", "", " ", "   ", ""]
    expanded = 1
    testInARow = 0
    allExpandedPossibilities = []

    for i in range(len(bits)):
        if bits[i] == "1":
            testInARow += 1
        else:
            break

    expanded = testInARow
    while expanded > 0:
        try:
            expandedDiv = testInARow / float(expanded)
            if expandedDiv == int(expandedDiv):
                test = binary.index("1" * int(testInARow / expanded))
                allExpandedPossibilities.append(expanded)
                expanded -= 1

            else:
                expanded -= 1
        except:
            expanded -= 1

    for i in range(len(allExpandedPossibilities)):
        try:
            expanded = allExpandedPossibilities[i]
            output = ""
            lastIndexOne = 0
            lastIndexZero = 0
            while True:
                onesInARow = 0
                zerosInARow = 0
                for i in range(lastIndexOne, len(bits)):
                    lastIndexZero = i
                    if bits[i] == "0":
                        zerosInARow += 1
                    else:
                        break
                zerosDiv = zerosInARow / float(expanded)
                if zerosDiv == int(zerosDiv):
                    output += morse[binary.index("0" * (zerosInARow / expanded))]
                else:
                    raise Exception
                for i in range(lastIndexZero, len(bits)):
                    lastIndexOne = i
                    if bits[i] == "1":
                        onesInARow += 1
                    else:
                        break
                onesDiv = onesInARow / float(expanded)
                if onesDiv == int(onesDiv):
                    output += morse[binary.index("1" * (onesInARow / expanded))]
                else:
                    raise Exception
                if lastIndexOne >= len(bits)-1 or lastIndexZero >= len(bits)-1:
                    break

            return output
        except:
            pass


def decodeMorse(morse_code):
    morse = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
             "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
             "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
             "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
             ".-.-.-", "--..--", "..--..", "...---...", "-.-.--"]
    alphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
                "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", "?", "SOS", "!"]

    morseList = morse_code.split(" ")
    output = ""
    for morseLetter in morseList:
        try:
            output += alphabet[morse.index(morseLetter)]
        except:
            output += " "
    return output.replace("  ", " ").strip()
