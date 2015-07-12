angular.module('trainingsModule').directive('onFinishRender', function($timeout) {
    return function(scope) {
        if (scope.$last === true){
            $timeout(function () {
                scope.$emit('ngRepeatFinished');
            });
        }
    };
});