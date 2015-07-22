angular.module('trainingPageTrainerModule').filter('yesNoFilter',function(){
    return function(input){
        input=input||'';
        if(input==true){
            return 'yes'
        } else {
            return 'no'
        }
    }
});