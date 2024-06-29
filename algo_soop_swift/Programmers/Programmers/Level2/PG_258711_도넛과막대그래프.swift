//
//  PG_258711_도넛과막대그래프.swift
//  Programmers
//
//  Created by Subeen on 6/29/24.
//

/*
 그래프 개수
 1) out == 0 -> 막대 그래프 ... 막대 끝 노드는 [out: 0]이기 때문
 2) out == 2
    2-1) in == 0 -> 시작 노드 ... 시작 노드만 out이 2개 이상 존재하고 in이 0임.
    2-2) in > 0 -> 8자 그래프 ... 8자 그래프 중심 노드는 [in: 2, out: 2].
 3) out > 2 -> 시작 노드 ... 시작 노드만이 out이 2개 초과할 수 있음.
 4) 그 외는 무시
 
 도넛 그래프 개수 = 시작 노드의 나간 간선(outEdge) - 막대그래프 개수 - 8자 그래프 개수
 */

struct Node {
    var inEdge: Int     // 들어온 간선 개수
    var outEdge: Int    // 나간 간선 개수
    
    init(inEdge: Int, outEdge: Int) {
        self.inEdge = inEdge
        self.outEdge = outEdge
    }
    
    mutating func addIn() {
        inEdge += 1
    }
    
    mutating func addOut() {
        outEdge += 1
    }
    
    func getIn() -> Int {
        return self.inEdge
    }
    
    func getOut() -> Int {
        return self.outEdge
    }
}

func solution(_ edges:[[Int]]) -> [Int] {
    
    var answer: [Int] = Array(repeating: 0, count: 4)
    var nodes: [Node?] = Array(repeating: nil, count: 1000001)
    var startNodeNum: Int = 0
    
    
    for edge in edges {
        // 시작 노드, 끝 노드 -> 시작 노드(outEdgeIndex)에서 간선이 나가서(outEdge) 끝 노드(inEdgeIndex)로 간선이 들어옴(inEdge)
        // [outEdgeIndex, inEdgeIndex]
        guard let outEdgeIndex = edge.first, let inEdgeIndex = edge.last else { continue }
        
        // 노드가 없으면 초기화를 하고, 있으면 값 증가
        if nodes[inEdgeIndex] == nil {
            nodes[inEdgeIndex] = .init(inEdge: 1, outEdge: 0)
        } else if nodes[inEdgeIndex] != nil {
            nodes[inEdgeIndex]?.addIn()
        }
        
        if nodes[outEdgeIndex] == nil {
            nodes[outEdgeIndex] = .init(inEdge: 0, outEdge: 1)
        } else if nodes[outEdgeIndex] != nil {
            nodes[outEdgeIndex]?.addOut()
        }
    }
    
    // 노드 순회
    for (index, node) in nodes.enumerated() {
        if let n = node {   // 노드가 존재할 경우
            switch n.getOut() {
            case 0: // 막대
                answer[2] += 1
            case 2:
                if n.inEdge == 0 {
                    startNodeNum = index
                }
                else if n.inEdge > 0 { answer[3] += 1 } // 8자
            case let out where out > 2:
                startNodeNum = index
            default:
                continue
            }
        }
    }
    
    answer[0] = startNodeNum
    
    if let n = nodes[startNodeNum] {
        answer[1] = n.outEdge - answer[2] - answer[3]
    }
    
    
    return answer
}

//func main() {
//    print(solution([[2, 3], [4, 3], [1, 1], [2, 1]]))
//}
//
//main()
