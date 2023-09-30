const fetch = require ('node-fetch');
const promise = fetch ('http://localhost:8080');
promise.then(callbackOnResponse);

function callbackOnResponse(response){
    console.log(response);
}