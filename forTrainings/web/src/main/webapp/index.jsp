<!DOCTYPE html>
<html lang="en-US" ng-app="app">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular-route.js"></script>
<script src="index.js"></script>


<script src="login/js/module.js"></script>
<script src="login/js/controllers.js"></script>
<script src="login/js/services.js"></script>

<script src="trainings/js/module.js"></script>
<script src="trainings/js/controllers/trainingsController.js"></script>
<script src="trainings/js/controllers/controllerCalendar.js"></script>
<script src="trainings/js/services/getTrainingsService.js"></script>
<script src="trainings/js/services/doSearchService.js"></script>
<script src="trainings/js/directives/onFinishRender.js"></script>
<script src="trainings/js/directives/onClickDirective.js"></script>
<script src="trainings/js/calendar.js"></script>

<header>
    <base href="/">
</header>

<body ng-view>
</body>

</html>