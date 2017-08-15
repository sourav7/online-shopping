$(function() {

	// fadein the form
	var $panel = $('.panel');

	if ($panel.length && !$('.alert').length) {

		 $panel.hide(0).delay(500).slideDown();

		// setTimeout(function() {
		// $panel.fadeIn('slow');
		// }, 2000);

	}

	// dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {
		// hide the panel first
		$panel.hide(0);
		// set fadeout to the alert bar
		setTimeout(function() {
			$alert.fadeOut('slow',
			// set fade in to the panel
			function() {
				$panel.delay(100).fadeIn(2000);
			});
		}, 2000);

	}
	
	//If manually closed show the form
	$("#closeManageAlert").click(function() {
		$panel.show();
	});

});