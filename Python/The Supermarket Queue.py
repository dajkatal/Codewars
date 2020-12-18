def queue_time(customers, n):
    time = [0 for _ in range(n)]
    for customer in customers:
        least_time = [time[0],0]
        for _ in range(len(time)):
            if time[_] < least_time[0]:
                least_time = [time[_], _]
        time[least_time[1]] += customer
    return max(time)
