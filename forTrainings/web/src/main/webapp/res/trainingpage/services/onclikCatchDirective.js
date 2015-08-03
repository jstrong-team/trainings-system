angular.module('trainingPageTrainerModule').directive('tableCatchDirective', ['storageService','$modal',function (storageService,$modal) {
     function link(scope, element,attrs){
         var text='No';
         element.on('click', function (event) {
             var list=event.target.classList;
             var clickObj;
             if(element.text()!==text){
                 clickObj={
                     id:list[0],
                     meetId:list[1],
                     isAbsent:true,
                     reason:''
                 };
                 element.text(text);
                 storageService.set(clickObj);
                 console.log(storageService.get());
                 element.attr('title',clickObj.reason);
             }else {
                 clickObj={
                     id:list[0],
                     meetId:list[1],
                     isAbsent:false,
                     reason:''
                 };
                 element.text('');
                 storageService.delete(clickObj);
                 console.log(storageService.get());
                 element.attr('title',clickObj.reason);
             }
         });

         element.on('dblclick', function (event) {
             var list=event.target.classList;
             var clickObj;
             if(element.text()!==text){
                 clickObj={
                     id:list[0],
                     meetId:list[1],
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
                     element.text(text);
                     clickObj.reason=reason;
                     element.attr('title',clickObj.reason);
                     storageService.set(clickObj);
                     //console.log(storageService.get());
                 });
             }else {
                 clickObj={
                     id:list[0],
                     meetId:list[1],
                     isAbsent:false,
                     reason:''
                 };
                 element.text('');
                 console.log(storageService.get());
                 element.attr('title',clickObj.reason);
                 storageService.delete(clickObj);
             }
         });


     }
    return {
        restrict: 'A',
        link:link
    };
}]);

