using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Threading.Tasks;

namespace Benchmark
{
    class Program
    {
        private static List<int> primes = new List<int>();
        
        private static void Main(string[] args)
        {
            var result = "";
            for (var i = 0; i < 20; i++) {
                result += measure() + "\n";
            }
            write(result);
        }

        private static long measure() {
            long start = DateTimeOffset.Now.ToUnixTimeMilliseconds();            

            for (int i = 3; i < 3000; i++) {
                if (!checkPrimes(primes, i))
                    continue;

                primes.Add(factorial(i));
            }
            long end = DateTimeOffset.Now.ToUnixTimeMilliseconds();            
            return end - start;
        }

        private static bool checkPrimes(List<int> primes, int n) {
            if (n % 2 == 0)
                return true;

            for (var i = 0; i < primes.Count; i++) {
                var prime = primes.ElementAt(i);
                if (prime == 0)
                    return false;
                if (n % prime == 0)
                    return false;
            }
            return true;
        }

        private static int factorial(int nStart) {
            var r = 1;

            for (var i = nStart; i > 0; i--) {
                r *= i;
            }
            return r;
        }

        private static async Task write(string result) {
            //await File.WriteAllTextAsync("/output/csharp.txt", /u);
            using (StreamWriter writer = new StreamWriter("/output/csharp.txt"))
            {
                writer.Write(result);
            }
        }
    }
}