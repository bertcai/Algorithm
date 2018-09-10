function Fibonacci(n) {
    if (n === 0) {
        return 0;
    }
    if (n === 1) {
        return 1;
    }
    let fibMin = 0;
    let fibMax = 1;
    let fibN = 0;
    for (let i = 2; i <= n; i++) {
        fibN = fibMin + fibMax;
        fibMin = fibMax;
        fibMax = fibN;
    }
    return fibN;
    // write code here
}

// 递归算法见.java