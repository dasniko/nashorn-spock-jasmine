var global = this;
var window = this;
window.location = {};

var console = {};
console.debug = print;
console.warn = print;
console.log = print;

setTimeout = function (fn, delay) {
    fn();
    return 0;
};
clearInterval = clearTimeout = function (id) {};
setInterval = function (fn, delay) {};
