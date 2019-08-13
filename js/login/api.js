var firebase = require("firebase");
var fs = require("fs")
eval(fs.readFileSync("login/config.js")+"");

async function login() {
    var provider = new firebase.auth.GoogleAuthProvider();
    var resultToken = await firebase.auth().signInWithPopup(provider).then(function(result) {
        // This gives you a Google Access Token. You can use it to access the Google API.
        var token = result.credential.accessToken;
        return token;
    });
    
    return resultToken;
}