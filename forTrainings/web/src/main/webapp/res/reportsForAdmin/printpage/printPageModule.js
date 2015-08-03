angular.module('printPageModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/admin/reports/print', {
        templateUrl: 'res/reportsForAdmin/printpage/printPage.html',
        controller: 'reportPrintController'
    });
}).controller('reportPrintController',['$scope',function($scope){
    (function(){
        document.body.innerHTML = localStorage.getItem('printHtml');
        localStorage.removeItem('printHtml');
        window.print();
    })();
}]);


