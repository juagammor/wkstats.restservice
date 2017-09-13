var app = angular.module( 'wkStatsApp', 
		['wkStatsApp.temporadasSrv', 
		 'wkStatsApp.estadisticasSrv',
		 'wkStatsApp.jugadoresSrv']);

app.controller('mainCtrl', ['$scope', 'Temporadas', 'Estadisticas', 'Jugadores', function ($scope, Temporadas, Estadisticas, Jugadores) {
	
	$scope.temporadas = {};
	$scope.temporadaSlct = "";
	
	$scope.estadisticas = {};
	
	$scope.jugadores = {};
	$scope.jugadoresSlct = "";

	$scope.jugadorFlt = "";
	$scope.jornadaFlt = "";

	Temporadas.obtenerTemporadas().then(
		function(temps) {
			$scope.temporadas = temps.data;
		});

	Estadisticas.obtenerEstadisticas().then(
		function(stats){
			$scope.estadisticas = stats;
		});
	
	Jugadores.obtenerJugadores().then(
		function(players){
			$scope.jugadores = players.data;
		}
	);
	
	
}]);
