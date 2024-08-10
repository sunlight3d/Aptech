import { useEffect, useState } from "react";
import { sendRequest, BASE_URL, HttpMethod } from "../apis/api";
function EditPost({id}) {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    
    useEffect(()=>{
        //get post's detail from id
        axios.get(`https://localhost:7169/posts/${id}`, {})
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
                sendRequest({
                  url: `${BASE_URL}/${id}`,
                  data: {
                    title,
                    content,
                    user_id: localStorage.getItem("user_id")
                  },
                  headers,
                  httpMethod: HttpMethod.PUT
                });
            }}>Save Post</button>
        </div>
    </div>
}
export default EditPost;