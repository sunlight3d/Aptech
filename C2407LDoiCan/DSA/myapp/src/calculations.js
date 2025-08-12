function binarySearch(arrayList, data) {
    let left = 0;
    let right = arrayList.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        if (arrayList[mid] === data) {
            return mid;
        } else if (arrayList[mid] < data) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; // Không tìm thấy
}
function linearSearch(arrayList, data) {
    for(let i =0; i < arrayList.length; i++) {
        if(data == arrayList[i]) {
            return i;
        }
    }
    return -1
}
export {binarySearch, linearSearch}