angular.module('trainingPageTrainerModule').directive('tableCatchDirective', ['storageService','$modal',function (storageService,$modal) {
     function link(scope, element,attrs){
         element.on('click', function (event) {
             var list=event.target.classList;
             var clickObj;
             if(element.text()!=='No'){
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:true,
                     reason:''
                 };
                 element.text('No');
                 storageService.set(clickObj);
                 console.log(storageService.get());
             }else {
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:false,
                     reason:''
                 };
                 element.text('');
                 storageService.delete(clickObj);
                 console.log(storageService.get());
             }
         });

         element.on('dblclick', function (event) {
             var list=event.target.classList;
             var clickObj;
             if(element.text()!=='No'){
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:true,
                     reason:''
                 };
                 var modalInstance =$modal.open({
                     animation: true,
                     templateUrl: '/res/trainingpage/reasonModal.html',
                     controller: 'absentReasonModalCtrl',
                     windowClass: 'modalMain',
                     size: 'sm'
                 });
                 modalInstance.result.then(function(reason){
                     element.text('No');
                     clickObj.reason=reason;
                     storageService.set(clickObj);
                     console.log(storageService.get());
                 });
             }else {
                 clickObj={
                     id:list[0],
                     date:list[1]+' '+list[2],
                     isAbsent:false,
                     reason:''
                 };
                 element.text('');
                 console.log(storageService.get());
                 storageService.delete(clickObj);
             }
         });



     }
    return {
        restrict: 'A',
        link:link
    };
}]);

