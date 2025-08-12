import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Node from './models/Node'
import { linearSearch, binarySearch } from './calculations'
function App() {
  const [count, setCount] = useState(0)
  let x = 10;
  let y = 20;
  let sum = x + y
/*
  const root = new Node(1, null, null);
  const second = new Node(2, null, null);
  root.next = second;
  second.back = root;

  const third = new Node(3, null, null);
  third.back = second;
  second.next = third;

  const four = new Node(4, null, null);
  four.back = third;
  third.next = four;

  let currentNode = root
  let lastNode = root;
  //duyet xuoi
  
  while(true) {
    if(currentNode != null) {
      currentNode.display()
    }
    lastNode = currentNode;
    currentNode = currentNode.next;
    if(currentNode == null){
      console.log("End of list")
      break;
    }
  }
  //duyet nguoc
  currentNode = lastNode
  while(true) {
    if(currentNode != null) {
      currentNode.display()
    }
    currentNode = currentNode.back;
    if(currentNode == null){
      console.log("End of list")
      break;
    }
  }
    */
  let randomArray = []
  for(let i = 0; i < 100_000; i++){
    let randomNumber = Math.floor(Math.random() * 1_000_000) + 1
    randomArray.push(randomNumber)
  }
  //find element with value = 123;
  console.log(JSON.stringify(randomArray))

  const start = Date.now();
  for(let j =0; j< 1000000; j++) {
    //let index = linearSearch(randomArray, 622302);
     let index = binarySearch(randomArray, 622302);
  }
  const ms = Date.now() - start;
  console.log(ms)
  //debugger
  return (
    <>
      <div className="card">
        <h1>sum is {sum}</h1>
      </div>
    </>
  )
}

export default App
