def alphabet_position(text):
    text = text.lower(); alphabet = {chr(i): i for i in range(97, 123)}; stng = ''
    for letter in text:
        if alphabet.get(letter, False):
            stng += ' {}'.format(alphabet[letter]-96)
    return stng[1:]
