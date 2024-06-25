//  BOJ 150370
//  2023 KAKAO BLIND RECRUITMENT 개인정보 수집 유효기간
//  https://school.programmers.co.kr/learn/courses/30/lessons/150370
//  Programmers
//
//  Created by Subeen on 6/25/24.
//

import Foundation

var dict: [String : Int] = [:]                  // 타입별 만료기간 ex) [A : 5, B : 12]
var answer: [Int] = []                          // 정답 배열 (만료된 파일의 인덱스 추가)
var todayArr = [Int](repeating: 0, count: 3)    // 오늘 날짜를 담은 배열 ex [2022, 01, 10]

func calcExpiredDay(_ privacy: String)-> Bool {
    var result: Bool = false
    
    let typeArr = privacy.components(separatedBy: " ")
    let dateArr = typeArr[0].components(separatedBy: ".")
    
    
    if var expiredYear = Int(dateArr[0]), var expiredMonth = Int(dateArr[1]), let expiredDay = Int(dateArr[2]) {
        if let months = dict[typeArr[1]] { // 유효기간 (달 수)
            var y = (months + expiredMonth) / 12
            var m = (months + expiredMonth) % 12
            
            // 달이 0으로 나누어 떨어지면 12월임. ex) 7월 + 5개월 -> 12월
            if m == 0 {
                m = 12
                y -= 1
            }
            
            expiredMonth = m
            expiredYear += y
        }
        
//        print("today : \(todayArr[0]).\(todayArr[1]).\(todayArr[2]) | date : \(dict[typeArr[1]]) | before : \(dateArr) | expire : \(expiredYear).\(expiredMonth).\(expiredDay)")
        
        if todayArr[0] < expiredYear {
            result = true
        } else if todayArr[0] == expiredYear {
            if todayArr[1] < expiredMonth {
                result = true
            } else if todayArr[1] == expiredMonth {
                if todayArr[2] < expiredDay {
                    result = true
                }
            }
        }
    }
    
    return result
}

func solution(_ today:String, _ terms:[String], _ privacies:[String]) -> [Int] {
    
    // 약관 dictionary 저장
    for term in terms {
        let strArr = term.components(separatedBy: " ")
        if let num = Int(strArr[1]) {
            dict[strArr[0]] = num
        }
    }
    
    // 오늘 날짜 배열로 변환
    let todayStrArr = today.components(separatedBy: ".")
    if let year = Int(todayStrArr[0]), let month = Int(todayStrArr[1]), let day = Int(todayStrArr[2]) {
        todayArr[0] = year
        todayArr[1] = month
        todayArr[2] = day
        
        for (index, privacy) in privacies.enumerated() {
            if !calcExpiredDay(privacy) {
                answer.append((index + 1))
            }
        }
    
    }
    return answer
}

func main() {
//    var today = "2022.05.19"
//    var terms = ["A 6", "B 12", "C 3"]
//    var privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
//
//
//    solution(today, terms, privacies)
//
//    print(answer)
    
    var today = "2020.01.01"
    var terms = ["Z 3", "D 5"]
    var privacies = ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]
    
    solution(today, terms, privacies)
    
    print(answer)
}

main()
