def pick_peaks(arr):
    output = {'pos':[], 'peaks':[]}
    i = 1
    while i < len(arr)-1:
        prev = arr[i-1]
        starting_i = i
        curr = arr[i]
        try:
            while arr[i] == arr[i + 1]:
                i += 1
        except:
            return output
        next = arr[i+1]
        if curr > prev and curr > next:
            output['pos'].append(starting_i)
            output['peaks'].append(curr)
        i+=1
    return output
