//내 풀이
function differenceSet(setA, setB){
  let difference = new Set(setA)
  setB.forEach(e=>{
    difference.delete(e)
  })
  return difference
}

function solution(numbers) {
    var answer = 0;
    numbers.sort()
    const a = [0, 1,2,3,4,5,6,7,8,9];
    let set1 = new Set(numbers);
    let set2 = new Set(a);
    const anss = differenceSet(set2, set1); 
    const ans = Array.from(anss);
    
    for (let i = 0; i < ans.length; i++) {
    answer += ans[i];
    }   
    return answer;
}

//간결 풀이 (더 효율)
function solution(numbers) {
    let cnt = 0;
    for(let i=0; i<10; i++){
        if(!(numbers.includes(i))) cnt+= i
    }
    return cnt

}