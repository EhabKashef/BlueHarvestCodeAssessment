var app = angular.module('crudAppAccount',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/BlueHarvestAssessment',
    USER_SERVICE_API : 'http://localhost:8080/BlueHarvestAssessment/api/accounts/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/getaccounts/1',
                templateUrl: 'partials/accountList',
                controller:'AccountController',
                controllerAs:'actrl',
                resolve: {
                    users: function ($q, AccountService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        AccountService.loadAllAccounts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

