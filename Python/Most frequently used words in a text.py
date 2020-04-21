def top_3_words(text):
    text = text.lower()
    unique_words = {}
    current_word = ''
    alphabet = [chr(i) for i in range(97, 123)]
    alphabet.append("'")
    for letter in text:
        if letter in alphabet:
            current_word += letter
        else:
            if len(current_word.replace("'", "")) != 0:
                unique_words[current_word] = unique_words.get(current_word, 0) + 1
            current_word = ''
    if len(current_word.replace("'", "")) != 0:
        unique_words[current_word] = unique_words.get(current_word, 0) + 1
    frequencies = [0,0,0]
    words = ['','','']
    for word, freq in unique_words.items():
        if freq > frequencies[0]:
            frequencies[0], frequencies[1], frequencies[2] = freq, frequencies[0], frequencies[1]
            words[0], words[1], words[2] = word, words[0], words[1]
        elif freq > frequencies[1]:
            frequencies[1], frequencies[2] = freq, frequencies[1]
            words[1], words[2] = word, words[1]
        elif freq > frequencies[2]:
            frequencies[2] = freq
            words[2] = word
    return [word for word in words if len(word) > 0]

print(top_3_words("e e e e ddd ddd ddd: ddd ddd aa aa aa, bb cc cc e e e"))