package 정하

import java.util.Scanner

var N = 0
var S = 0
lateinit var numbers: IntArray
var count = 0

fun main() {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    S = sc.nextInt()
    numbers = IntArray(N)
    for (i in 0 until N) {
        numbers[i] = sc.nextInt()
    }
    dfs(0, 0)
    // S가 0인 경우 공집합을 제외(아무 수도 선택하지 않는 경우)
    if (S == 0) count--
    println(count)
}

fun dfs(index: Int, sum: Int) {
    // 모든 요소를 탐색한 경우
    if (index == N) {
        // 부분수열의 합이 S와 같은지 확인
        if (sum == S) count++
        return
    }
    // 현재 요소를 포함하는 경우
    dfs(index + 1, sum + numbers[index])
    // 현재 요소를 포함하지 않는 경우
    dfs(index + 1, sum)
}