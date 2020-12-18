def generate_hashtag(s):
    if len(s)==0 or s =='#':
        return False
    output = '#'+''.join(list(map(lambda x: x.capitalize(), s.split(" "))))
    return output if len(output) < 140 else False

