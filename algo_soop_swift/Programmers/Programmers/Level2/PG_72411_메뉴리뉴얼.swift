//
//  PG_72411_메뉴리뉴얼.swift
//  Programmers
//
//  Created by Subeen on 6/29/24.
//

import Foundation

var combOrder: [String:Int] = [:]

func sort(_ orders: [String])-> [[Character]] {
    var sortedOrders: [[Character]] = [[]]
    
    for order in orders {
        sortedOrders.append(Array(order).sorted())
    }
    return sortedOrders
}

func combination(_ orders: [Character], _ combString: inout String, _ stringSize: Int, _ index: Int) {
    
    if (combString.count == stringSize) {
        if let count = combOrder[combString] {
            combOrder[combString] = count + 1
        } else {
            combOrder[combString] = 1
        }
    }
    
    for i in index ..< orders.count {
        combString.append(orders[i])
        combination(orders, &combString, stringSize, i + 1)
        combString.removeLast()
    }
    
}

func solution(_ orders:[String], _ course:[Int]) -> [String] {
    combOrder = [:]
    var answer: Set<String> = []
    let sortedOrders: [[Character]] = sort(orders)
    for order in sortedOrders {
        for cour in course {
            if order.count >= cour {
                var combString: String = ""
                combination(order, &combString, cour, 0)
            }
        }
    }
    
    for num in course {
        
        let numCombs: [String: Int] = combOrder
            .filter({ $0.key.count == num }) // 메뉴 조합의 길이가 num인 경우
            .filter({ $0.value >= 2 })
        
        let maxValue = numCombs.values.max()
        print(numCombs)
        
        numCombs.keys.filter({ numCombs[$0] == maxValue }).forEach {
            answer.insert($0)
        }
    }
    
//    print(Array(answer.sorted()))
    
    return Array(answer.sorted())
}


//func main() {
//    print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]))     // ["AC", "ACDE", "BCFG", "CDE"]
//    print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))   // ["ACD", "AD", "ADE", "CD", "XYZ"]
//    print(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]))                               // ["WX", "XY"]
//}
//
//main()
