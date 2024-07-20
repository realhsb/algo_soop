//
//  BOJ_9046_복호화.swift
//  Baekjoon
//
//  Created by Subeen on 7/19/24.
//

import Foundation

func main9046() {
    var alphaCounts: [Character : Int] = [:]
    let t: Int = Int(String(readLine()!))!
    
    for _ in 0..<t {
        alphaCounts = [:]
        let string = String(readLine()!)
        for c in string {
            if c == " " { continue }
            
            if let count = alphaCounts[c] {
                alphaCounts[c] = count + 1
            } else {
                alphaCounts[c] = 1
            }
        }
        
        let sortedDict = alphaCounts.sorted { $0.value > $1.value }
        
//        print(sortedDict)
        
        if sortedDict.count > 1 {
            let first = sortedDict.first
            let second = sortedDict[1]
            
            if first!.value == second.value {
                print("?")
            } else {
                print(first!.key)
            }
        } else {
            print(sortedDict.first!.key)
        }
    }
}

//extension String {
//    subscript(index: Int) -> Character {
//        return self[String.Index(encodedOffset: index)]
//    }
//}

//main9046()
