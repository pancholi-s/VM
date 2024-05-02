const http = require('http');
const fs = require('fs');
const path = require('path');

const PORT = 8000;
const server = http.createServer((req,res)=>{
    let filepath = path.join(__dirname,'public',req.url === '/'?'index.html':req.url);
    
    let contentType = "text/html";

    fs.readFile(filepath,(err,content)=>{
        if(err)
        {
            if(err.code ==="ENOENT")
            {
                res.writeHead(404);
                res.end("File not found");
            }
            else
            {

            }
        }
        else
        {
            res.writeHead(200, { 'Content-Type': contentType });
            res.end(content,"utf-8");
        }
    })
    
});


server.listen(PORT,()=>{
    console.log(`Server is listening on ${PORT}`)
})