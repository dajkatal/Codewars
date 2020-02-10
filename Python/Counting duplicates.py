def duplicate_count(text):
    duplicates = 0
    dupes = []
    text = list(text.lower())
    testingText = text[:]
    for char in text:
        testingText = text[:]
        del(testingText[testingText.index(char)])
        for i in testingText:
            if char == i:
                duplicates += 1
        if duplicates >= 1 and char not in dupes:
            dupes.append(char)
        duplicates = 0
    return dupes.__len__()



