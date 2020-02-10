def decodeMorse(morse_code):
    # ToDo: Accept dots, dashes and spaces, return human-readable message
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
    print(morseList)
    for morseLetter in morseList:
        try:
            print(morse.index(morseLetter))
            output += alphabet[morse.index(morseLetter)]
        except:
            output += " "
    return output.replace("  ", " ").strip()
