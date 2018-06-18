var serverAddress = "http://localhost:8181/";

function bookReturnById() {
    var id = document.getElementById('bookReturnById').value;
    var data = serverAddress + "returnBook?id=" + id;
    document.getElementById('response').innerHTML = '<object type="text/html" data="' + data + '"></object>';
}