
def find_missing_letter(chars):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    oldChar = chars[0]
    for char in chars:
        if char == char.upper():
            notation = 'upper'
        else:
            notation = 'lower'
        if alphabet[alphabet.index(oldChar.lower())+1] != char.lower() and char != oldChar:
            val = alphabet[alphabet.index(oldChar.lower())+1]
            if notation == 'upper':
                return val.upper()
            else:
                return val.lower()
        oldChar = char



