//
//  BOJ_11022_A+B-8.swift
//  Baekjoon
//
//  Created by Subeen on 7/19/24.
//

import Foundation

func main11022() {
    let t: Int = Int(String(readLine()!))!
    var answer: String = ""
    for i in 1...t {
        let line = readLine()!.components(separatedBy: " ").map {
            Int(String($0))!
        }
        
        let a: Int = line.first!
        let b: Int = line.last!
        let c: Int = a + b
//        answer.append("Case #\(i): \(a) + \(b) = \(c)\n")
        print("Case #\(i): \(a) + \(b) = \(c)")
    }
//    print(answer)
}

//main11022()
