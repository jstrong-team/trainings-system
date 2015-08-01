angular.module('printPageModule', []).config(function($routeProvider) {
    $routeProvider.when('/ui/admin/reports/print', {
        templateUrl: 'res/reportsForAdmin/printpage/printPage.html',
        controller: 'reportPrintController',
        resolve: {
            getInnerHtml:[function(){
                document.body.innerHTML = localStorage.getItem('printHtml');
                localStorage.removeItem('printHtml');
                window.print();
            }]
        }
    });
}).controller('reportPrintController',['$scope',function(){

}]);


