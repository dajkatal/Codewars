def score(dice):
    zeros = 0
    points = 0
    num = [0, 0, 0, 0, 0, 0]
    for char in dice:
        for i in range(1, 7):
            #print('char', char, 'i', i)
            if char == i:
                num[i-1] += 1
    position = 1
    while zeros < 6:
        print('zeros', zeros)
        for step in range(len(num)):
            #step = step - 1
            i = num[step]
            #print(position)
            print(num)
            if num[step] >= 3 and position == 1:
                points += 1000
                num[step] -= 3
            if num[step] >= 3 and position == 6:
                points += 600
                num[step] -= 3
            if num[step] >= 3 and position == 5:
                points += 500
                num[step] -= 3
            if num[step] >= 3 and position == 4:
                points += 400
                num[step] -= 3
            if num[step] >= 3 and position == 3:
                print('three!!!!')
                points += 300
                num[step] -= 3
            if num[step] >= 3 and position == 2:
                points += 200
                num[step] -= 3
            if num[step] >= 1:
                if position == 1:
                    points += 100
                    print('here', num[step])
                    num[step] -= 1
                    print(num[step])
                if position == 5:
                    points += 50
                    num[step] -= 1
            if num[step] == 0 and position == 1:
                print('one', num[step-1])
                zeros += 1
            if num[step] < 3 and position == 6:
                print('six')
                zeros += 1
            if num[step] == 0 and position == 5:
                print('five')
                zeros += 1
            if num[step] < 3 and position == 4:
                print('four')
                zeros += 1
            if num[step] < 3 and position == 3:
                print('three')
                zeros += 1
            if num[step] < 3 and position == 2:
                print('two')
                zeros += 1
            if position >= 6:
                print('pos', position)
                position = 0
                print('pos', position)
            position += 1
    print(num)
    return points


print(score([1, 5, 1, 3, 4]))
