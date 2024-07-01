//
//  main.swift
//  Baekjoon
//
//  Created by Subeen on 7/1/24.
//

import Foundation

var bingoCount: Int = 0
var answer: Int = 0

var board: [[Int]] = [[Int]](repeating: [Int](repeating: 0, count: 5), count: 5)
var isChecked: [[Bool]] = [[Bool]](repeating: [Bool](repeating: false, count: 5), count: 5)

// 부른 숫자 O처리
func bingo(_ num: Int) {
    for i in 0..<board.count {
        for j in 0..<board[i].count {
            if board[i][j] == num {
                isChecked[i][j] = true
                return
            }
        }
    }
}

// 성공한 빙고가 몇 개인지 검사하는 메서드
func checkBingo() {
    bingoCount = 0
    var isBingo: Bool = true
    
    // 가로 행
    for i in 0..<isChecked.count {
        isBingo = true
        for j in 0..<isChecked[i].count {
            isBingo = isBingo && isChecked[i][j]
        }
        if (isBingo) {
            bingoCount += 1
        }
    }
    
    // 세로 열
    for i in 0..<isChecked.count {
        isBingo = true
        for j in 0..<isChecked[i].count {
            isBingo = isBingo && isChecked[j][i]
        }
        if (isBingo) { 
            bingoCount += 1
        }
    }
    
    // 오른쪽 대각선
    isBingo = true
    for i in 0..<5 {
        for j in 0..<5 where i + j == 4 {
            isBingo = isBingo && isChecked[i][j]
        }
    }
    if (isBingo) {
        bingoCount += 1
    }
    
    // 왼쪽 대각선
    isBingo = true
    for i in 0..<5 {
        for j in 0..<5 where i == j {
            isBingo = isBingo && isChecked[i][j]
        }
        
    }
    if (isBingo) {
        bingoCount += 1
    }
    
    // 기존의 대각선 체크 코드
//    if (isChecked[0][4] && isChecked[1][3] && isChecked[2][2] && isChecked[3][1] && isChecked[4][0]) { bingoCount += 1 }
//    if (isChecked[0][0] && isChecked[1][1] && isChecked[2][2] && isChecked[3][3] && isChecked[4][4]) { bingoCount += 1 }
}

func main() {

    var numList: [[Int]] = [[Int]](repeating: [Int](repeating: 0, count: 5), count: 5)
    
    // 빙고판 초기화
    for index in 0..<board.count {
        board[index] = readLine()!.components(separatedBy: " ").map {
            Int(String($0))!
        }
    }
    
    // 부른 숫자 배열 초기화
    for index in 0..<numList.count {
        numList[index] = readLine()!.components(separatedBy: " ").map {
            Int(String($0))!
        }
    }
    
    // 부른 숫자를 순회하면서 성공한 빙고의 개수가 3개를 넘어갔을 경우 break
    // 숫자를 부를 때마다 빙고여부를 확인
    for num in numList {
        if (bingoCount >= 3) { break };
        for n in num {
            answer += 1
            bingo(n)
            checkBingo()
            if (bingoCount >= 3) { break };
        }
    }
    
    print(answer)
}

main()
