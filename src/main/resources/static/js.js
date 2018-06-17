function addBook() {
    var bookTitle = document.getElementById('addBookName').value;
    var bookAuthorName = document.getElementById('addBookAuthorName').value;
    var bookAuthorSurname = document.getElementById('addBookAuthorSurname').value;
    var bookYear = document.getElementById('addBookYear').value;
    var data = "http://localhost:8181/addBook?title='" + bookTitle + "'&name='" + bookAuthorName + "'&surname='" + bookAuthorSurname + "'&year=" + bookYear;
    document.getElementById('response').innerHTML = '<object type="text/plain" data="' + data + '"></object>';
}