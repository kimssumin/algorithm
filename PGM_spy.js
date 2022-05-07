const cloth = {};
function solution(clothes) {
    var answer = 1
    clothes.map((one) => {
        let kind = one[1]
        let thing = one[0]
        if (cloth[kind]){
            cloth[kind] += 1
        }
        else {
            cloth[kind] = 1
        }
    })
    
    for (let key in cloth){
        answer *= (cloth[key] + 1)
        //swer *= cloth[key]
    }
    return answer - 1;
}