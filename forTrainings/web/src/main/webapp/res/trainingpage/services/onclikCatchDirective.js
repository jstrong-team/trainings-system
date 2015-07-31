angular.module('trainingPageTrainerModule').directive('tableCatchDirective', ['storageService',function (storageService) {
     function link(scope, element,attrs){
         element.on('click', function (event) {
             var list=event.target.classList;
             var clickObj;
             if(element.text()!=='No'){
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:true,
                     reason:'why'
                 };
                 element.text('No');
                 storageService.set(clickObj);
             }else {
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:false,
                     reason:''
                 };
                 element.text('');
                 storageService.delete(clickObj);
             }
         });
     }
    return {
        restrict: 'A',
        link:link
    };
}]);

