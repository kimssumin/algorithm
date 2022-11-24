function solution(k, dungeons) {
  const answer = [];
  let visited = Array(dungeons.length).fill(false);

  function dfs(count, k) {
    answer.push(count);

    dungeons.forEach((val, idx) => {
      if (k >= val[0] && !visited[idx]) {
        visited[idx] = 1;
        dfs(count + 1, k - val[1]);
        visited[idx] = 0;
      }
    });
  }

  dfs(0, k);

  return Math.max(...answer);
}
