def fibo_rec(n):
    if n <= 1:
        return n
    return fibo_rec(n-1) + fibo_rec(n - 2)


def fibo(n):
    f = []
    f[0] = 0
    f[1] = 1

    for i in range(2, n):
        f[i] = f[i-1] + f[i-2]
    
    return f[n]

def memoized_fibo(n):
    f = []
    for i in range(0,n):
        f[i] = -1
    return lookup_fibo(f, n)


def lookup_fibo(f,n):
    if f[n] >= 0:
        return f[n]
    elif n <= 1:
        f[n] = n
    else:
        f[n] = lookup_fibo(f, n-1) + lookup_fibo(f, n-2)
    return f[n]




