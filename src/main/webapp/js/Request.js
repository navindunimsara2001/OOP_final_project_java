function searchItems() {
    const keyword = document.getElementById('searchInput').value;

    fetch(`/api/search?keyword=${keyword}`)
        .then(response => response.json())
        .then(data => displayResults(data))
        .catch(error => console.error('Error:', error));
}

function displayResults(results) {
    const resultsBody = document.getElementById('resultsBody');
    resultsBody.innerHTML = '';

    results.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.itemName}</td>
            <td>${item.description}</td>
        `;
        resultsBody.appendChild(row);
    });
}
