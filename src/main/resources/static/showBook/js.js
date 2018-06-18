var serverAddress = "http://localhost:8181/";

function bookSearch() {
    var bookTitle = document.getElementById('bookSearchByTitle').value;
    var data = serverAddress + "showBook?title='" + bookTitle + "'";
    document.getElementById('response').innerHTML = '<object type="text/html" data="' + data + '"></object>';
}