import React, {Component} from 'react'
import './QuizScreen.css'

export default class QuizScreen extends Component {
    componentDidMount(){
        debugger
    }
    render() {
        return <div className="container">
            <h1>Mời bạn chọn câu trả lời:</h1>
            {/* <h1>questions = {JSON.stringify(this.props.questions)}</h1> */}            
            {this.props.questions.map(question => {
                const {content,allAnswers,rightAnswers,selectedAnswers} = question
                return <div className="bd-example">
                    <h3>{content}</h3>
                    {allAnswers.map(eachAnswer => <div class="form-check">
                        <input class="form-check-input" type="radio" name={content} id={`${content}1`}/>
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
        </div>
    }
}