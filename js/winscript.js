function openChild(file, window) {
	childWindow = open(file, window, 'resizable=no,width=400,height=600');
	if(childWindow.opener == null) {
		childWindow.opener = self;
	}
}

function updateParent() {
	
	//alert("data sended");
	//self.close();
	opener.location.reload(true);
	
	return false;

}

function updParent(f) {
	//alert("Ready Submitted");
	//f.submit();
	//alert("Submitted");
	self.close();
	opener.location.reload(true);
	
	return false;

}
function updateParentclose() {
	
	
	self.close();
	opener.location.reload(true);
	
	return false;

}