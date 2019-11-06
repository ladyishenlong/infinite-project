$(function () {
    ko.applyBindings(model);

    model.message("Hello, world!");
    model.priceRating("name");
    model.currentProfit(-50);

});


var model = {
    message: ko.observable(), // Initially blank
    priceRating: ko.observable(11.11),
    currentProfit: ko.observable(-10),


    msgVisible: ko.observable(true),
    btnVisible: function () {
        this.msgVisible(!(this.msgVisible()));//点击控制显示与消失
    },

    //绑定event
    detailsEnabled: ko.observable(false),
    enableDetails: function () {
        this.detailsEnabled(true);
    },
    disableDetails: function () {
        this.detailsEnabled(false);
    },

    //动态表格
    people: ko.observableArray([]),
    addPerson: function () {
        this.people.push({name: "名字"})
    },
    removePerson: function () {
        this.people.remove(this.people);
    }

};


