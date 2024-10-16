$(document).ready(function(){
    //getSomethingFromAPI()
})

const getSomethingFromAPI = async () => {
    try {

        //const url = "https://rss.itunes.apple.com/api/v1/us/apple-music/coming-soon/all/100/explicit.json"
        const url = "https://jsonplaceholder.typicode.com/todos"
        const options = {
            method: 'GET',
            cache: 'no-cache',
            // mode: 'no-cors',
            headers: {
                'Content-Type': 'application/json',
                 //'Content-Type': 'application/x-www-form-urlencoded',
            }
        }
        /*
        fetch(url, options)
        .then(response => {
            debugger
            return response.json()
        })
        .then(data => {
            debugger
            console.log(data)
            debugger
        }).catch(error => {
            debugger
            console.log(`error = ${JSON.stringify(error)}`)
        }) 
        */
        const response = await fetch(url, options)
        const responseJSON = await response.json()
        responseJSON.forEach(user => {
            /*
            const userId = user.userId
            const id = user.id
            const title = user.title
            const hoanthanh = user.completed
            */
            //destructuring an object
            const {userId, id, title, completed} = user
            debugger
        })
    }catch(error) {
        debugger
        console.log(`error = ${JSON.stringify(error)}`)
    }
    
    /*
    fetch(url)
        .then(response => response.json())
        .then(data => console.log(data))
    console.log('haha')
    */
    //Promise, ti nua lam them 1 vi du ve promise
}
async function nauCom(x, y) {
    console.log('Bat dau nau com')
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Nau com xong')
            resolve()
        }, 2000)
    })
    
}

async function luocRau(x, y) {
    console.log('Bat dau luoc rau')
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Luoc rau xong')
            resolve()
        }, 3000)
    })
    //promisify
}

async function lamViecNha(){
    await nauCom()
    await luocRau()
}
lamViecNha()