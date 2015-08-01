angular.module('i18n', ['pascalprecht.translate']).config(function ($translateProvider) {
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('ru');

    $translateProvider.translations('en', {

        /*-------Navigation-------*/
        HEADER_CALENDAR: 'Calendar',
        HEADER_CREATE_TRAINING: 'Create training',
        HEADER_NEWS: 'News',
        HEADER_REPORTS: 'Reports',
        HEADER_LOG_OUT: 'Log out',
        HEADER_SEARCH_PLACEHOLDER: 'Search',

        /*-------Calendar-------*/
        MAIN_TITLE_CALENDAR: 'Trainings calendar',

        /*-------Create training-------*/
        MAIN_TITLE_CREATE_TRAINING: 'Create training',

        /*-------News-------*/
        MAIN_TITLE_NEWS: 'News',

        /*-------Reports-------*/
        MAIN_TITLE_REPORTS: 'Activity report'
    });

    $translateProvider.translations('ru', {

        /*-------Navigation-------*/
        HEADER_CALENDAR: 'Календарь',
        HEADER_CREATE_TRAINING: 'Создать тренинг',
        HEADER_NEWS: 'Новости',
        HEADER_REPORTS: 'Отчеты',
        HEADER_LOG_OUT: 'Выйти',
        HEADER_SEARCH_PLACEHOLDER: 'Поиск',

        /*-------Calendar-------*/
        MAIN_TITLE_CALENDAR: 'Календарь тренингов',

        /*-------Create training-------*/
        MAIN_TITLE_CREATE_TRAINING: 'Создать тренинг',

        /*-------News-------*/
        MAIN_TITLE_NEWS: 'Новости',

        /*-------Reports-------*/
        MAIN_TITLE_REPORTS: 'Отчет о сотруднике'
    });

    //    prefix: '', //относительный путь, например: /languages/
    //    suffix: '.json' //расширение файлов
    //});
});