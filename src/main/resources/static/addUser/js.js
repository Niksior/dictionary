var serverAddress = "http://localhost:8181/";

function addUser() {
    var userLogin = document.getElementById('userLogin').value;
    var userName = document.getElementById('userName').value;
    var userSurname = document.getElementById('userSurname').value;
    var userPassword = document.getElementById('userPassword').value;
    var userPESEL = document.getElementById('userPESEL').value;
    var userAdmin = document.getElementById('userAdmin').value;
    var data = serverAddress + "addUser?" +
        "login='" + userLogin +
        "'&name='" + userName +
        "'&surname='" + userSurname +
        "'&password='" + userPassword +
        "'&isAdmin='" + userAdmin +
        "'&PESEL=" + userPESEL;
    document.getElementById('response').innerHTML = '<object type="text/html" data="' + data + '"></object>';
}