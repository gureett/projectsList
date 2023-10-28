function feelingLucky() {
    const searchQuery = document.querySelector('.input-search').value;
    const url = `https://www.google.com/search?btnI=1&q=${searchQuery}`;
    window.location.href = url;
}
