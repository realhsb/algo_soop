//
//  PG_258712_가장 많이 받은 선물.swift
//  Programmers
//
//  Created by Subeen on 6/26/24.
//

func solution(_ friends:[String], _ gifts:[String]) -> Int {
    // "muzi": 0
    var friendInfo: [String:Int] = [:]
    for (index, friend) in friends.enumerated() {
        friendInfo[friend] = index  // [ "muzi" : 1, "frodo" : 2 ]
    }
    
    var giveGift: [[Int]] = Array(repeating: Array(repeating: 0, count: friends.count), count: friends.count)
    var giftScore: [Int] = Array(repeating: 0, count: friends.count)
    var nextGift: [Int] = Array(repeating: 0, count: friends.count)
    
    for gift in gifts {
        let senderReceiver: [String] = gift.components(separatedBy: " ")
        
        if let sender = senderReceiver.first, let receiver = senderReceiver.last {
            if let senderIndex = friendInfo[sender], let receiverIndex = friendInfo[receiver] {
                giveGift[senderIndex][receiverIndex] += 1
                
                giftScore[senderIndex] += 1
                giftScore[receiverIndex] -= 1
            }
        }
    }
    
    var result = 0
    
    for sender in 0..<friends.count {
        var nextMonthGift: Int = 0
        
        for receiver in 0..<friends.count where sender != receiver {
            if giveGift[sender][receiver] > giveGift[receiver][sender]  {
                nextMonthGift += 1
            } else if giveGift[sender][receiver] == giveGift[receiver][sender] && giftScore[sender] > giftScore[receiver] {
                nextMonthGift += 1
            }
        }
        result = max(result, nextMonthGift)
    }
    
    return result
}

//func main() {
//    print(solution(["muzi", "ryan", "frodo", "neo"], ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"])) // 2
//    print(solution(["joy", "brad", "alessandro", "conan", "david"], ["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"])) // 4
//    print(solution(["a", "b", "c"], ["a b", "b a", "c a", "a c", "a c", "c a"])) // 0
//}
//
//main()
