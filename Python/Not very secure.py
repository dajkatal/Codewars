import re
def alphanumeric(password):
    if len(password):
        if len(password) == len(re.findall('[a-zA-Z]', password)) + len(re.findall('[0-9]', password)):
            return True
    return False
