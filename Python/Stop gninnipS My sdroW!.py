def spin_words(sentence):
    return ' '.join([val if len(val) < 5 else val[::-1] for val in sentence.split(" ")])