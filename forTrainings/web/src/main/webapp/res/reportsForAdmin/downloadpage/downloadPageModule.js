angular.module('downloadPageModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/admin/reports/download', {
        templateUrl: 'res/reportsForAdmin/downloadpage/downloadPage.html',
        controller: 'reportDownloadController'
    });
}).controller('reportDownloadController',['$scope',function($scope){
    (function(){
        //document.body.innerHTML = localStorage.getItem('printHtml');
        //localStorage.removeItem('printHtml');
        //window.print();
    })();
}]);


