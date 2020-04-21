import copy

def reduce_matrix(matrix_copy, row, col):
    matrix_copy = matrix_copy[:row] + matrix_copy[row+1:]
    for row_index in range(len(matrix_copy)):
        matrix_copy[row_index] = matrix_copy[row_index][:col] + matrix_copy[row_index][col+1:]
    return matrix_copy


def determinant(matrix):
    value = 0
    if len(matrix) == 1 and len(matrix[0]) == 1:
        return matrix[0][0]
    if len(matrix) == 2 and len(matrix[0]) == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    flipped = False
    for top_val_index in range(len(matrix[0])):

        reduced = reduce_matrix(copy.deepcopy(matrix), 0, top_val_index)
        current_val = matrix[0][top_val_index]
        current_val *= -1 if flipped else 1
        flipped = False if flipped else True
        current_val *= determinant(reduced)
        value += current_val
    return value

print(determinant([[2,5,3], [1,-2,-1], [1, 3, 4]]))