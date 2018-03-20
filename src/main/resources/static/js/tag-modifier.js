const xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.response);
	}
};

const removeButton = document.querySelectorAll('.deleteButton');
removeButton.forEach(button => { 
	button.addEventListener('click', () => {
		const bookId = button.dataset.removeId;
		const tagId = button.dataset.tagId;

		xhr.open('DELETE', 'http://localhost:8080/remove-tag?bookId=' + bookId + '&tagId=' + tagId, true);
		xhr.send();
		
		button.parentNode.remove();
		
	});
});

const addBtn = document.querySelector('.addButton');

addBtn.addEventListener('click', function(event) {
	event.preventDefault();
	const tag = document.querySelector('#tagInput').value;
	const bookId = addBtn.dataset.bookId;

	xhr.open('POST', 'http://localhost:8080/add-tag?bookId=' + bookId + '&addTag='+ tag, true);
	xhr.send();
	
	const tagList = document.querySelector(".tags");
	const deleteButton = document.querySelector(".deleteButton");
	appendElement(tagList, createElement('p', tag));
	appendElement(tagList, createElement('button', deleteButton));
});

function createElement (elem, textValue) {
	const newElem = document.createElement(elem);
	newElem.innerText = textValue;
	return newElem;
}

function appendElement(parent, child) {
	parent.appendChild(child);
}