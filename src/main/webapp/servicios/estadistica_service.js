var app = angular.module('wkStatsApp.estadisticasSrv',[]);


app.factory('Estadisticas', ['$http', '$q', function($http, $q){

	var self = {

		estadisticas: {},

		obtenerEstadisticas: function() {

			var d = $q.defer();

			$http.get('service/EstadisticasService/estadisticas')
			.then( function( data ){
				
				console.log(data);
				d.resolve(data);

			});

			return d.promise;
		}

	};

	return self;


}]);