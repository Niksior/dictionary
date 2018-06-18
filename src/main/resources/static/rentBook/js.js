var serverAddress = "http://localhost:8181/";

function bookRentById() {
    var id = document.getElementById('bookRentById').value;
    var data = serverAddress + "rentBook?id=" + id;
    document.getElementById('response').innerHTML = '<object type="text/html" data="' + data + '"></object>';
}