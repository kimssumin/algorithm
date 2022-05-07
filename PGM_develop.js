


function solution(progresses, speeds) {
    let answer = [0];
    let days = progresses.map((progress, index) => Math.ceil((100 - progress) / speeds[index]));
    let maxDay = days[0];

    for(let i = 0, j = 0; i< days.length; i++){
        if(days[i] <= maxDay) {
            answer[j] += 1;
        } else {
            maxDay = days[i];
            answer[++j] = 1;
        }
    }

    return answer;
}

//내 풀이 - 히든 테스트케이스가 통과가 안됨 -> Why?
function solution(progresses, speeds) {
    let cnt = 1
    var answer = [];
    const work = [];
    for (let i = 0; i < progresses.length ; i++ ){
        //work.push(Math.ceil((100 - progresses[i]) / speeds[i]))
        if ((100 - progresses[i]) % speeds[i] === 0){
            work.push((100 - progresses[i]) / speeds[i])
        }   
        else{
            work.push(parseInt((100 - progresses[i]) / speeds[i]) + 1)
        }
    }
    for (let k = 1; k < work.length ; k ++){
        if (work[k] <= work[k-1]){
            cnt += 1
            if (k === (work.length) - 1){
                answer.push(cnt)
            }
        }
        else{
            answer.push(cnt)
            cnt = 1
            if (k === (work.length) - 1){
                answer.push(cnt)
            }
        }
    }
    return answer;
}