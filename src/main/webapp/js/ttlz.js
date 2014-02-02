function populateTable(users, bgs) {
	$('#ttlz-main-table tbody').append('<tr><td>Матч</td></tr>');
	var userIds = new Array(); 
	for (var i = 0; i < users.length; i++) {
    	$('#ttlz-main-table tr:last').append('<td><div><div class="User">' + users[i].name + '</div><div class="Total">0</div></div></td>');
		userIds.push(users[i].id);
	}
	$('#ttlz-main-table tr:last').append('<td>Резальтат</td>');
	
	games = bgs.betGames;
	for (var i = 0; i < games.length; i++) {
		var game = games[i].game;
		var bets = games[i].bets;
    	$('#ttlz-main-table tr:last').after(getGameRow(game, bets, userIds));
	}
}

function getGameRow(game, bets, userIds) {
	var sA = '-';
	var sB = '-';
	if (game.scoreA != -1 && game.scoreB != -1) {
		sA = game.scoreA;
		sB = game.scoreB;
	}
	
	var betsTD = new Object();
	jQuery.each( userIds, function( i, val ) {
		betsTD[val] = "<td></td>"
	});

	if (bets.length > 0) {
		for (var i = 0; i < bets.length; i++) {
			betsTD[bets[i].userId] = '<td><div><div class="User">'+bets[i].betA+':'+bets[i].betB+'</div><div class="Total">' +bets[i].score+ '</div></div></td>';
		}
	}
	
	var td_values = new Array();
	for (var key in betsTD) {
	    td_values.push(betsTD[key]);
	}
	
	return '<tr><td>'+game.startTime+' '+game.teamA+' - '+game.teamB+'</td>'+td_values.join("")+'<td>'+sA+':'+sB+'</td></tr>';
}
