def get_score(arr) -> int:
    finalScore = 0
    toNextLevel = 10
    level = 0
    for score in arr:
        if toNextLevel <= 0:
            level += 1
            toNextLevel += 10
        toNextLevel -= score
        if score == 1:
            finalScore += 40 * (level+1)
        elif score == 2:
            finalScore += 100 * (level+1)
        elif score == 3:
            finalScore += 300 * (level+1)
        elif score == 4:
            finalScore += 1200 * (level+1)
    return finalScore




