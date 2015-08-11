var moduleApp = angular.module('app', ['ngRoute', 'ui.bootstrap', 'calendarModule', 'loginModule',
    'navigationModule', 'createModule', 'trainingPageModule', 'creationResponseModule',
    'ui.bootstrap.datetimepicker', 'trainingPageTrainerModule', 'adminNewsModule', 'trainingEditModule',
    'ngLoadingSpinner', 'trainingPageAdminModule', 'reportsModule','printPageModule', 'i18n',
    'approvePageModule','createApproveModule']);

moduleApp.config(['$locationProvider','$httpProvider', function ($locationProvider, $httpProvider) {
    $locationProvider.html5Mode(true);
    $httpProvider.interceptors.push('redirectInterceptor');
}]);

moduleApp.service('redirectInterceptor',['$q','$location',function($q,$location){
    return {
        'responseError': function(rejection) {
            // do something on error
            switch (rejection.status) {
                case 401:
                    $location.url('/ui/');
                    break;
                case 409:
                    $location.url('/ui/409');
                    break;
            }
            return $q.reject(rejection);
        }
    };
}]);

