def duplicate_encode(word):
    word = word.lower()
    frequency = {}
    final_strn = ''
    for letter in word:
        if frequency.get(letter, False):
            frequency[letter] += 1
        else:
            frequency[letter] = 1
    for letter in word:
        if frequency[letter] > 1:
            final_strn += ')'
        else:
            final_strn += '('
    return final_strn