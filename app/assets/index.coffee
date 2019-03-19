
	$.get "/persons", (persons) ->
		$.each persons, (index, person) ->
			console.log("loop")
			$('#persons').append $("<li>").text person.name