angular.module('approvePageModule').factory('parseService', [function () {
    var array = {
        expression: [],
        type: []
    };

    var service = {};

    service.parse = function (input) {
        array.expression = [];
        array.type = [];
        //var regExp = /\!?\{([^}]+)\}/;
        //var replReg = /\!?\{/;
        //0 - word; 1 - add; 2 - rm ; 3 -rlc
        var res = input.split('!{');
        array.type = new Array(res.length);
        for (var i = 0; i < res.length; i++) {
            res[i] = res[i].replace(/\}/g, '');
        }
        for (i = 0; i < res.length; i++) {
            if (/add:\s+/.test(res[i])) {
                res[i] = res[i].replace(/add:\s/, '');
                array.type[i] = 1;
            } else if (/rm:\s+/.test(res[i])) {
                res[i] = res[i].replace(/rm:\s/, '');
                array.type[i] = 2;
            //} else if (/rlc:\s+/.test(res[i])) {
            //    res[i] = res[i].replace(/rlc:\s/, '');
            //    array.type[i] = 3;
            } else {
                array.type[i] = 0;
            }
        }
        array.expression=res;
        return angular.copy(array);
    };

    service.get = function () {
        return angular.copy(array);
    };

    service.clear = function () {
        array = [];
    };

    return service;
}]);