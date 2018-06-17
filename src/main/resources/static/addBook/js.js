var serverAddress = "http://localhost:8181/";

function addBook() {
    var bookTitle = document.getElementById('addBookName').value;
    var bookAuthorName = document.getElementById('addBookAuthorName').value;
    var bookAuthorSurname = document.getElementById('addBookAuthorSurname').value;
    var bookYear = document.getElementById('addBookYear').value;
    var data = serverAddress + "addBook?title='" + bookTitle + "'&name='" + bookAuthorName + "'&surname='" + bookAuthorSurname + "'&year=" + bookYear;
    document.getElementById('response').innerHTML = '<object type="text/html" data="' + data + '"></object>';
}