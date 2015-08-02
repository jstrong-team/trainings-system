angular.module('i18n', ['pascalprecht.translate']).config(function ($translateProvider) {

    $translateProvider.useStaticFilesLoader({
        prefix: '/res/i18n/locale-',
        suffix: '.json'
    });

    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('ru');

});