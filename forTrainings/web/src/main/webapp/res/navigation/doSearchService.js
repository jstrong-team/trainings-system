angular.module('calendarModule').factory('doSearchService', ['$http', function($http) {
    var getSearchResults = function(expression) {
        return $http.get('rest/trainings/searchTrainings?search=' + expression);
    };
    return getSearchResults;
}]);