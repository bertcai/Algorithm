function minNumberInRotateArray(rotateArray) {
    let length = rotateArray.length;
    if (length === 0) {
        return 0;
    }
    let min = rotateArray[0];
    for (let i = 0; i < length; i++) {
        if (min > rotateArray[i]) {
            min = rotateArray[i];
        }
    }
    return min;
    // write code here
}