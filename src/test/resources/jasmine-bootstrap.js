var require = function(path) {
  load(Java.type("dasniko.spock.nashorn.JasmineSpec").class.getResource(path).toExternalForm());
};

var window = this;

require("/jasmine-core/lib/jasmine-core/jasmine.js");
require("/jasmine-html-polyfill.js");
require("/jasmine-core/lib/jasmine-core/boot.js");
load({script: __jasmineSpec__, name: __jasmineSpecName__});

onload();

jsApiReporter.specs();