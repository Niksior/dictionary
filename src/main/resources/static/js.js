function addBook() {
    var bookTitle = document.getElementById('addBookName').value;
    var bookAuthor = document.getElementById('addBookAuthor').value;
    var bookYear = document.getElementById('addBookYear').value;
    var data = "http://localhost:8181/addBook?title='" + bookTitle + "'&author='" + bookAuthor + "'&year=" + bookYear ;
    document.getElementById('response').innerHTML = '<object type="text/plain" data="' + data + '"></object>';
}