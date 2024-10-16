function bai1(...someArrays) {
    let minLength = Math.min.apply(Math, (someArrays.map(element => element.length)))
    let output = []
    for(let i = 0; i < minLength; i++){
        let arrayTemp = []
        for(const eachArray of someArrays) {
            arrayTemp.push(eachArray[i])
        } 
        output.push(arrayTemp)
    }
    debugger
    return output
}
alert(bai1([1, 2], [5, 6, 7]))
alert(bai1([1, 2], [3, 4, 5], [6, 7, 8, 9]))
alert(bai1([1, 2], [3, 4], [5, 6, 7], [8, 9]))