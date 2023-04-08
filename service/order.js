
const addDelay = async({orderID, delay})=>{
    console.log(orderID,delay);
    
    return new Promise((resolve, reject)=>{
        console.log(orderID,delay); 
        client.set(orderID,"Cancel order","EX", delay,(err,result)=>{
            if (err)
                return reject(err);
            resolve(result);
        })
    
    })
    
}

module.exports = {
    addDelay
}