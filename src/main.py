import time
iteracoes = 0
instrucoes = 0


def fibo_rec(n):
    global instrucoes, iteracoes
    iteracoes +=1
    if n <= 1:
        instrucoes += 2
        return n
    instrucoes +=1
    return fibo_rec(n-1) + fibo_rec(n - 2)


def fibo(n):
    global iteracoes, instrucoes
    iteracoes +=1
    f = []
    instrucoes +=1
    f.append(0)
    instrucoes +=1
    f.append(1)
    instrucoes +=1

    for i in range(2, n+1):
        f.append(f[i-1] + f[i-2])
        iteracoes +=1
        instrucoes +=1
    instrucoes +=1

    return f.pop()

def memoized_fibo(n):
    global iteracoes, instrucoes
    iteracoes += 1
    f = []
    instrucoes +=1
    for i in range(0,n+1):
        f.append(-1)
        iteracoes +=1
    instrucoes +=1
    return lookup_fibo(f, n)


def lookup_fibo(f,n):
    global iteracoes, instrucoes
    iteracoes +=1
    if f[n] >= 0:
        instrucoes +=1
        return f[n]
    elif n <= 1:
        instrucoes +=1
        f[n] = n
    else:
        instrucoes +=1 
        f[n] = lookup_fibo(f, n-1) + lookup_fibo(f, n-2)
    instrucoes +=1     
    return f[n]





print(f"{'n':>5} | {'Resultado':>9} | {'Iterações':>10} | {'Instruções':>12} | {'Tempo (s)':>10}")
print("-" * 60)


valores = [4,8,16,32, 128, 1000, 10000]

for n in valores:
    iteracoes = 0
    instrucoes = 0

    inicio = time.perf_counter_ns()
    resultado = memoized_fibo(n)
    fim = time.perf_counter_ns()

    tempo = fim - inicio

    print(f"{n:>5} | {resultado:>9} | {iteracoes:>10} | {instrucoes:>12} | {tempo*1e-9:>10.12f}")

