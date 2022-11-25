function compare(answers, n) {
  a = answers.length;
  let result = [0, 0, 0];
  for (let i = 0; i < n.length; i++) {
    result[i] = answers.filter((element, index) => element === n[i][index % n[i].length]).length;
  }
  return result;
}

function solution(answers) {
  const answer = [];
  const n1 = [1, 2, 3, 4, 5];
  const n2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const n3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  const n = [n1, n2, n3];
  const ans = compare(answers, n);
  const max = Math.max(...ans);

  if (ans[0] === max) {
    answer.push(1);
  }
  if (ans[1] === max) {
    answer.push(2);
  }
  if (ans[2] === max) {
    answer.push(3);
  }
  return answer;
}
