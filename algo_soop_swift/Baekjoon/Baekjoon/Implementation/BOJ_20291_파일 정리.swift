//
//  BOJ_20291_파일 정리.swift
//  Baekjoon
//
//  Created by Subeen on 7/13/24.
//

/*
# 요구사항 정리
바탕화면에 존재하는 확장자의 종류와 각 확장자별 개수를 구한다. 확장자는 사전순(오름차순)으로 정렬한다.

# 입력값
파일 개수 N ( 1 <= N <= 50000 )
N개의 줄에 파일명.확장자 ( 3 <= 파일명 <= 50000 )

# 출력값
출력값 개수
확장자명 기준 오름차순 정렬

# 구현
## 요구사항
1. 각 입력값을 순회하여 확장자 : 개수 딕셔너리에 값을 추가한다.
   a. 확장자가 없다면, 새롭게 key-value를 증가한다. ( [확장자 : 0] )
   b. 확장자가 있다면, 기존 value에 1을 증가한다.
2. 파일 탐색을 끝냈다면, key를 기준으로 오름차순 정렬한다.
3. 정렬된 딕셔너리를 출력한다. (확장자명 개수)

## 데이터 구조
1. 딕셔너리
   [ 파일명 : 개수 ]
   왜? 파일 구조체를 만드려고 했으나, 기존의 파일명을 찾기 위해서는 파일 전체 배열을 순회해야 하기 때문이다.
   딕셔너리를 사용해서 파일명에 바로 접근한다.
2.

## 함수
1. 파일 탐색
   입력값으로 주어진 N개의 파일명을 순회한다.
   각 확장자명은 입력값을 .(컴마)를 기준으로 문자열을 쪼개어 마지막에 있는 문자열에 존재한다.
   확장자 개수 딕셔너리에 파일명이 존재하면, 파일명의 value에 1을 증가하고 없다면 새로운 key 추가한다.
2. 확장자 정렬
   확장자가 여러 개 존재한다면, 확장자명을 오름차순 정렬한다.
3. 확장자 출력
*/


import Foundation

var fileCount = 0
var extenDict: [String : Int] = [:]


func exploreFiles() {
   for _ in 0..<fileCount {
       let exten: String = readLine()!.components(separatedBy: ".").last! // 확장자명 분리
       print(exten)
       
//        let condition: ((String, Int)) -> Bool = {
//            $0.0.contains("exten")
//        }
       guard let value = extenDict[exten] else {
           extenDict[exten] = 1
           continue    // 반복문 안에 있으므로, continue를 하면 하단 과정 넘어가므로 처음 확장자명을 추가할 떄 value를 1로 설정
       }
       
       extenDict[exten] = value + 1
       
//        if let value = extenDict[exten] {    // 이때 key가 존재하지 않다면 딕셔너리에 추가가 되는지...
//            extenDict[exten] = value + 1
//        }
       
//        if extenDic.contains(where: condition) {
//            let value = extenDic[exten]!
//            extenDic[exten] = value + 1
//        }
       
       
   }
}

func main20291() {
   fileCount = Int(String(readLine()!))!
   
   exploreFiles()
   
   print(extenDict)
   let sortedDict = extenDict.sorted { $0.key < $1.key }
   
   for dict in sortedDict {
       print("\(dict.key) \(dict.value)")
   }
}

//main20291()
