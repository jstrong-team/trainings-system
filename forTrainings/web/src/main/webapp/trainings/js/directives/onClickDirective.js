angular.module('trainingsModule').directive('onClickDirective', function() {
    return function(scope, element) {
        element.on('click', function(event)
        {
            var target = event.target;
            while (target !== element) {
                if (target.tagName === 'DIV') {
                    var className = target.classList.toString();
                    var regexp = new RegExp('(\\d)?\\d-(\\d)?\\d-\\d\\d\\d\\d');
                    var dateArray = className.match(regexp)[0].split('-');
                    alert("date: " + dateArray[0] + " month: " + dateArray[1] + " year: " + dateArray[2]);
                    return;
                }
                target = target.parentNode;
            }
        });
    };
});

