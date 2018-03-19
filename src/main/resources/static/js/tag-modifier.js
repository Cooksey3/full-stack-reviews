const xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.response);
		console.log(res);
	}
};

const removeButton = document.querySelectorAll('.deleteButton');
removeButton.forEach(button => { 
	button.addEventListener('click', () => {
		const bookId = button.dataset.removeId;
		const tagId = button.dataset.tagId;

		xhr.open('DELETE', 'http://localhost:8080/remove-tag?bookId=' + bookId + '&tagId=' + tagId, true);
		xhr.send(); 
	});
});