angular.module('trainingPageModule').factory('trainingRedirectService',['$location','getRole',function($location,getRole){
    var redirect=function(id){
        getRole(id).then(function (data, status, headers, config){
            var role=data.data.role;
            switch (role) {
                case 'user':
                    $location.url('/ui/trainingPage/user/' + id);
                    break;
                case 'trainer':
                    $location.url('/ui/trainingPage/trainer/' + id);
                    break;
                case 'admin':
                    $location.url('/ui/trainingPage/admin/' + id);
                    break;
                default:
                    $location.url('/ui/trainings');
            }
        }, function (error) {
            console.error(error);
        });
    };
    return redirect;
}]);

