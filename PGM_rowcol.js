function solution(sizes) {
    const newsizes = sizes.map(size => {
        if (size[0] < size[1]){
            return ([size[1], size[0]])
        }
        else{
            return size
        }
    })
    let row = 0;
    let col = 0;
    newsizes.forEach(n => {
        row = Math.max(row, n[0])
        col = Math.max(col, n[1])
    })
    
    return row * col
}