require.config({
    map: {
        '*': {
            css: "https://cdn.bootcss.com/require-css/0.1.10/css.js" //集成require-css插件
        }
    },
    paths: {
        //在线地址才需要把原本最后的.js去除才行
        jquery: "https://code.jquery.com/jquery-1.9.1.min",
        knockout: "https://knockoutjs.com/downloads/knockout-3.5.0",
        bootstrap: "https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min",

        koStyle:"/js/base",
    },
    shim: { //定义css
        bootstrap: {
            deps: ['css!https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css']
        },

        koStyle:{
            deps:['jquery','css!/css/koStyle.css']
        }

    }
});

