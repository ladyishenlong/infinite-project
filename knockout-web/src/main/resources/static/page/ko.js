$(function () {
    ko.applyBindings(new viewModel())
});

var viewModel = function () {
    var self = this;
    self.isCheck = ko.observable(false);

    //表格的添加以及删除
    self.table = ko.observableArray([]);
    self.tableAdd = function () {
        self.table.push({firstItem: "第一项", lastItem: "第二项"})
    };
    self.removeTableOne = function () {
        self.table.remove(this);
    };

    self.showColor=ko.observable(true);

};