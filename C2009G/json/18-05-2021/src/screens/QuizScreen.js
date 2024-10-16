import React, {Component} from 'react'
import './QuizScreen.css'
import {questions, calculateMarks} from '../data/fakeData'
//khai niem "state" = nhung thay doi noi tai ben trong man hinh
export default class QuizScreen extends Component {
    state = {
        questions: questions,
        totalMarks: 0,
        showMark: false,
    }
    componentDidMount(){
        debugger
    }
    render() {
        return <div className="container">
            <h1>Mời bạn chọn câu trả lời:</h1>
            {/* <h1>questions = {JSON.stringify(this.props.questions)}</h1> */}            
            {this.state.questions.map(question => {
                const {content,allAnswers,rightAnswers,selectedAnswers} = question
                return <div className="bd-example">
                    <h3>{content}</h3>
                    {allAnswers.map(eachAnswer => <div class="form-check">
                        <input class="form-check-input" 
                            onChange={(event)=>{
                                console.log(`eachAnswer = ${eachAnswer}`)                                                                
                                //selectedAnswers = [eachAnswer] //never !                                                                                            
                                let clonedQuestions = [...questions] //questions is "immutable"
                                clonedQuestions.filter(eachQuestion => eachQuestion.content == content)[0].selectedAnswers = [allAnswers.indexOf(eachAnswer)] 
                                this.setState({
                                    questions: clonedQuestions
                                })
                            }}
                            type="radio" name={content} id={`${content}1`}/>
                        <label class="form-check-label" for={`${content}1`}>
                          {eachAnswer}  
                        </label>
                    </div>)}
                    
                    {/* <div className="form-check">
                    <input className="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked />
                    <label className="form-check-label" for="flexRadioDefault2">
                        Default checked radio
                    </label>
                    </div> */}                    
                </div>
            })}           
            {this.state.showMark == true && <p class="text-danger">total marks = {this.state.totalMarks}</p>}    
            <button type="button" 
                onClick={(event) => {
                    console.log(JSON.stringify(this.state.questions))
                    //console.log(`total marks = ${calculateMarks(this.state.questions)}`)
                    this.setState({
                        totalMarks: calculateMarks(this.state.questions),
                        showMark: true
                    })
                    // debugger
                }}
                class="btn btn-primary mt-2">Submit your answer</button>         
        </div>
    }
}