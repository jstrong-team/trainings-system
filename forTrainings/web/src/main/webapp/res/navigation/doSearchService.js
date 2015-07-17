angular.module('calendarModule').factory('doSearchService', ['$http', function($http) {
    var getSearchResults = function(expression) {
        return $http.get('rest/trainings/searchTrainings?param=block1&search=' + expression);
    };
    return getSearchResults;
}]);