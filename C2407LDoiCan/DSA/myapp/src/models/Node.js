export default class Node {
    constructor(data, next, back) {
    this.data = data;
    this.next = next;
    this.back = back;
  }
  display() {
    console.log(this.data+" ")
  }
}