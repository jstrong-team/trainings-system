angular.module('calendarModule').directive('onFinishRender', ['$timeout', function($timeout) {
    return function(scope) {
        if (scope.$last === true) {
            $timeout(function () {
                scope.$emit('ngRepeatFinished');
            });
        }
    };
}]);