$(function () {
    ko.applyBindings(new Model());
});

var Model = function () {
    var self = this;

    //动态修改列表,foreach
    self.people = ko.observableArray([]);
    self.addPerson = function () {
        self.people.push({name: "姓名"});//添加一项
    };
    self.removePerson = function () {
        self.people.remove(this);//删除该项
    };

    //勾选框
    self.ifBindMessage = ko.observable(false);


    //submit绑定
    // self.account = ko.observable('数据');
    self.accountResult = ko.observable("数据");
    //

};