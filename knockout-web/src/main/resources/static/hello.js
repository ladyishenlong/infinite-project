

// 定义一个ViewModel
var ViewModel = function (first, last) {
    this.firstName = ko.observable(first);
    this.lastName = ko.observable(last);

    this.fullName = ko.computed(function () {
        // 根据firstName和lastNamecomputed出fullName
        return this.firstName() + " " + this.lastName();
    }, this);
};

//knockout调用applybindings激活ViewModel，即，使得ViewModel与上述div中的静态绑定联系起来
ko.applyBindings(new ViewModel("zhang", "zhang"));

