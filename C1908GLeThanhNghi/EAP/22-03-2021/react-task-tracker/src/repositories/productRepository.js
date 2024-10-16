export const getProducts = (filteredText) => {
    let fakeProducts = [
        {
            productName: 'iphone 3',
            url: 'https://vi.wikipedia.org/wiki/T%E1%BA%ADp_tin:Culinary_fruits_front_view.jpg',
            year: 2013
        },
        {
            productName: 'iphone 5',
            url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Nectarine_Fruit_Development.jpg/440px-Nectarine_Fruit_Development.jpg',
            year: 2015
        },
        {
            productName: 'iphone 4',
            url: 'https://vi.wikipedia.org/wiki/T%E1%BA%ADp_tin:Drupe_fruit_diagram-en.svg',
            year: 2014
        },
        {
            productName: 'iphone 6',
            url: 'https://vi.wikipedia.org/wiki/T%E1%BA%ADp_tin:Culinary_fruits_front_view.jpg',
            year: 2016
        },
    ]    
    fakeProducts.filter(item => item.contains(filteredText))
    debugger
    return filteredText == '' ?  fakeProducts :
            fakeProducts.filter(item => item.contains(filteredText))
}