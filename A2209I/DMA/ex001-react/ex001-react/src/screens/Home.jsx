import { useEffect, useState } from "react";
import { sendRequest, BASE_URL, HttpMethod } from "../apis/api";
function Home() {
    //call after Home load => useEffect
    const [products, setProducts] = useState([])
    useEffect(() => {
        sendRequest({
            url: `${BASE_URL}/product`,
            data: {},
            httpMethod: HttpMethod.GET
        }).then(function (response) {
            debugger
            setProducts(response?.data ?? [])
            console.log(response);
          })
          .catch(function (error) {
            debugger
            console.log(error);
          });
    }, [])
    return <div>
        <h1>Product list</h1>
        <table>
            <tbody>
                {products.map((product) => (<tr key={product.id}>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.description}</td>
                    <td>{product.price}</td>
                    <td>{product.stock}</td>
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
        }}>Add new product</button>
    </div>
}
export default Home;