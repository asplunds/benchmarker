require 'time'


def main
    result = ""
    (0..20).each do |i|
        result = "#{result}#{measure}\n"
    end
    write(result)
end

def measure
    start = (Time.now.to_f * 1000).to_i;
    primes = []
    (3..3000).each do |i|
        next unless checkPrimes(primes, i)
        
        primes.push(factorial(i))
    end
    after = (Time.now.to_f * 1000).to_i - start;
    return after
end

def checkPrimes(primes, n)
    if n % 2 == 0
        return true
    end
    primes.size().times do |i|
        prime = primes[i]
        if prime == 0
            return false
        end
        if n % prime == 0
            return false
        end
    end
    return true
end

def factorial(nStart)
    r = 1

    (1..nStart).to_a.reverse().each do |i|
        r *= i;
    end
    return r
end

def write(content)
    File.write("/output/ruby.txt", content)
end

main