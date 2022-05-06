const arr = {}
const arr_y = {}
var answer = [0,0];

let curr = -1
let curr_y = -1
function solution(v) {
    v.map((point) =>{
        if (arr[point[0]])
            arr[point[0]] += 1
        else
            arr[point[0]] = 1
        if (arr[point[0]] === 2)
            curr = point[0]
        
        if (arr_y[point[1]])
            arr_y[point[1]] += 1
        else
            arr_y[point[1]] = 1
        if (arr_y[point[1]] === 2)
            curr_y = point[1]
    })
    for (i = 0; i < 3; i++){
        if (v[i][0] != curr)
            answer[0] = (v[i][0])
        if (v[i][1] != curr_y)
            answer[1] =(v[i][1])
    }

    return answer;
}