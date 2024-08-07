import { useEffect, useState } from "react";
import axios from "axios";
function Home() {
    //call after Home load => useEffect
    const [posts, setPosts] = useState([])
    const [currentPage, setCurrentPage] = useState(1);
    const [limit] = useState(5); 
    useEffect(() => {
        //call api whenever currentPage changed
        axios.get(`https://localhost:7169/api/Posts?page_number=${currentPage}&page_size=${limit}`, {})
          .then(function (response) {
            //debugger
            setPosts(response?.data ?? [])
            console.log(response);
          })
          .catch(function (error) {
            //debugger
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }, [currentPage])
    return <div>
        <h1>Post list</h1>
        <table>
            <tbody>
                {posts.map((post) => (<tr key={post.title}>
                    <td>{post.id}</td>
                    <td>{post.title}</td>
                    <td>{post.content}</td>
                    <td><button onClick={() => {
                        alert('Edit')
                    }}>Edit</button></td>
                    <td onClick={() => {
                        alert('DElete ')
                    }}>Delete</td>
                </tr>))}
            </tbody>
        </table>
        <button onClick={() => {
            alert('press Add')
        }}>Add new post</button>
    </div>
}
export default Home;