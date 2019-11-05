$(function () {
    ko.applyBindings(model);

    model.message("Hello, world!");
    model.priceRating("name");
    model.currentProfit(-50);
});


var model = {
    message: ko.observable(), // Initially blank
    priceRating: ko.observable(11.11),
    currentProfit: ko.observable(-10)
};


