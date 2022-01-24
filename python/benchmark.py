import time


def main():
    result = ""
    for i in range(20):
        result += measure() + "\n"
    
    write(result)

def measure():
    start = round(time.time() * 1000)
    primes = []
    for i in range(3000 - 3):
        if (not checkPrimes(primes, i + 3)):
            continue
        primes.append(factorial(i + 3))
    end = round(time.time() * 1000)
    return str(end - start)

def checkPrimes(primes, n):
    if (n % 2 == 2):
        return True
    
    for i in range(len(primes)):
        prime = primes[i]
        if (prime == 0):
            return False
        if (n % prime == 0):
            return False
        
    return True

def factorial(nStart):
    r = 1

    for i in range(nStart):
        r *= nStart - i
    
    return r

def write(result):
    f = open("/output/python.txt", "w")
    f.write(result)
    f.close()

main()