var baseAPIURL="http://localhost:8080/ecommerce-matthew/";


async function post_api_call(apiUrl,formData,contentType){

    
const data= await fetch(baseAPIURL+apiUrl, {
    method: 'POST',
    body: formData,
    headers: {
        'Content-Type': contentType,
        'Accept': "application/json"
    },
   // mode:'no-cors'
    
})
.then(response => {
    console.log(response);
   // if (!response.ok) {
        //throw new Error('Network response was not ok');
    //}
    //return response.json(); // Parse the response as JSON
    return response.json();
})
.then(data => {
 
    console.log('Response data:', data);
    // You can perform further processing here
    return data;
})
.catch(error => {
    // Handle any errors that occurred during the fetch
   
    console.error('Fetch error:', error);
});

console.log(data);

return data;

}

async function get_api_call(apiUrl,contentType){

 return await    fetch(baseAPIURL+apiUrl, {
        method: 'GET'
    })
    .then(response => {
        console.log(response);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        //return response.json(); // Parse the response as JSON
        return response.json();
    })
    .then(data => {
       
        console.log('Response data:', data);
        // You can perform further processing here

        return data;
    })
    .catch(error => {
        // Handle any errors that occurred during the fetch
       
        console.error('Fetch error:', error);
    });
    
    };

    export { post_api_call,get_api_call}; 

