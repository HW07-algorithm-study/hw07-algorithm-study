package 정하

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Scanner

//fun main(){
//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//
////    val arr = Array(n+1){ IntArray(n+1) } 1차 : array보다 arraylist가 메모리 효율이 좋음
//    val arr = ArrayList<ArrayList<Int>>() //
//    val arr2 = mutableSetOf<Int>()
//    var count = 0
    // 메모리 초과
//    for(i in 0 .. n){
//        for(j in 0 .. n){
//            arr[i][j] = i*j
//            arr2.add(i*j)
//        }
//    }
//    val k = sc.nextInt()
//    for(i in arr2.iterator()){
//        if(i <= k) count++
//    }
//    print(count)

//    val br = BufferedReader(InputStreamReader(System.`in`)) // 버퍼써서 메모리 효율 증가
//    val n = br.readLine().toInt()
//
//    val arr2 = mutableSetOf<Int>()
//    var count = 0
//
//    for (i in 0..n) { 어차피 B배열만 사용하니 바로 저장
//        for (j in 0..n) {
//            arr2.add(i * j)
//        }
//    }
//
//    val k = br.readLine().toInt()
//    for (i in arr2) {
//        if (i <= k) count++
//    }
//    br.close()        // 메모리 효율 높이려고 버퍼 중단
//    println(count)
    // 알고리즘 분류를 보니 이분 탐색
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt() // NxN 배열의 크기
    val K = br.readLine().toInt() // K번째 수

    var left: Long = 1 // 왼쪽 끝
    var right: Long = K.toLong() // 오른쪽 끝
    var answer: Long = 0 // K번째 수를 저장할 변수

    while (left <= right) {
        val mid = (left + right) / 2 // 중간 값을 계산하여
        var count: Long = 0 // 작거나 같은 수의 개수

        // 이분 탐색은 직접 코드를 짰는데
        // K번째 수를 찾으려면 결국 이중 for문 쓰게 돼서
        // 이 부분은 GPT의 힘을 빌림
        // NxN 배열에서 mid 이하의 숫자 count
        for (i in 1..N) {
            // 각 행 i에서 mid 이하의 수 count++
            // (mid / i)는 i번째 행에서 mid 이하의 수의 개수
            // N보다 클 수 없으므로 minOf(mid / i, N)로 제한
            count += minOf(mid / i, N.toLong())
        }
        // 예를 들어 mid = 20, i = 4이면 4행에서 20 이하의 숫자는 5개

        // count가 K보다 작으면 K번째 수는 mid보다 큰 수
        if (count < K) {
            left = mid + 1 // left를 mid + 1로 바꿔줌
        } else {
            // count가 K보다 크거나 같으면 K번째 수는 mid 이하
            answer = mid // mid를 잠정적인 답으로 설정
            right = mid - 1 // right -> mid - 1로
        }
    }
    println(answer)
}
