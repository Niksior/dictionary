function addBook() {
    var bookTitle = document.getElementById('addBookName').value;
    var bookAuthor = document.getElementById('addBookAuthor').value;
    var data = "http://localhost:8181/test?id=" + bookTitle + " " + bookAuthor;
    document.getElementById('response').innerHTML = '<object type="text/plain" data="' + data + '"></object>';
}