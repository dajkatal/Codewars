def disemvowel(s):
    return (lambda re : re.sub("[aeiouAEIOU]", "", s))(__import__('re'))

print(disemvowel('haelou'))
