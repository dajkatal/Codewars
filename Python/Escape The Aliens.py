import random

def valid(last_move, current_move):
    last_col, last_row = last_move
    cur_col, cur_row = current_move
    if not (last_row == cur_row or last_col == cur_col or last_row - last_col == cur_row - cur_col or last_row + last_col == cur_row + cur_col):
        return True
    return False

def escape(R, C):
    flipped = False
    final_moves = [[1,1]]
    moves = [[0, 0]]
    if C > R:
        R, C = C, R
        flipped = True
    if ((R <= 3) and (C <= 3)) or (R == 4 and C == 2):
        return []
    grid = [[-1 for x in range(R)] for i in range(C)]
    grid[0][0] = True
    attempt = 0
    col_rand = random.randrange(C)
    row_rand = random.randrange(R)

    output = valid(moves[-1], [col_rand, row_rand])
    while len(moves) < R * C:
        if output and grid[col_rand][row_rand] is -1:
            moves.append([col_rand, row_rand])
            final_moves.append([col_rand+1, row_rand+1] if flipped else [row_rand+1, col_rand+1])
            grid[col_rand][row_rand] = True
            attempt = 0
        else:
            attempt += 1
        if attempt >= R * C * 100:
            grid = [[-1 for x in range(R)] for i in range(C)]
            grid[0][0] = True
            moves = [[0, 0]]
            final_moves = [[1,1]]
            attempt = 0
        col_rand = random.randrange(C)
        row_rand = random.randrange(R)
        output = valid(moves[-1], [col_rand, row_rand])

    return final_moves

def valid(last_move, current_move):
    last_col, last_row = last_move
    cur_col, cur_row = current_move
    if not (last_row == cur_row or last_col == cur_col or last_row - last_col == cur_row - cur_col or last_row + last_col == cur_row + cur_col):
        return True
    return False

def validate(list, R, C):
    if list == [] and R <= 3 and C <= 3:
        return [True]
    grid = [[-1 for x in range(R)] for i in range(C)]
    visited = 0
    for val_index in range(len(list)):
        current_move = list[val_index]
        last_move = list[val_index - 1]
        valid_move = valid(last_move, current_move) if val_index > 0 else True
        r, c = current_move
        r,c = r-1,c-1
        if grid[c][r] == -1:
            if valid_move:
                grid[c][r] = 0
                visited += 1
            else:
                print(last_move, current_move)
                return [False, "Please make valid moves only!"]
        else:
            return [False, "You can not visit the same cell twice!"]

    if visited == R*C:
        return [True]
    else:
        return [False, "You have not visited all cells!"]

def generate_random():
    return [random.randint(2,50), random.randint(2,50)]

print(escape(3, 3))
print(validate(escape(3,3), 3, 3))