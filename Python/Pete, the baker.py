def cakes(recipe, available):
    minimum = 10e10
    for i in recipe.keys():
        try:
            val = available[i]//recipe[i]
            if val < minimum:
                minimum = val
        except:
            return 0
    return minimum
