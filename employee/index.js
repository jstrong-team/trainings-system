<!DOCTYPE html>
<html lang="en-US">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<body>

<div ng-app="">
    <p>Name: <input type="text" ng-model="name"></p> 
    <p>Name: <input type="text" ng-model="name2"></p>
    <p ng-bind="name"></p>
</div>

</body>
</html>