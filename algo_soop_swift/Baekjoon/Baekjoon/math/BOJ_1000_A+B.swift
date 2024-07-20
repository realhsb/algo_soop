//
//  BOJ_1000_A+B.swift
//  Baekjoon
//
//  Created by Subeen on 7/19/24.
//

import Foundation
 
func main1000() {
    let num: [Int] = readLine()!.components(separatedBy: " ").map {
        Int(String($0))!
    }
    
    print(num.first! + num.last!)
}

//main1000()
