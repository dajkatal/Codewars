import re
def calc(expression):
    regex = '[0-9]+|[^a-zA-Z\d\s]'; formatted = simplify(re.findall(regex, expression)); val = solve(formatted); return float(val[1]) if val[0] == '+' else (float(''.join(val)) if val[0] == '-' else float(val[0]))
def solve(expression):
    char_index = 0
    while char_index < len(expression):
        if expression[char_index] == '(':
            closing_paren_index = 0; parenthesis = 1
            for is_parenthesis in range(char_index+1, len(expression)):
                if expression[is_parenthesis] == '(': parenthesis += 1
                elif expression[is_parenthesis] == ')':
                    parenthesis -= 1
                    if parenthesis == 0:
                        closing_paren_index = is_parenthesis; break
            simplified = solve(expression[char_index + 1:closing_paren_index])
            if isinstance(simplified, str): simplified = [simplified]
            expression = simplify(expression[:char_index] + simplified + expression[closing_paren_index+1:])
        char_index += 1
    char_index = 0
    while char_index < len(expression):
        if expression[char_index] == '*':
            if represents_int(expression[char_index-1]) and (represents_int(expression[char_index+1]) or expression[char_index+1] == '-' or expression[char_index+1] == '+'):
                multiplier = ''.join(expression[char_index + 1:char_index + 3]) if expression[char_index+1] == '-' else (expression[char_index + 2] if expression[char_index+1] == '+' else expression[char_index + 1]); operator_list = expression[char_index-1:char_index+1] + [multiplier]; expression = simplify(extract(update(expression, char_index - 1, char_index + 3 if expression[char_index+1] == '-' or expression[char_index+1] == '+' else char_index + 2, multiply(operator_list)))); char_index -= 1
        elif expression[char_index] == '/':
            if represents_int(expression[char_index-1]) and (represents_int(expression[char_index+1]) or expression[char_index+1] == '-' or expression[char_index+1] == '+'):
                divisor = ''.join(expression[char_index + 1:char_index + 3]) if expression[char_index+1] == '-' else (expression[char_index + 2] if expression[char_index+1] == '+' else expression[char_index + 1]); operator_list = expression[char_index - 1:char_index + 1] + [divisor]; expression = simplify(extract(update(expression, char_index - 1, char_index + 3 if expression[char_index+1] == '-' or expression[char_index+1] == '+' else char_index + 2, divide(operator_list)))); char_index -= 1
        char_index += 1
    expression = simplify(extract(expression)); char_index = 0
    while char_index < len(expression):
        if expression[char_index] == '+':
            if char_index - 1 < 0: char_index += 1; continue
            if represents_int(expression[char_index - 1]) and represents_int(expression[char_index + 1]):
                if char_index == 2 and expression[0] == '-': expression = simplify(extract(update(expression, char_index - 1, char_index + 2, subtract(expression[char_index - 1:char_index + 2])))); char_index -= 1; continue
                expression = simplify(extract(update(expression, char_index - 1, char_index + 2, add(expression[char_index - 1:char_index + 2])) if char_index - 1 >= 0 else update(expression, 0, char_index + 2, add(expression[char_index - 1:char_index + 2])))); char_index -= 1

        elif expression[char_index] == '-':
            if char_index - 1 < 0: char_index += 1; continue
            if represents_int(expression[char_index - 1]) and represents_int(expression[char_index + 1]):
                if char_index == 2 and expression[0] == '-': expression = simplify(extract(update(expression, char_index - 1, char_index + 2, add(expression[char_index - 1:char_index + 2])))); char_index -= 1; continue
                expression = simplify(extract(update(expression, char_index - 1, char_index + 2, subtract(expression[char_index - 1:char_index + 2])) if char_index - 1 >= 0 else update(expression, 0, char_index + 2, subtract(expression[char_index - 1:char_index + 2])))); char_index -= 1
        char_index += 1
    return simplify(extract(expression))
def update(original, start, end, val, compact = False):
    if compact: return original[:start] + [val] + original[end:]
    val = str(val)
    if val[0] == '-': val = [val[0], val[1:]]; return original[:start] + val + original[end:]
    return original[:start] + [val] + original[end:]
def add(expression):
    return float(expression[0]) + float(expression[2])
def subtract(expression):
    return float(expression[0]) - float(expression[2])
def multiply(expression):
    return float(expression[0]) * float(expression[2])
def divide(expression):
    return float(expression[0]) / float(expression[2])
def represents_int(s):
    try: float(s); return True
    except ValueError: return False
def simplify(expression):
    char_index = 0
    while char_index < len(expression):
        if (expression[char_index] == '+' or expression[char_index] == '-') and (expression[char_index+1] == '+' or expression[char_index+1] == '-'):
            start = char_index; positive = True if expression[char_index] == '+' else False
            while char_index + 1 < len(expression) and expression[char_index+1] == '+' or expression[char_index+1] == '-': positive = False if positive and expression[char_index + 1] == '-' else (True if not positive and expression[char_index + 1] == '-' else (False if not positive and expression[char_index + 1] == '+' else True)); char_index += 1
            expression = (expression[:start] + ['+'] + expression[char_index+1:] if positive else expression[:start] + ['-'] + expression[char_index+1:]) if expression[start-1] != '*' and expression[start-1] != '/' else (expression[:start] + expression[char_index+1:] if positive else expression[:start] + ['-'] + expression[char_index+1:]); char_index = start + 1
        char_index += 1
    return expression
def extract(expression):
    copy_better = []
    for char_index in range(len(expression)):
        if len(expression[char_index]) > 1 and expression[char_index][0] == '-': copy_better += [expression[char_index][0], expression[char_index][1:]]
        else:
            copy_better.append(expression[char_index])
    return copy_better

print(calc('-3 + -56 / -79 - -17 + -79 + 96 - -6 / -95'))
