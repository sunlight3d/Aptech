import { useState } from "react";
import { sendRequest, BASE_URL, HttpMethod } from "../apis/api";

function AddPost(props) {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    return <div>
        <h1>Add new post</h1>
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
                    url: `${BASE_URL}/api/posts`,
                    data: {
                        title,
                        content,
                        user_id: localStorage.getItem("user_id")
                    },
                    headers,
                    httpMethod: HttpMethod.POST
                });
            }}>Add Post</button>
        </div>
    </div>
}
export default AddPost;