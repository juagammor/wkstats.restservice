var app = angular.module('wkStatsApp.temporadasSrv',[]);


app.factory('Temporadas', ['$http', '$q', function($http, $q){

	var self = {

		temporadas: {},

		obtenerTemporadas: function() {

			var d = $q.defer();

			$http.get('service/TemporadaService/temporadas')
			.then( function( data ){
				
				console.log(data);
				d.resolve(data);

			});

			return d.promise;
		}

	};

	return self;


}]);