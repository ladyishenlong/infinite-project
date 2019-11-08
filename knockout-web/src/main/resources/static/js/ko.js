
require(['/js/resource.js'], function () {//先导入配置文件
    require(['jquery', 'knockout', 'bootstrap','koStyle'],
        function ($, ko, bootstrap,koStyle) {
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

                self.showColor = ko.observable(true);


                //event绑定
                self.showorhideText = ko.observable(false);
                self.showText = function () {
                    self.showorhideText(true);
                };
                self.hideText = function () {
                    self.showorhideText(false)
                };

                //value绑定
                self.username = ko.observable();
                self.password = ko.observable();

                self.user = ko.computed(function () {
                    return self.username() + " " + self.password();
                }, this)

            };
            ko.applyBindings(new viewModel());
        });
});




