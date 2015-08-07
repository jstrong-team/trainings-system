angular.module('trainingEditModule').controller('editController', ['$scope', '$routeParams', 'getTrainingInfo', 'editService','$location',
    function ($scope, $routeParams, getTrainingInfo, editService,$location) {

    getTrainingInfo().then(function (data, status, headers, config) {
        for (var i = 0; i < data.data.meets.length; ++i) {
            data.data.meets[i].date = moment(data.data.meets[i].date).format('YYYY-MM-DD HH:mm');
        }

        $scope.editInfo = data.data;
    }, function (error) {
        console.error(error);
    });

    $scope.addDate = function (index) {
        $scope.editInfo.meets.splice(index, 0, {date: '', id: null});
    };

    $scope.removeDate = function (index) {
        $scope.editInfo.meets.splice(index, 1);
    };

    $scope.isCollapsed = true;

    $scope.errorEditDateValidation = '';

    $scope.changeCollapse = function (collapsed) {
        $scope.isCollapsed = !$scope.isCollapsed;
    };

    $scope.datesChange = function (index, value) {
        $scope.editInfo.meets[index].date = value;
    };

    $scope.applyCahnges = function () {

        var arrDate = [];

        function hasDuplicates(array) {
            var valuesSoFar = Object.create(null);
            for (var i = 0; i < array.length; ++i) {
                var value = array[i];
                if (value in valuesSoFar) {
                    return true;
                }
                valuesSoFar[value] = true;
            }
            return false;
        }

        for (var i = 0; i < $scope.editInfo.meets.length; ++i) {

            var date = $scope.editInfo.meets[i].date;
            arrDate.push(date);

            if (!moment(date, 'YYYY-MM-DD HH:mm', true).isValid()) {
                $scope.errorEditDateValidation = 'DATE_VALIDATION_ERROR';
                return 'DATE_VALIDATION_ERROR';
            }

        }

        if (hasDuplicates(arrDate) === true) {
            $scope.errorEditDateValidation = 'DATE_VALIDATION_HAS_DUPLICATE';
            return 'DATE_VALIDATION_HAS_DUPLICATE';
        }

        editService($routeParams.trainingId, $scope.editInfo);
    };

}]);
