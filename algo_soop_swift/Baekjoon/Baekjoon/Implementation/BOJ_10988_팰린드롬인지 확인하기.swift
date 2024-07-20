//
//  BOJ_10988_팰린드롬인지 확인하기.swift
//  Baekjoon
//
//  Created by Subeen on 7/19/24.
//

import Foundation

func main10988() {
    let line: String = readLine()!
    
    var check: Bool = true
    for i in 0...line.count/2 {
        let prefix = line[i]
        let subfix = line[line.count - 1 - i]

        if prefix != subfix { check = false }
    }
    
    print(check ? 1 : 0)
}

extension String {
    subscript(index: Int) -> Character {
        return self[String.Index(encodedOffset: index)]
    }
}

//main10988()
