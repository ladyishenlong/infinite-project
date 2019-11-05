var ViewModel = function (first, last) {

    this.firstName = ko.observable(first);
    this.lastName = ko.observable(last);//观察
    this.fullName = ko.computed(function () {
        return this.firstName() + " " + this.lastName();
    }, this);

    this.capitalizeLastName = function () {
        var currentVal = this.firstName();        // Read the current value
        this.firstName(currentVal.toUpperCase()); // Write back a modified value
    };

    this.is_checked = ko.observable(true);

    this.rows = ko.observableArray([]);//列表
    this.render = function () {
        var arr = ["注", "入", "灵", "魂"];
        this.rows(arr);
    };

    this.rows2 = ko.observableArray([]);
    this.render2 = function () {
        var arr = [{name: "name1"}, {name: "name2"}];
        this.rows2(arr);
    };


    this.first = ko.observable("姓氏");
    this.last = ko.observable("名字");
    this.full = ko.computed({
        read: function () {
        },
        write: function (value) {
            var lastSpacePos = value.lastIndexOf(" ");//空格断开
            if (lastSpacePos > 0) {
                this.first(value.substring(0, lastSpacePos));
                this.last(value.substring(lastSpacePos + 1));
            }
        }, owner: this
    });


    //价格数字 的格式自动转化
    this.price = ko.observable(25.99);
    this.formattedPrice = ko.computed({
        read: function () {
            return '$' + this.price().toFixed(2);
        },
        write: function (value) {
            value = parseFloat(value.replace(/[^\.\d]/g, ""));
            this.price(isNaN(value) ? 0 : value);
        }, owner: this
    });


    //对输入的值进行处理
    this.acceptedNumericValue = ko.observable(123);
    this.lastInputWasValid = ko.observable(true);
    this.attemptedValue = ko.computed({
        read: this.acceptedNumericValue,//显示的信息
        write: function (value) {//写入的信息进行处理
            if (isNaN(value))//判断是否是数字
                this.lastInputWasValid(false);
            else {
                this.lastInputWasValid(true);
                this.acceptedNumericValue(value);
            }
        }, owner: this
    });





};


ko.applyBindings(new ViewModel("abc", "ddf"));


