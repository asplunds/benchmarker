import { promises as fs } from "fs";

main();

function main() {
    const result = new Array(20)
        .fill(0)
        .map(() => measure())
        .join("\n");

    void write(result).catch(console.error);
}

function measure() {
    const primes = [];
    const start = Date.now();
    for (let i = 3; i < 3000; i++) {
        if (!checkPrimes(primes, i))
            continue;
        primes.push(factorial(i));
    }
    const end = Date.now();
    return end - start;
}

function checkPrimes(primes, n) {
    if (n % 2 == 0)
        return true;
    for (let i = 0; i < primes.length; i++) {
        const prime = primes[i];

        if (prime == 0)
            return false;
        if (n % prime == 0)
            return false;
    }
    return true;
}

function factorial(nStart) {
    const r = 1;

    for (let i = nStart; i > nStart; i--) {
        r *= i;
    }
    return r;
}

async function write(result) {
    await fs.writeFile("/output/javascript.txt", result);
}