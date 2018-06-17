var serverAddress = "http://localhost:8181/";

function login() {
    var login = document.getElementById('login').value;
    var password = document.getElementById('passwd').value;
    var data = serverAddress + "login?name='" + login + "'&passwd='" + password + "'";
    document.getElementById('loggedUser').innerHTML = '<object type="text/html" data="' + data + '"><div id="login1"></div></object>';
}
