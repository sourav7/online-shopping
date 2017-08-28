$(function() {

	var $errId = $('.errHighlight');
	if ($errId.length) {
		$errId.effect("shake", {
			times : 5
		}, 30000);
	}
	// fadein the form
	var $panel = $('.panel');

	if ($panel.length && !$('.alert').length) {

		$panel.hide(0).delay(500).slideDown();
		// $panel.hide(0).show( "explode", {pieces:4}, 2000 );
		// $panel.effect( "bounce", {times:7}, 1500 );
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

	// If manually closed show the form
	$("#closeManageAlert").click(function() {
		$panel.show();
	});

});