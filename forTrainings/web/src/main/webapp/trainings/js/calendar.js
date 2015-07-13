function Day(date, day, month, year) {
	this.date = date;
	this.day = day;
	this.month = month;
	this.year = year;
}

function getNthDate(i) {
	var tomorrow = new Date();
	tomorrow.setDate(i);
	return tomorrow;
}

function getThreeMonthDays () {
	var days = [];
	var today = new Date();
	var endIndexMonth = (today.getMonth() + 3) % 12;
	var currentIndexMonth = getNthDate(1).getMonth();
	var i = 2 - getNthDate(1).getDay();
	var day = getNthDate(i++);
	while(currentIndexMonth !== endIndexMonth) {
		days.push(new Day(day.getDate(), day.getDay(), day.getMonth()+1, day.getFullYear()));
		day = getNthDate(i);
		currentIndexMonth = day.getMonth();
		++i;
	}
	while (days[days.length - 1].day !== 0) {
		days.push(new Day(day.getDate(), day.getDay(), day.getMonth()+1, day.getFullYear()));
		day = getNthDate(i);
		++i;
	}
	return days;
}

function markCurrentDay () {
	var today = new Date();
	var date = today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear() + 1900;
	var selector = '.fulldate_' + date + '-' + month + '-' + year;
	var element = document.querySelector(selector);
	element.className += " currentDay";
}

function getThreeMoths () {
    var result = [];
    var currentYear = getNthDate(1).getYear() + 1900;
    var currentIndexMonth = getNthDate(1).getMonth();
    var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August',
        'September', 'October', 'November', 'December'];
    for (var i = 0; i < 3; ++i) {
        result.push({month: months[currentIndexMonth], year: currentYear});
        currentIndexMonth = (++currentIndexMonth) % 12;
        if (currentIndexMonth === 0) {
            ++currentYear;
        }
    }
    return result;
}
