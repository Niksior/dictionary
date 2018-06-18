var serverAddress = "http://localhost:8181/";

function addBookMenu() {
    var data = serverAddress + "addBook/index.html";
    document.getElementById("mainActivity").innerHTML = '<object type="text/html" data="' + data + '"></object>';
}

function addUser() {
    var data = serverAddress + "addUser/index.html";
    document.getElementById("mainActivity").innerHTML = '<object type="text/html" data="' + data + '"></object>';
}

function showBook() {
    var data = serverAddress + "showBook/index.html";
    document.getElementById("mainActivity").innerHTML = '<object type="text/html" data="' + data + '"></object>';
}

function rentBook() {
    var data = serverAddress + "rentBook/index.html";
    document.getElementById("mainActivity").innerHTML = '<object type="text/html" data="' + data + '"></object>';
}

function returnBook() {
    var data = serverAddress + "returnBook/index.html";
    document.getElementById("mainActivity").innerHTML = '<object type="text/html" data="' + data + '"></object>';
}