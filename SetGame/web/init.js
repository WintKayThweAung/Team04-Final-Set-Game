var jqmReady = $Deferred();
var deviceReady = $Deferred();

$(document).on("mobileinit", function() {
	console.log("mobile init");
	jqmReady.resolve();
});

document.addEventListener("deviceready", function() {
	console.log("device ready");
	deviceReady.resolve();
});
