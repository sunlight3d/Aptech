import React, {Component} from 'react'
import './QuizScreen.css'
import {questions, calculateMarks} from '../data/fakeData'
import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css'
import {convertSecondsToMMDDYY} from '../utilities/utilities'
//khai niem "state" = nhung thay doi noi tai ben trong man hinh
export default class QuizScreen extends Component {
    state = {
        currentQuestions: [],
        questions: questions,
        totalMarks: 0,
        showMark: false,
        remainTime: 10000,
        page:0,
        limit: 3,    
    }
    componentDidMount(){        
        const {page, limit, questions} = this.state        
        this.setState({            
            currentQuestions: questions.slice(0, limit),
        })
        //tru thoi gian lui        
        setInterval(()=>{
            this.setState({remainTime: this.state.remainTime > 0 
                                    ? this.state.remainTime - 1 : this.state.remainTime})
        }, 1000)
    }
    _onClickPageItem = (event) => {
        debugger
        let currentPage = parseInt(event.target.id)
        const {page, limit, questions} = this.state        
        this.setState({
            page: currentPage,
            currentQuestions: questions.slice(currentPage * limit, currentPage*limit + limit),
        })
    }
    _createPagination() {        
        let rows = []
        for(let i = 0; i < Math.ceil(this.state.questions.length / this.state.limit, 1); i++){
            let isSelected = this.state.page == i;
            let eachRow = <li class= {isSelected == true ? "page-item active" : "page-item"} aria-current="page">
                {isSelected == true ? <span id = {i}
                        onClick={this._onClickPageItem}
                    class="page-link">{i+1}</span>: 
                    <a class="page-link" id = {i}
                        onClick={this._onClickPageItem}
                    >{i+1}</a>}
            </li>
            rows.push(eachRow)
        }
        return <nav aria-label="..." class="mt-4">
            <ul class="pagination pagination-lg">
                {rows}                                                        
            </ul>
        </nav>        
    }
    render() {        
        return <div className="container">
            <h1>Mời bạn chọn câu trả lời:</h1>
            <h3>Thời gian còn lại: <span class="badge rounded-pill bg-success">{convertSecondsToMMDDYY({seconds: this.state.remainTime})}</span></h3>
            {/* <h1>questions = {JSON.stringify(this.props.questions)}</h1> */}            
            {this.state.currentQuestions.map(question => {
                const {content,allAnswers,rightAnswers,selectedAnswers} = question
                return <div className="bd-example">
                    <h3>{content}</h3>
                    {allAnswers.map(eachAnswer => <div class="form-check">
                        <input class="form-check-input" 
                            onChange={(event)=>{
                                console.log(`eachAnswer = ${eachAnswer}`)                                                                
                                //selectedAnswers = [eachAnswer] //never !                                                                                            
                                let clonedQuestions = [...questions] //questions is "immutable"
                                //clonedQuestions.filter(eachQuestion => eachQuestion.content == content)[0].selectedAnswers = [allAnswers.indexOf(eachAnswer)] 
                                let selectedAnswers = clonedQuestions.filter(eachQuestion => eachQuestion.content == content)[0].selectedAnswers;
                                if(event.target.checked == true) {
                                    selectedAnswers.push(allAnswers.indexOf(eachAnswer))
                                } else {
                                    //xoa phan tu
                                    selectedAnswers = selectedAnswers.filter(e => e != allAnswers.indexOf(eachAnswer))
                                }
                                debugger
                                this.setState({
                                    questions: clonedQuestions
                                })
                            }}
                            type="checkbox" name={content} id={`${content}1`}/>
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
            {this._createPagination()}
            {this.state.remainTime == 0 ? <h3>Time End</h3> : <button type="button" 
                onClick={(event) => {
                    console.log(JSON.stringify(this.state.questions))
                    //console.log(`total marks = ${calculateMarks(this.state.questions)}`)
                    confirmAlert({
                        title: 'Confirm to submit',
                        message: 'Are you sure to submit your exam ?',
                        buttons: [
                          {
                            label: 'Yes',
                            onClick: (event) => {
                                this.setState({
                                    totalMarks: calculateMarks(this.state.questions),
                                    showMark: true
                                })
                            }
                          },
                          {
                            label: 'No',
                            onClick: (event) => {
                                //do nothing !
                            }
                          }
                        ]
                      })                    
                    // debugger
                }}
                class="btn btn-primary mt-2">Submit your answer</button>}         
        </div>
    }
}