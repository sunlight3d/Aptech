export const convertSecondsToMMDDYY = ({seconds}) => {    
    let totalSeconds = seconds
    let hours = Math.floor(totalSeconds / 3600)
    totalSeconds = totalSeconds % 3600
    
    let minutes = Math.floor(totalSeconds / 60)
    let numberOfSeconds = totalSeconds % 60
    minutes = String(minutes).padStart(2, "0")
    hours = String(hours).padStart(2, "0")
    numberOfSeconds = String(numberOfSeconds).padStart(2, "0")    
    //return `${hours}:${minutes}:${numberOfSeconds}`
    return `${hours} giờ:${minutes} phút:${numberOfSeconds} giây`
}
