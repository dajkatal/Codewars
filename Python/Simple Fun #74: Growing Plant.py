def growing_plant(upSpeed, downSpeed, desiredHeight):
    height = 0
    day = 0
    while True:
        day += 1
        height += upSpeed
        if height >= desiredHeight:
            break
        height -= downSpeed
    return day

print(growing_plant(100, 10, 910))