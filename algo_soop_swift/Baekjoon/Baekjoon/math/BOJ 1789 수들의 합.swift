//
//  BOJ 1789 수들의 합.swift
//  Baekjoon
//
//  Created by Subeen on 7/20/24.
//

func main1789() {
    let N = Int(String(readLine()!))!
    
    var num: Int = 1
    var sum: Int = 0
    
    while(true) {
        if (N - sum - num) >= (num + 1) {
            sum += num
            num += 1
        } else {
            break
        }
    }
    
    print(num)
}

//main1789()
