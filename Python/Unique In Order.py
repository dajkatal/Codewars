def unique_in_order(iterable):
    if len(iterable) == 0:
        return []
    final_list = [iterable[0]]
    for val in list(iterable[1:]):
        if final_list[-1] == val:
            continue
        else:
            final_list.append(val)
    return final_list