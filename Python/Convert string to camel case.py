def to_camel_case(text):
    if '-' in text:
        text = text.replace('-', ' ')
    if '_' in text and '-' not in text:
        text = text.replace('_', ' ')

    text = list(text)
    for char in text:
        if char == ' ':
            index = text.index(char)
            del (text[index])
            text[index] = text[index].upper()
        if char == '_':
            index = text.index(char)+1
            text[index] = text[index].lower()
    return ''.join(text)


print(to_camel_case('the_Stealth_warrior'))
