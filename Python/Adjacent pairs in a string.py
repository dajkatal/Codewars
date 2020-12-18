def count_adjacent_pairs(st):
    st = st.lower()
    s, f = '', ''
    words = st.split(" ")
    d = 0
    for val in words:
        if val ==f and val != s:
            d += 1
        s, f = f, val
    return d