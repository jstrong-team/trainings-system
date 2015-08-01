angular.module('i18n').controller('TranslateController',['$scope', '$translate', function($scope, $translate) {
    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };
}]);

