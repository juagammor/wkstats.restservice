var app = angular.module('wkStatsApp.jugadoresSrv',[]);


app.factory('Jugadores', ['$http', '$q', function($http, $q){

	var self = {

		jugadores: {},

		obtenerJugadores: function() {

			var d = $q.defer();

			$http.get('service/JugadorService/jugadores')
			.then( function( data ){
				
				console.log(data);
				d.resolve(data);

			});

			return d.promise;
		}

	};

	return self;


}]);