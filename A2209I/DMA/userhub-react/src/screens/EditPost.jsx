import { useEffect, useState } from "react";
import axios from "axios";
function EditPost({id}) {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    
    useEffect(()=>{
        //get post's detail from id
        axios.get(`https://localhost:7169/api/posts/${id}`, {})
          .then(function (response) {
            debugger
            //destructuring
            const {title, content} = response.data
            setTitle(title);
            setContent(content)
          })
          .catch(function (error) {
            //debugger
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }, [])
    return <div>
        <h1>Edit post</h1>
        <div>
            <div>
                <input type={"text"} 
                    name={"title"} 
                    value={title}
                    onChange={(event) => {
                        setTitle(event?.target.value ?? '')
                    }}
                    placeholder="Enter your title"/>
            </div>
            <div>
                <input type={"text"} 
                    name={"content"} 
                    value={content}
                    onChange={(event) => {
                        setContent(event?.target.value ?? '')
                    }}
                    placeholder="Enter your content"/>
            </div>
            <button onClick={() => {
                //alert(`Title = ${title}, content = ${content}`)
                debugger
                const headers =  {
                    'authorization': `Bearer ${localStorage.getItem("token")}`,
                    'Accept' : 'application/json',
                    'Content-Type': 'application/json'
                }
                axios.put(`https://localhost:7169/api/posts/${id}`, {
                    title,
                    content,
                    user_id: localStorage.getItem("user_id")
                  }, {headers})
                  .then(function (response) {
                    debugger  
                  })
                  .catch(function (error) {
                    debugger
                    console.log(error);
                  });
            }}>Save Post</button>
        </div>
    </div>
}
export default EditPost;