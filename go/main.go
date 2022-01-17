package main

import (
	"log"
	"os"
	"strconv"
	"time"
)

func main() {
	var result = []string{}
	for i := 0; i < 20; i++ {
		result = append(result, strconv.FormatInt(measure(), 10))
	}
	write(result)
}

func measure() int64 {
	start := time.Now().UnixNano() / int64(time.Millisecond)
	primes := []int{}
	for i := 3; i < 3000; i++ {
		if !checkPrimes(primes, i) {
			continue
		}
		primes = append(primes, factorial(i))
	}
	end := time.Now().UnixNano() / int64(time.Millisecond)
	return end - start
}

func checkPrimes(primes []int, n int) bool {
	if n%2 == 0 {
		return true
	}
	for i := 0; i < len(primes); i++ {
		if primes[i] == 0 || n%primes[i] == 0 {
			return false
		}
	}
	return true
}
func factorial(nStart int) int {
	r := 1
	for i := nStart; i != 0; i-- {
		r *= i
	}

	return r
}

func write(result []string) {
	file, err := os.Create("/output/go.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	for _, line := range result {
		file.WriteString(line + "\n")
	}
}
