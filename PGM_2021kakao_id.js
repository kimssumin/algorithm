function solution(new_id) {    
    const answer = new_id
        .toLowerCase() //소문자 치환
        .replace(/[^\w-_.]/g, '') //문자, -, _, . 제외 모두 없애기
        .replace(/\.{2,}/g, '.') //점이 2개이상인것 모두 점 하나로
        .replace(/^\.|\.$/g, '') //처음이 점이거나 | 점으로 끝나는 모든 것을 제거
        .replace(/^$/, 'a') //시작(^),그리고 바로 끝($) 은 a를 대입
        .slice(0, 15).replace(/\.$/, ''); //15자로 자르고 점으로 끝나는 문자면 제거
    const len = answer.length; //현재 길이
    return len > 2 ? answer : answer + answer.charAt(len - 1).repeat(3 - len);
    //현재 길이가 3이상이면 answer 를 return, 아니면 문자열 길이로 가장 끝 요소에 접근하여 그걸 반복해서 return
}

//정규표현식
